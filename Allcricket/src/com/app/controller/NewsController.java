package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.News;
import com.app.service.INewsService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private INewsService service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	@GetMapping
	public ResponseEntity<?> listNews() {
		System.out.println("in list news");
		List<News> allNews = service.getAllNews();
		if (allNews.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<News>>(allNews, HttpStatus.OK);
	}
	

	@GetMapping("/{news_id}")
	public ResponseEntity<?> getNewsDetails(@PathVariable int news_id) {
		System.out.println("in news dtls " + news_id);
		News n = service.getNewsById(news_id);
		if (n == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<News>(n, HttpStatus.OK);
	}
	
}
