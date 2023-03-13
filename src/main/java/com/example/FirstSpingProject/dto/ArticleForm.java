package com.example.FirstSpingProject.dto;

import com.example.FirstSpingProject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor//롬북
@Getter
@Setter
@NoArgsConstructor//vsc에서 작동 불가능해서 이것을 넣었더니 작동되었다. 인텔리j에서는 잘 되었는뎅 아래는 인터넷에서 찾은 설명이다.

//Lombok을 사용하면 생성자도 자동으로 생성할 수 있습니다. @NoArgsConstructor 어노테이션은 파라미터가 없는 기본 생성자를 생성해주고,
//@AllArgsConstructor 어노테이션은 모든 필드 값을 파라미터로 받는 생성자를 만들어줍니다. 마지막으로 @RequiredArgsConstructor 
//어노테이션은 final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만들어줍니다.

@ToString


public class ArticleForm {

    private Long id;
    private String title;
    private String content;

    //dto의 필드명과 동일한 이름으로 new.mustache 파일의 name tag로 작성해야한다.
    //<textarea class="form-control" rows="3" name="content"></textarea> 이런식으로

    public Article toEntity() {
        return new Article(id,title,content);
        //DTO인 폼에서 엔티티 메소드로 변환해주는 메소드
    }
}