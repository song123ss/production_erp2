package com.nosuchteam.bean;

import java.util.List;

/**
 * yuexia
 * 2018/12/6
 * 10:30
 */
public class OrderJson {
    int total;
    List<Order> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderJson{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public List<Order> getRows() {
        return rows;
    }

    public void setRows(List<Order> rows) {
        this.rows = rows;
    }
}
