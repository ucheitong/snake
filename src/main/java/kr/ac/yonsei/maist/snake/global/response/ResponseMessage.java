package kr.ac.yonsei.maist.snake.global.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessage {

    private String id = "200";
    private String version = "0.1" ;
    private String result = "success";

    public ResponseMessage() {}

}