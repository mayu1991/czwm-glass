package com.czwm.common.page;

import org.apache.ibatis.session.RowBounds;

import java.util.Map;

/**
 * mysql 物理分页参数
 * @author liuchao2
 *
 */
public class Pagination extends RowBounds {

    //>>>>>>>>>>存放结果
    /** 总记录数 */
    private int totalCount;
    
    /** 总页数 */
    private int page;
    

    //>>>>>>>>>>存放参数
    /** 当前页 */
    private int currentPage =1;
    
    /** 每页记录数 */
    private int pageSize =10;
    
    /** 是否统计 */
    private boolean calculate = true;
    
    /** 是否分页 */
    private boolean paginate = true;
    
    /** 排序字段 */
    private Map<String, String> sortFields; 

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isCalculate() {
        return calculate;
    }

    public void setCalculate(boolean calculate) {
        this.calculate = calculate;
    }

    public boolean isPaginate() {
        return paginate;
    }

    public void setPaginate(boolean paginate) {
        this.paginate = paginate;
    }

    public Map<String, String> getSortFields() {
        return sortFields;
    }

    public void setSortFields(Map<String, String> sortFields) {
        this.sortFields = sortFields;
    }

    @Override
    public String toString() {
        return "Pagination [totalCount=" + totalCount + ", page=" + page + ", currentPage=" + currentPage
                + ", pageSize=" + pageSize + ", calculate=" + calculate + ", paginate=" + paginate + "]";
    }
    
    
}
