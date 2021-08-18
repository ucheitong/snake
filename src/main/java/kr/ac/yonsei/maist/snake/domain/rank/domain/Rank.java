package kr.ac.yonsei.maist.snake.domain.rank.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tbl_rank")
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rank")
    private int rankId;

    @Column(name = "var_name")
    private String name;

    @Column(name = "int_score")
    private int score;

    @Builder
    public Rank(String name, int score){
        this.name = name;
        this.score = score;
    }

}
