package kr.ac.yonsei.maist.snake.domain.reply.service;


import kr.ac.yonsei.maist.snake.domain.comment.domain.Comment;
import kr.ac.yonsei.maist.snake.domain.reply.dao.ReplyQueryFactory;
import kr.ac.yonsei.maist.snake.domain.reply.dao.ReplyRepository;
import kr.ac.yonsei.maist.snake.domain.reply.domain.Reply;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {

    @NonNull
    private ReplyRepository replyRepository;
    @Autowired
    private ReplyQueryFactory replyQueryFactory;


    @Transactional(readOnly = true)
    public List<Reply> findReplyAllByCommentID(Comment comment) throws Exception {

        List<Reply> replyList = replyQueryFactory.findReplyAllByCommentId(comment);

        return replyList;
    }

    @Transactional
    public Reply createReply(Comment comment, String name, String content) throws Exception {

        Reply reply = Reply.builder().comment(comment).name(name).content(content).build();

        replyRepository.save(reply);

        return reply;
    }


}
