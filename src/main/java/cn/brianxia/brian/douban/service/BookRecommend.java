package cn.brianxia.brian.douban.service;

import cn.brianxia.brian.douban.dao.DoubanBookDao;
import cn.brianxia.brian.douban.entity.DoubanBook;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping(value = "/api")
public class BookRecommend{

    private static final Logger logger = LogManager.getLogger(BookRecommend.class);

    @Autowired
    private DoubanBookDao doubanBookDao;

    @ApiOperation(value="测试用接口", notes="测试用接口信息")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public List<DoubanBook> getBookRecommend(){

        List<DoubanBook> books = doubanBookDao.findAll();

        return books;
    }

    @ApiOperation(value="查询分页接口", notes="查询分页接口")
    @RequestMapping(value = "/doubanbook",method = RequestMethod.GET)
    public List<DoubanBook> getBookRecommendbyPage( @RequestParam(value = "page") int page,
                                                    @RequestParam(value = "size") int size){

        List<DoubanBook> books = doubanBookDao.findByPage(page,size);

        return books;
    }

    @ApiOperation(value="查询分页页数", notes="查询分页页数")
    @RequestMapping(value = "/doubanbookpage",method = RequestMethod.GET)
    public Long getBookRecommendPage( @RequestParam(value = "size") int size){

        return doubanBookDao.findPageNum(size);

    }
}