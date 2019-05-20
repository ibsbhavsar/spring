package com.main.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.main.model.Article;
import com.main.sevice.ArticleService;

@RestController
@RequestMapping(path = "/crud")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/international")
	public String helloInternationalization(@RequestHeader(name = "Accepet-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}

	@GetMapping(path = "/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("article_list");
		List<Article> articleList = articleService.getAllArticles();
		modelAndView.addObject("articleList", articleList);
		return modelAndView;
	}

	@GetMapping(path = "/addArticle/")
	public ModelAndView addArticle() {
		ModelAndView modelAndView = new ModelAndView();
		Article article = new Article();
		modelAndView.addObject("articleForm", article);
		modelAndView.setViewName("article_form");
		return modelAndView;
	}

	@PostMapping(path = "/saveArticle")
	public ModelAndView save(@ModelAttribute("articleForm") Article article) {

		articleService.saveOrUpdate(article);
		return new ModelAndView("redirect:/crud/list");
	}

	@GetMapping(path = "/updateArticle/{id}")
	public ModelAndView editArticle(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		Article article = articleService.getArticleById(id);
		modelAndView.addObject("articleForm", article);
		modelAndView.setViewName("article_form");
		return modelAndView;
	}

	@GetMapping(path = "/deleteArticle/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("article_list");
		articleService.deleteArticle(id);
		modelAndView.addObject("articleList", articleService.getAllArticles());
		return modelAndView;
	}
}
