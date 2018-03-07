package cn.brianxia.brian.douban.entity;

import lombok.Data;

@Data
public class DoubanBook {

    private String name;
    private String author;
    private String publisher;
    private Double star;
    private Double price;
}
