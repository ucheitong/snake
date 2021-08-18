package kr.ac.yonsei.maist.snake.domain.comment.dao;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CommentQueryFactory {
    private final JPAQueryFactory queryFactory;
}
