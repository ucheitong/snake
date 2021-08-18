package kr.ac.yonsei.maist.snake.domain.comment.service;

import kr.ac.yonsei.maist.snake.domain.comment.dao.CommentRepository;
import kr.ac.yonsei.maist.snake.domain.comment.domain.Comment;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    @NonNull
    private CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public List<Comment> findCommentAll() throws Exception {
        List<Comment> commentList = commentRepository.findAll();

        return commentList;
    }

    @Transactional
    public Comment createComment(String name, String content) throws Exception {

        Comment comment = Comment.builder().name(name).content(content).build();

        commentRepository.save(comment);

        return comment;
    }

    @Transactional(readOnly = true)
    public Comment findCommentById(int commentId) throws Exception {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("id="+commentId));

        return comment;
    }

}
