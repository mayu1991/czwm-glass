package com.czwm.common.page;

import com.czwm.common.ReflectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.RowBounds;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * mybatis 自动分页和统计的拦截器<br>
 * 通过Pagination组件来控制
 *
 * @author liuchao2
 */
@Component
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = {
        Connection.class }) })
public class PaginationInterceptor implements Interceptor {

    private static Logger logger = LoggerFactory.getLogger(PaginationInterceptor.class);

    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = MetaObject
                .forObject(statementHandler, DEFAULT_OBJECT_FACTORY,
                        DEFAULT_OBJECT_WRAPPER_FACTORY);
        // 分离代理对象链
        while (metaStatementHandler.hasGetter("h")) {
            Object object = metaStatementHandler.getValue("h");
            metaStatementHandler = MetaObject
                    .forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        }
        // 分离最后一个代理对象的目标类
        while (metaStatementHandler.hasGetter("target")) {
            Object object = metaStatementHandler.getValue("target");
            metaStatementHandler = MetaObject
                    .forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        }

        StatementHandler delegate = null;
        try {
            delegate = (StatementHandler) metaStatementHandler.getValue("delegate");
        } catch (Exception e) {
            return invocation.proceed();
        }
        //获取分页属性
        RowBounds rowBounds = (RowBounds) ReflectUtils.getValueByFieldName(delegate, "rowBounds");

        if (null != rowBounds && rowBounds instanceof Pagination) {
            String sql = delegate.getBoundSql().getSql();

            Pagination page = (Pagination) rowBounds;

            //如果需要统计所有记录数
            if (page.isCalculate()) {
                Connection connection = (Connection) invocation.getArgs()[0];
                logger.info("get page info before calculate : " + page);
                calculate(delegate, connection, page);
                logger.info("get page info after calculate:" + page);
            }

            //排序接口
            Map<String, String> sortFields = page.getSortFields();

            if (null != sortFields && !sortFields.isEmpty()) {
                StringBuilder sortGrammar = new StringBuilder();

                for (Map.Entry<String, String> ele : sortFields.entrySet()) {
                    if (null != ele) {
                        sortGrammar.append(StringUtils.isNotBlank(ele.getKey()) ?
                                ele.getKey() + " " :
                                "");
                        sortGrammar.append(StringUtils.isNotBlank(ele.getValue()) ?
                                ele.getValue() + "," :
                                "");
                    }
                }

                if (StringUtils.isNotBlank(sortGrammar.toString())) {
                    sql = sql + (" order by " + StringUtils
                            .substringBeforeLast(sortGrammar.toString(), ","));
                }
            }

            //如果需要分页操作
            if (page.isPaginate()) {
                if (sql.indexOf("limit") < 0) {
                    int start = (page.getCurrentPage() - 1) * (page.getPageSize());
                    String limitGramar = sql + " limit " + start + "," + page.getPageSize();
                    ReflectUtils.setValueByFieldName(delegate.getBoundSql(), "sql", limitGramar);
                } else {
                    logger.warn("sql statement has already contained 'limit' grammar!");
                }
            }
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * 统计总数
     *
     * @param page
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonGenerationException
     */
    private void calculate(StatementHandler statementHandler, Connection connection,
            Pagination page) throws Exception {
        BoundSql bs = statementHandler.getBoundSql();

        if (StringUtils.trim(bs.getSql().toUpperCase()).startsWith("SELECT")) {
            PreparedStatement countPs = null;
            ResultSet rs = null;
            int totalCount = 0;
            String countSql = "select count(1) from (" + bs.getSql() + ") as total";
            try {
                countPs = connection.prepareStatement(countSql);
                statementHandler.getParameterHandler().setParameters(countPs);
                rs = countPs.executeQuery();
                logger.info("countSql = " + countSql);
                while (rs.next()) {
                    totalCount = rs.getInt(1);
                    page.setTotalCount(totalCount);
                }
            } catch (SQLException e) {
                logger.error("calculate error", e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (countPs != null) {
                    countPs.close();
                }
            }

            if (totalCount > 0) {
                int totalPage =
                        totalCount / page.getPageSize() + (totalCount % page.getPageSize() > 0 ?
                                1 :
                                0);
                page.setPage(totalPage);
            }
        }
    }
}
