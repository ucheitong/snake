package kr.ac.yonsei.maist.snake.domain.rank.api;


import kr.ac.yonsei.maist.snake.domain.rank.domain.Rank;
import kr.ac.yonsei.maist.snake.domain.rank.service.RankService;
import kr.ac.yonsei.maist.snake.global.response.dataMessage.GeneralDataMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RankApi {

    private final RankService rankService;

    @GetMapping("/game/rank")
    public ResponseEntity<GeneralDataMessage> findRankAll() throws Exception {

        List<Rank> rankList = rankService.findRankAll();

        GeneralDataMessage responseMessage = GeneralDataMessage.builder()
                .data(rankList)
                .build();

        return new ResponseEntity<GeneralDataMessage>(responseMessage, HttpStatus.OK);
    }

    @PostMapping("/game/rank")
    public ResponseEntity<GeneralDataMessage> createRank(@Valid @RequestParam(value="name") String name,
                                                         @Valid @RequestParam(value="score") int score) throws Exception {

        Rank rank = rankService.createRank(name,score);

        GeneralDataMessage responseMessage = GeneralDataMessage.builder()
                .data(rank)
                .build();

        return new ResponseEntity<GeneralDataMessage>(responseMessage, HttpStatus.OK);
    }

}
