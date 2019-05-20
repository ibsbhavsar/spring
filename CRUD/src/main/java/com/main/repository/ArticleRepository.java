package com.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.main.model.Article;

public interface ArticleRepository extends CrudRepository<Article, Integer> {

}
