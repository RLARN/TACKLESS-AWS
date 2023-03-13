package com.example.FirstSpingProject.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.example.FirstSpingProject.dto.ArticleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FirstSpingProject.entity.Article;
import com.example.FirstSpingProject.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.dynamic.TargetType;

@Slf4j
@Service // 서비스 선언!(서비스 객채를 스트링부트에 선언)
public class ArticleService {
    @Autowired // di
    private ArticleRepository articleRepository;

    public List<Article> index() {

        return articleRepository.findAll();

    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);

    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();
        if (article.getId() != null) {
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {

        // 1. 수정용 엔티티 생성
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());

        // 2. 대상 엔티티 찾기
        Article target = articleRepository.findById(id).orElse(null);

        // 3. 잘못된 요청 처리(대상이 없거나, id가 다른경우)
        if (target == null || id != article.getId()) {
            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
            return null;
        }

        // 4. 업데이트
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;

    }

    public Article delete(Long id) {
        // 1.대상 Entity찾기
        Article target = articleRepository.findById(id).orElse(null);

        // 2. 잘못된 요청 처리 (대상이 없는경우)
        if (target == null) {
            return null;
        }

        // 3. 대상 삭제후 응답 반환.
        articleRepository.delete(target);

        return target;
    }

    @Transactional
    //해당 메소드를 트랜젝션으로 묶는다!
    //실패하면 이 매소드 시전 이전상태로 롤백한다.
    public List<Article> createArticles(List<ArticleForm> dtos) {
        // dto 묶음을 entitiy 묶음으로 변환
        List<Article> articleList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());

        // entity 묶음을 db로 저장
        articleList.stream()
                .forEach(article -> articleRepository.save(article));

        // 강제 예외 발생
        articleRepository.findById(-1L).orElseThrow(
                () -> new IllegalArgumentException("결재 실패!!!!!!!!!!!"));

        // 결과 값 변환
        return articleList;
    }
}
