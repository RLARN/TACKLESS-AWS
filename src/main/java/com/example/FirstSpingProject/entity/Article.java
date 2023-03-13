package com.example.FirstSpingProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // 엔티티 선언

// @Entity를 적용하면
// 그 대상 클래스명(Article)으로
// 테이블이 생성

@AllArgsConstructor // 생성자 생성
@NoArgsConstructor // 디폴트 생성자 생성
@ToString
@Getter
@Setter
public class Article {

    @Id // 주민번호 같은것
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성을 위한 어노테이션
    // DB가 id값을 아라서 생성하는 김치!!
    private Long id;

    @Column // 컬럼 단위
    private String title;

    @Column // db에서 컬럼 인식 위해
    private String content;

    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }

    // 생성자 추가, tosting 메소드 추가
}
