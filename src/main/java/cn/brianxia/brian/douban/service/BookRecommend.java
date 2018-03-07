package cn.brianxia.brian.douban.service;

import cn.brianxia.brian.douban.entity.DoubanBook;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.bson.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping(value = "/api")
public class BookRecommend{

    private static final Logger logger = LogManager.getLogger(BookRecommend.class);

    @ApiOperation(value="测试用接口", notes="测试用接口信息")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public List<DoubanBook> getBookRecommend(){

        List<DoubanBook> books = new ArrayList<DoubanBook>();
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("book");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("dangdang");
            System.out.println("集合 test 选择成功");

            //检索所有文档
            /**
             * 1. 获取迭代器FindIterable<Document>
             * 2. 获取游标MongoCursor<Document>
             * 3. 通过游标遍历检索出的文档集合
             * */
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                Document data =  mongoCursor.next();
                DoubanBook book = new DoubanBook();
                book.setName((String)data.get("name"));
                book.setAuthor("xiadong");
                book.setPrice(69.5);
                book.setPublisher("XXDD出版社");
                book.setStar((Double)data.get("rating_nums"));
                books.add(book);
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }

        return books;
    }
}