package kr.ac.yonsei.maist.snake.domain.reply.dao;


import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.ac.yonsei.maist.snake.domain.comment.domain.Comment;
import kr.ac.yonsei.maist.snake.domain.reply.domain.Reply;
import static kr.ac.yonsei.maist.snake.domain.reply.domain.QReply.reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ReplyQueryFactory {

    private final JPAQueryFactory queryFactory;

    public List<Reply> findReplyAllByCommentId(Comment comment) {
        return queryFactory
                .select(reply)
                .from(reply)
                .where(reply.comment.eq(comment))
                .fetch();
    }
}
