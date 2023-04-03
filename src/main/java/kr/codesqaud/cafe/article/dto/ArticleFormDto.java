package kr.codesqaud.cafe.article.dto;

public class ArticleFormDto {
    //글 작성했을때 사용하는 DTO
    private String author;

    private String title;

    private String contents;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }
}