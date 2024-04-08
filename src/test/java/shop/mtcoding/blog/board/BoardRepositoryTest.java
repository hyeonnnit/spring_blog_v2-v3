package shop.mtcoding.blog.board;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;
import shop.mtcoding.blog.borad.Board;
import shop.mtcoding.blog.borad.BoardRepository;

import java.util.List;

@Import(BoardRepository.class)
@DataJpaTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void findAll1_test(){
        //given

        //when
        List<Board> boardList = boardRepository.findAll1();
        System.out.println("findAll1_test:: 조회완료 쿼리 2번");
        boardList.forEach(board -> {
            System.out.println(board);
        });
        //then
    }
    @Test
    public void findAll_test(){
        //given

        //when
        List<Board> boardList = boardRepository.findAll();
        boardList.forEach(board -> {
            System.out.println(board.getUser().getUsername());
        });
        //then
    }
    @Test
    public void findById_test(){
        int id = 1;
        System.out.println("start - 1");
        Board board = boardRepository.findById(id);
        System.out.println("start - 2");
        System.out.println(board.getUser().getId());
        System.out.println("start - 3");
        System.out.println(board.getUser().getUsername());
    }
}
