package com.chen.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageList<T> {

    private Long total = 0L;    // 总条数

    private List<T> rows = new ArrayList<>(); // 当前页要展示的数据
}
