package shop.mtcoding.blog.borad;

import lombok.Data;

public class BoardRequest {

    @Data
    public static class SaveDTO{
        private String title;
        private String content;
        private String username;

        public Board toEntity(){
            return new Board(title,content,username);
        }
    }
}
