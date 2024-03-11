package com.flyingrain.autotest.common.util;

import java.util.List;

public class PageableModel<T>{

    private int currentPage=1;

    private int pageSize = 10;

    private int total = 0;

    private List<T> data;

    public void copyOf(PageQuery pageQuery){
        this.currentPage = pageQuery.getCurrentPage();
        this.pageSize = pageQuery.getPageSize();
    }

    public static <M> PageableModel<M> copy(PageableModel target){
        PageableModel<M> pageableModel = new PageableModel<>();
        pageableModel.setTotal(target.getTotal());
        pageableModel.setCurrentPage(target.getCurrentPage());
        pageableModel.setPageSize(target.getPageSize());
        return pageableModel;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageableModel{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
