package com.example.zheng.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "movies")
public class Movies {
    @Id
    private String id;
    private String title;
    private String[] genre;
    private long year;
}
