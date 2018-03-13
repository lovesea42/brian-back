package cn.brianxia.brian.douban.dao;

import cn.brianxia.brian.douban.entity.DoubanBook;

import java.util.List;

public interface DoubanBookDao {
    List<DoubanBook> findAll();
    List<DoubanBook> findByPage(int page,int size);
    Long findPageNum(int size);
}
