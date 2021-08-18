package kr.ac.yonsei.maist.snake.domain.comment.api;

import kr.ac.yonsei.maist.snake.domain.comment.domain.Comment;
import kr.ac.yonsei.maist.snake.domain.comment.service.CommentService;
import kr.ac.yonsei.maist.snake.global.response.dataMessage.GeneralDataMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentApi {
    @NonNull
    private final CommentService commentService;


    @GetMapping("/game/comment")
    public ResponseEntity<GeneralDataMessage> findCommentAll() throws Exception {

        List<Comment> commentList = commentService.findCommentAll();

        GeneralDataMessage responseMessage = GeneralDataMessage.builder()
                .data(commentList)
                .build();

        return new ResponseEntity<GeneralDataMessage>(responseMessage, HttpStatus.OK);
    }

    @PostMapping("/game/comment")
    public ResponseEntity<GeneralDataMessage> createRank(@Valid @RequestParam(value="name") String name,
                                                         @Valid @RequestParam(value="content") String content) throws Exception {

        Comment comment = commentService.createComment(name, content);

        GeneralDataMessage responseMessage = GeneralDataMessage.builder()
                .data(comment)
                .build();

        return new ResponseEntity<GeneralDataMessage>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/game/comment/{commentId}")
    public ResponseEntity<GeneralDataMessage> findCommentById(@Valid @PathVariable int commentId) throws Exception {

        Comment comment = commentService.findCommentById(commentId);

        GeneralDataMessage responseMessage = GeneralDataMessage.builder()
                .data(comment)
                .build();

        return new ResponseEntity<GeneralDataMessage>(responseMessage, HttpStatus.OK);
    }
}
