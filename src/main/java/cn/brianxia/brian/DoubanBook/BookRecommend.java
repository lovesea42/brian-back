package cn.brianxia.brian.DoubanBook;

import cn.brianxia.brian.DoubanBook.entity.DoubanBook;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
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
        DoubanBook book = new DoubanBook();
        book.setName("aaa");
        book.setAuthor("xiadong");
        book.setPrice(69.5f);
        book.setPublisher("XXDD出版社");
        book.setStar(8.7f);

        DoubanBook book2 = new DoubanBook();
        book2.setName("bbb");
        book2.setAuthor("xiadong1");
        book2.setPrice(102.5f);
        book2.setPublisher("XXXX出版社");
        book2.setStar(2.3f);

        List<DoubanBook> books = new ArrayList<DoubanBook>();
        books.add(book);
        books.add(book2);
        logger.info("info execute index method");
        logger.warn("warn execute index method");
        logger.error("error execute index method");
        return books;
    }
}