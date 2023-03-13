package com.example.FirstSpingProject.repository;

import com.example.FirstSpingProject.entity.Article;
import org.springframework.data.repository.CrudRepository;//crud 리파지토리가 제공하는 기능을 정의없이 그대로 사용할수 있음.

import java.util.ArrayList;


public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    ArrayList<Article> findAll();
    //어레이 리스트 타입을 반환ㄴ

    //<관리대상 Entity, 대표값의 타입(Entity/article.java에서 지정한 대표값(id))>
}