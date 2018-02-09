package com.brianxia.brian.DoubanBook;

import com.brianxia.brian.DoubanBook.entity.DoubanBook;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class BookRecommend{

    @RequestMapping(value = "/test")
    public DoubanBook getBookRecommend(){
        DoubanBook book = new DoubanBook();
        book.setName("aaa");
        return book;
    }
}