package com.app.service;

import java.util.List;

import com.app.pojos.News;

public interface INewsService {

	List<News> getAllNews();
	News addNewNews(News n);
	void deleteNews(int newsId);
	News getNewsById(int newsId);

}
