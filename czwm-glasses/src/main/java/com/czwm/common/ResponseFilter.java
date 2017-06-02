package com.czwm.common;

import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hvk687 on 1/4/16.
 */
public class ResponseFilter implements Filter {

    //是否开启跨域
    private boolean originSwitch;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String originSwitch = filterConfig.getInitParameter("originSwitch");
        this.originSwitch = Boolean.valueOf(originSwitch);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException,
            ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String origin = request.getHeader("Origin");

        //跨域开关如果打开，则需要验证访问域名
        boolean originFlag = !originSwitch ||
                StringUtils.isNotBlank(origin);

        if (originFlag) {
            response.setHeader("Access-Control-Allow-Origin", origin);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            //response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            //response.setHeader("Access-Control-Max-Age", "3600");
            //response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
