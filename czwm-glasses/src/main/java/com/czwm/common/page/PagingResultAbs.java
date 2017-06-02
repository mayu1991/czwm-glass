package com.czwm.common.page;

/**
 * 分页结果抽象类
 * Created by mayu on 2016/2/15.
 */
public abstract class PagingResultAbs<T> {

    //总数
    private int totalCount;
    
    //总页数
    private int totalPage;

    //数据
    private T data;

    public PagingResultAbs(){
        
    };
    
    public PagingResultAbs(int totalCount,int totalPage, T data){
        this.totalCount=totalCount;
        this.totalPage=totalPage;
        this.data = data;
    }
    
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
