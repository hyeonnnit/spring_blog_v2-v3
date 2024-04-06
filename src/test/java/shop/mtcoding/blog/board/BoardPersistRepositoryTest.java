package shop.mtcoding.blog.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.blog.borad.Board;
import shop.mtcoding.blog.borad.BoardNativeRepository;
import shop.mtcoding.blog.borad.BoardPersistRepository;

@DataJpaTest
@Import(BoardNativeRepository.class)
public class BoardPersistRepositoryTest {

    @Autowired
    private BoardPersistRepository boardPersistRepository;

    @Test
    public void save_test(){
        Board board = new Board("제목5", "내용5", "ssar");
        boardPersistRepository.save(board);
        System.out.println("save_test: "+board);
    }
}
