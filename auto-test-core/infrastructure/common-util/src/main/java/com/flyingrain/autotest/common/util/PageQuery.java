package com.flyingrain.autotest.common.util;

public class PageQuery <T>{
    private int currentPage;

    private int pageSize;

    private T conditions;

    public PageQuery() {
    }

    public PageQuery(int currentPage, int pageSize, T conditions) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.conditions = conditions;
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

    public T getConditions() {
        return conditions;
    }

    public void setConditions(T conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "PageQuery{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", Conditions=" + conditions +
                '}';
    }
}
