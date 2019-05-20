package com.main.sevice;

import java.util.List;

import com.main.model.Article;

public interface ArticleService {

	public List<Article> getAllArticles();

	public Article getArticleById(int id);

	public void saveOrUpdate(Article article);

	public void deleteArticle(int id);
}
