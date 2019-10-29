package com.wyu160802.dto;

import com.wyu160802.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * @author 黄明潘
 */
@Data
public class Pager<T extends BaseEntity> implements Serializable {

    /**
     *  每页显示多少条记录
     */
    private int pageSize;

    /**
     * 当前第几页数据
     */
    private int currentPage;

    /**
     * 一共多少条记录
     */
    private int total;

    /**
     * 一共多少页记录
     */
    private int totalPage;

    /**
     *    要显示的数据
     */
    private List<T> rows;

    public Pager(int pageNum, int pageSize, List<T> sourceList){
        if(sourceList == null || sourceList.isEmpty()){
            this.pageSize = pageSize;
            this.currentPage = 0;
            this.total = 0;
            this.totalPage = 0;
            this.rows = sourceList;
            return;
        }
        // 每页显示多少条记录
        this.pageSize = pageSize;

        // 总记录条数
        this.total = sourceList.size();


        //获取总页数
        this.totalPage = this.total / this.pageSize;
        if(this.total % this.pageSize !=0){
            this.totalPage = this.totalPage + 1;
        }

        // 当前第几页数据
        this.currentPage = this.totalPage < pageNum ?  this.totalPage : pageNum;

        // 起始索引
        int fromIndex	= this.pageSize * (this.currentPage -1);

        // 结束索引
        int toIndex  = this.pageSize * this.currentPage > this.total ? this.total : this.pageSize * this.currentPage;

        this.rows = sourceList.subList(fromIndex, toIndex);
    }

    public Pager(){

    }

    public Pager(int pageSize, int currentPage, int total, int totalPage, List<T> rows) {
        super();
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.total = total;
        this.totalPage = totalPage;
        this.rows = rows;
    }
}
