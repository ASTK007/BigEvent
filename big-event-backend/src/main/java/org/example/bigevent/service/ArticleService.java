package org.example.bigevent.service;

import org.example.bigevent.pojo.Article;
import org.example.bigevent.pojo.PageBean;

public interface ArticleService {
    void add(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    Article findById(Integer id);

    void update(Article article);

    void delete(Integer id);
}
