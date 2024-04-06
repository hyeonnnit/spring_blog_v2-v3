package shop.mtcoding.blog.borad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Table(name = "board_tb")
@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String content;
    private String username;

    @CreationTimestamp
    private Timestamp createdAt;

    public Board(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }

    public void update(BoardRequest.UpdateDTO reqDTO) { // 변경할 데이터를 설정할 setter 만들기
        this.title = reqDTO.getTitle();
        this.content = reqDTO.getContent();
        this.username = reqDTO.getUsername();
    }
}
