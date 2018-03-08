package cn.brianxia.brian.douban.dao;

import cn.brianxia.brian.douban.entity.DoubanBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("doubanBookDao")
public class DoubanBookDaoImp implements DoubanBookDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<DoubanBook> findAll() {

        return mongoTemplate.findAll(DoubanBook.class);
    }

    @Override
    public List<DoubanBook> findByPage(int page, int size) {
        Pageable pageable=PageRequest.of(page,size);
        return mongoTemplate.find(new Query().with(pageable),DoubanBook.class);
    }
}
