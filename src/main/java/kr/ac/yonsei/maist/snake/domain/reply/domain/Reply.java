package kr.ac.yonsei.maist.snake.domain.reply.domain;

import kr.ac.yonsei.maist.snake.domain.comment.domain.Comment;
import kr.ac.yonsei.maist.snake.domain.comment.service.CommentService;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "tbl_reply")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reply")
    private int replyId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_comment")
    private Comment comment;

    @Column(name = "var_name")
    private String name;

    @Column(name = "var_content")
    private String content;

    @Column(name = "date_create")
    private String createDate;

    @Builder
    public Reply(Comment comment, String name, String content){

        this.comment = comment;
        this.name = name;
        this.content = content;
    }

}
