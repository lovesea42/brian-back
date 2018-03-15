package cn.brianxia.brian.douban.dao;

import cn.brianxia.brian.douban.entity.DoubanBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.regex.Pattern;

@Repository("doubanBookDao")
public class DoubanBookDaoImp implements DoubanBookDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<DoubanBook> findAll() {

        return mongoTemplate.findAll(DoubanBook.class);
    }

    private Query getQuery(String keyword){
        Query q = new Query();
        if(keyword != null && keyword.length() > 0){
            Criteria criteria = new Criteria();
            Pattern pattern = Pattern.compile("^.*"+keyword +".*$", Pattern.CASE_INSENSITIVE);
            criteria.orOperator(Criteria.where("name").is(pattern),Criteria.where("author").is(pattern)
                    ,Criteria.where("tags").is(pattern));
            q.addCriteria(criteria);
        }
        return q;
    }

    @Override
    public List<DoubanBook> findByPage(int page, int size,String keyword) {
        Pageable pageable=PageRequest.of(page,size);


        return mongoTemplate.find(getQuery(keyword).with(pageable),DoubanBook.class);
    }

    @Override
    public Long findPageNum(int size,String keyword) {
        if(size <= 0)
            return 0L;
        long totalCount = this.mongoTemplate.count(getQuery(keyword), DoubanBook.class);
        return totalCount % size == 0 ? totalCount/size: totalCount/size+1;
    }

    @Override
    public Long findTotalNum(String keyword) {
        long totalCount = this.mongoTemplate.count(getQuery(keyword), DoubanBook.class);
        return totalCount;
    }
}
