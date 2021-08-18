package kr.ac.yonsei.maist.snake.domain.comment.dao;

import kr.ac.yonsei.maist.snake.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
