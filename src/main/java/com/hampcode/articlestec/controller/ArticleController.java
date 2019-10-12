package com.hampcode.articlestec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hampcode.articlestec.common.PageInitPagination;
import com.hampcode.articlestec.service.ArticleService;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private PageInitPagination pageInitPagination;
	
	protected static final String ARTICLE_VIEW_PAGE="articles/allArticles";
	
	@GetMapping
	public ModelAndView getAllArticles(@RequestParam("pageSize") 
			Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView mv=pageInitPagination.initPagination(pageSize, page,
				ARTICLE_VIEW_PAGE);
		return mv;
	}
	
}
