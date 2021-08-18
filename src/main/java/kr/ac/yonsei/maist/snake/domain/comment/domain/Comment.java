package kr.ac.yonsei.maist.snake.domain.comment.domain;

import kr.ac.yonsei.maist.snake.domain.reply.domain.Reply;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Collection;


@Getter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "tbl_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private int commentId;

    @Column(name = "var_name")
    private String name;

    @Column(name = "var_content")
    private String content;
/*
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="commentID")
    public Collection<Reply> reply;
*/
    @Column(name = "date_create")
    private String createDate;

    @Builder
    public Comment(String name, String content){
        this.name = name;
        this.content = content;
    }
}
