package com.example.zheng.repository;

import com.example.zheng.entity.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface MoviesRepository extends ElasticsearchRepository<Movies, String> {
    //            @Query("{\"bool\":{\"must\":[{\"match\":{\"title\":\"?0\"}}]}}")
    Page<Movies> findByTitle(String title, Pageable pageable);


    Page<Movies> findByTitleAndGenre(String title, String genre, Pageable pageable);


    Page<Movies> findByTitleIn(List<String> titles, Pageable pageable);
}
