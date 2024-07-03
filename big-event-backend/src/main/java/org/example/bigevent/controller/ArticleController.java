package org.example.bigevent.controller;

import org.example.bigevent.pojo.Article;
import org.example.bigevent.pojo.PageBean;
import org.example.bigevent.pojo.Result;
import org.example.bigevent.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PostMapping
    public Result add(@RequestBody @Validated Article article){
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ){
        PageBean<Article> pageBean = articleService.list(pageNum,pageSize,categoryId,state);
        return Result.success(pageBean);
    }
    @GetMapping("/detail")
    public  Result<Article> detail(@RequestParam Integer id){
        Article article = articleService.findById(id);
        return Result.success(article);
    }
    @PutMapping
    public Result<Article> update(@RequestBody @Validated Article article){
        articleService.update(article);
        return Result.success();
    }
    @DeleteMapping
    public Result<Article> delete(@RequestParam Integer id){
        articleService.delete(id);
        return Result.success();
    }
}
