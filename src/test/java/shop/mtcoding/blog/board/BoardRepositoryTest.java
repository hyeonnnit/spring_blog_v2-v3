package shop.mtcoding.blog.board;


import jakarta.persistence.EntityManager;
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
    @Autowired
    private EntityManager em;

    @Test
    public void updateById_test(){
        //given
        int id = 1;
        String title = "title1";
        String content = "content1";
        //when
        boardRepository.updateById(id,title,content);
        em.flush();
        //then
    }

    @Test
    public void deleteById_test(){
        //given
        int id =1;
        //when
        boardRepository.deleteById(id);

        //then
        System.out.println("deleteById_test: "+boardRepository.findAll().size());
    }
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
