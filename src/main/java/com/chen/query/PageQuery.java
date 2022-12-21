package com.chen.query;

import lombok.Data;

@Data
public class PageQuery {

    private Integer currentPage = 1;    // 当前页，默认第一页

    private Integer pageSize = 10;  //  每页显示条数

    private String keyword; // 搜索关键字

    public Integer getStart() {
        return (this.currentPage-1)*this.pageSize;
    }
}
