package com.app.controller;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.News;
import com.app.pojos.Tournaments;
import com.app.service.INewsService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/news")
@MultipartConfig
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
	@GetMapping("/no")
	public ResponseEntity<?> noOfNews() {
		System.out.println("in list news");
		List<News> allNews = service.getAllNews();
		int no = allNews.size();
	    return ResponseEntity.ok(Collections.singletonMap("count", no));
	}
	

	@GetMapping("/{news_id}")
	public ResponseEntity<?> getNewsDetails(@PathVariable int news_id) {
		System.out.println("in news dtls " + news_id);
		News n = service.getNewsById(news_id);
		if (n == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<News>(n, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> addNewsDetails(@RequestParam String description,
			@RequestParam String category,@RequestParam String heading
			,@RequestParam MultipartFile image,@RequestParam String date) 
	{
		System.out.println("in add tournaments dtls " );
		try {
			Date sDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(date);

			News n = new News(sDate,category,heading,description);
			if (image != null) {
				// image is supplied
				n.setImage(image.getBytes());
			}
			return new ResponseEntity<News>(service.addNewNews(n), HttpStatus.CREATED);
		} catch (Exception e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

    }
	@DeleteMapping("/{news_id}")
	public ResponseEntity<Void> deletePlayerDetails(@PathVariable int news_id) {
		System.out.println("del match dtls " + news_id);
		service.deleteNews(news_id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	

	@PutMapping("/{news_id}")
	public ResponseEntity<?> UpdateNewsDetails(@RequestParam String date,@RequestParam String category,
			@RequestParam String heading,@RequestParam String description,
			@RequestParam(value = "image", required = false) MultipartFile image,@PathVariable int news_id
			)  {
		
		
		try {
			System.out.println("in update news " + news_id + " " + date + " " + category+" "+ heading +" "+ description);

			News newsDetails = service.getNewsById(news_id);
			if (newsDetails == null)
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			Date sDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(date);

			newsDetails.setDate(sDate);
			newsDetails.setCategory(category);
			newsDetails.setHeading(heading);
			newsDetails.setDescription(description);
			if (image != null) { // image is supplied
				newsDetails.setImage(image.getBytes());
			}
			return new ResponseEntity<News>(service.updateNewsDetails(newsDetails), HttpStatus.OK);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
