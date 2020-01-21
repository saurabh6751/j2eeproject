package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.INewsDao;
import com.app.pojos.News;

@Service // B.L methods
@Transactional
public class NewsServiceImpl implements INewsService{
	@Autowired
	private INewsDao dao;
	

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return dao.getAllNews();
	}
	
	@Override
	public News getNewsById(int newsId) {
		return dao.getNewsById(newsId);

	}
	
	@Override
	public News addNewNews(News n) {
		// TODO Auto-generated method stub
		return dao.addNewNews(n);
	}
	
	
	@Override
	public void deleteNews(int newsId) {
		News newsById = dao.getNewsById(newsId);
		if(newsById != null)
			dao.deleteNews(newsById);		
	}
}
