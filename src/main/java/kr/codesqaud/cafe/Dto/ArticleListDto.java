package kr.codesqaud.cafe.Dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArticleListDto {
    //글 목록에 표시할 내용 DTO
    String author;

    String title;

    String time;

    long id;


    public ArticleListDto(String author, String title, LocalDateTime time, Long id) {
        this.author = author;
        this.title = title;
        this.time = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }
}
