package com.wyu160802.dto;

import com.wyu160802.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/2-15:24
 */
public class PageDto implements Serializable {
    private int total;
    private List<User> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<User> getRows() {
        return rows;
    }

    public void setRows(List<User> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageDto{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
