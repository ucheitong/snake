package kr.ac.yonsei.maist.snake.domain.rank.dao;

import kr.ac.yonsei.maist.snake.domain.rank.domain.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepository extends JpaRepository<Rank, Integer> {
}
