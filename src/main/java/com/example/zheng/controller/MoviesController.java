package com.example.zheng.controller;

import com.example.zheng.entity.Movies;
import com.example.zheng.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MoviesController {

    @Autowired
    private MoviesRepository moviesRepository;

//    http://127.0.0.1:8080/movies/search?title=mind
    @GetMapping(value = "/search")
    public Page<Movies> getPageDate(String title, String pageNumber) {
        // String text = "John Smith";

//        Page<Movies> movies =  moviesRepository.findAll(PageRequest.of(0, 10));

//        Page<Movies> movies =  moviesRepository.findAll(PageRequest.of(0,10));

//        String title = "beautiful";
        Page<Movies> movies = moviesRepository.findByTitle(title, PageRequest.of(0, 10));

        return movies;
    }

//    http://127.0.0.1:8080/movies/multi?title=mind&genre=romance
    @GetMapping("/multi")
    public Page<Movies> multiFieldsQuery(String title, String genre){

        Page<Movies> movies = moviesRepository.findByTitleAndGenre(title, genre, PageRequest.of(0, 10));
        return movies;
    }

//    http://127.0.0.1:8080/movies/in?titles=mind&titles=romance
    @GetMapping("/in")
    public Page<Movies> inQuery(String[] titles){
        Page<Movies> movies = moviesRepository.findByTitleIn(Arrays.asList(titles), PageRequest.of(0, 10));
        return movies;
    }
}
//    @GetMapping("/search")
//    public List<Movies> getPageData(@RequestParam String title,
//                                    @RequestParam(defaultValue = "1") Integer page,
//                                    @RequestParam(defaultValue = "10") Integer size){
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Movies> pageDate = moviesRepository.findByTitle(title, pageable);
//
//        return pageDate.getContent();
//    }

