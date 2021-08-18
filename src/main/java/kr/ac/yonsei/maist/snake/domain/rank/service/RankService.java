package kr.ac.yonsei.maist.snake.domain.rank.service;

import kr.ac.yonsei.maist.snake.domain.rank.dao.RankQueryFactory;
import kr.ac.yonsei.maist.snake.domain.rank.dao.RankRepository;
import kr.ac.yonsei.maist.snake.domain.rank.domain.Rank;
import kr.ac.yonsei.maist.snake.domain.reply.domain.Reply;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RankService {

    @NonNull
    private RankRepository rankRepository;

    @Autowired
    private RankQueryFactory rankQueryFactory;

    @Transactional(readOnly = true)
    public List<Rank> findRankAll() throws Exception {
        List<Rank> rankList = rankRepository.findAll();

        return rankList;
    }

    @Transactional
    public Rank createRank(String name, int score) throws Exception {

        Rank rank = Rank.builder().name(name).score(score).build();

        rankRepository.save(rank);

        return rank;
    }
}
