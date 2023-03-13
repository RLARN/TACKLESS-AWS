package com.example.FirstSpingProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne // 해당 댓글 entity 여러개가, 하나의 article과 연관된다!! 다대일 설정
    @JoinColumn(name = "article_id")//"article_id" 컬럼에 article의 대표값을 저장!
    private Article article;

    @Column
    private String nickname;

    @Column
    private String body;

}
