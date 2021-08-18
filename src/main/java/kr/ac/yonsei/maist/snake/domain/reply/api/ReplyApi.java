package kr.ac.yonsei.maist.snake.domain.reply.api;

import kr.ac.yonsei.maist.snake.domain.comment.domain.Comment;
import kr.ac.yonsei.maist.snake.domain.comment.service.CommentService;
import kr.ac.yonsei.maist.snake.domain.reply.domain.Reply;
import kr.ac.yonsei.maist.snake.domain.reply.service.ReplyService;
import kr.ac.yonsei.maist.snake.global.response.dataMessage.GeneralDataMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReplyApi {

    private final ReplyService replyService;
    private final CommentService commentService;

    @GetMapping("/game/reply/{commentId}")
    public ResponseEntity<GeneralDataMessage> findReplyAllByCommentId(@Valid @PathVariable(value="commentId") int commentID) throws Exception {

        Comment comment = commentService.findCommentById(commentID);

        List<Reply> replyList = replyService.findReplyAllByCommentID(comment);

        GeneralDataMessage responseMessage = GeneralDataMessage.builder()
                .data(replyList)
                .build();

        return new ResponseEntity<GeneralDataMessage>(responseMessage, HttpStatus.OK);
    }

    @PostMapping("/game/reply/{commentId}")
    public ResponseEntity<GeneralDataMessage> createReply(@Valid @PathVariable(value="commentId") int commentID,
                                                         @Valid @RequestParam(value="name") String name,
                                                         @Valid @RequestParam(value="content") String content) throws Exception {

        Comment comment = commentService.findCommentById(commentID);

        Reply reply = replyService.createReply(comment,name,content);

        GeneralDataMessage responseMessage = GeneralDataMessage.builder()
                .data(reply)
                .build();

        return new ResponseEntity<GeneralDataMessage>(responseMessage, HttpStatus.OK);
    }

}
