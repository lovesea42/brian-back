package cn.brianxia.brian.douban.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@Document(collection="dangdang")
public class DoubanBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String _id;
    private String isbn;
    private String url;
    private String name;
    private String author;
    private String publisher;
    @Field("rating_nums")
    private Double star;
    private Double price;
    private String tags;
    private Long   comment;
}
