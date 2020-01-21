package com.app.dao;

import java.util.List;

import com.app.pojos.News;

public interface INewsDao {

	List<News> getAllNews();
	News addNewNews(News n);
	void deleteNews(News n);
	News getNewsById(int newsId);

}
