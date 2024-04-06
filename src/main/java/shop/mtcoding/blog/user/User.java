package shop.mtcoding.blog.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name="user_tb")
@Data
@Entity //중요함!
public class User { // use_tb의 내용 DB에 담기
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int id;

    @Column(unique=true) // 유니크 설정
    private String username;

    @Column(length = 60, nullable = false) // 길이 조정, 널 불가
    private String password;
    private String email;

    // 카멜 표기법으로 만들면 DB는 created_at 으로 만들어진다. (언더스코어 기법)
    private LocalDateTime createdAt;

}
