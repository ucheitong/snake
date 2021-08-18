package kr.ac.yonsei.maist.snake.domain.reply.dao;

import kr.ac.yonsei.maist.snake.domain.reply.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}
