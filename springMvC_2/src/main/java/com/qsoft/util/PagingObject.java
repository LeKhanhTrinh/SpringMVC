package com.qsoft.util;

import java.util.List;

/**
 * Created by hunglv on 4/10/14.
 */
public class PagingObject<T> {
    int currentPage;
    long totalPage;
    int sizeOfPage;

    List<T> objects;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public int getSizeOfPage() {
        return sizeOfPage;
    }

    public void setSizeOfPage(int sizeOfPage) {
        this.sizeOfPage = sizeOfPage;
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    public PagingObject() {
        currentPage = 0;
        totalPage = 0;
        sizeOfPage = 0;
        objects = null;
    }
}
