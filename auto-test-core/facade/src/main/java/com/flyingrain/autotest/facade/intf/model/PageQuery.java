package com.flyingrain.autotest.facade.intf.model;

public class PageQuery <T>{
    private int currentPage;

    private int pageSize;

    private T Conditions;

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
        return Conditions;
    }

    public void setConditions(T conditions) {
        Conditions = conditions;
    }

    @Override
    public String toString() {
        return "PageQuery{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", Conditions=" + Conditions +
                '}';
    }
}
