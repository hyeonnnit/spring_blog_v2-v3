package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.blog.borad.Board;
import shop.mtcoding.blog.borad.BoardNativeRepository;
import shop.mtcoding.blog.borad.BoardPersistRepository;

import java.util.List;

@DataJpaTest
@Import(BoardPersistRepository.class)
public class BoardPersistRepositoryTest {

    @Autowired
    private EntityManager em;
    @Autowired
    private BoardPersistRepository boardPersistRepository;
    @Test
    public void updateById_test(){
        //given
        int id = 1;
        String title = "제목수정1";
        //when
        Board board = boardPersistRepository.findById(id);
        System.out.println("updateById_test findById : " + board);
        board.setTitle(title); // PC에 있는 값을 변경
        //then
        em.flush();
        System.out.println("updateById_test updateById : " + board);
    }
    @Test
    public void deleteById_test(){
        // given
        int id = 1;

        // when
        Board board = boardPersistRepository.findById(id);
        boardPersistRepository.deleteById(id);

        // then
        List<Board> boardList = boardPersistRepository.findAll();
        System.out.println("deleteById_test/size : " + boardList.size());
    }
    @Test
    public void findById_test() {
        //given
        int id = 1;
        //when
        Board board = boardPersistRepository.findById(id);
        System.out.println("findById_test : " + board);
        //then
        //org.assertj.core.api
        Assertions.assertThat(board.getTitle()).isEqualTo("제목1");
        Assertions.assertThat(board.getContent()).isEqualTo("내용1");

    }

    @Test
    public void findAll_test() {
        //given - 지금은 넣을게 없음

        //when
        List<Board> boardList = boardPersistRepository.findAll();

        //then
        System.out.println("findAll_test/size : " + boardList.size());
        System.out.println("findAll_test/username : " + boardList.get(2).getUsername());

//        //org.assertj.core.api
//        Assertions.assertThat(boardList.size()).isEqualTo(4);
//        Assertions.assertThat(boardList.get(2).getUsername()).isEqualTo("ssar");
    }

    @Test
    public void save_test() {
        //given
        Board board = new Board("제목5","내용5","ssar");

        //when
        boardPersistRepository.save(board);
        //then
        System.out.println(board);
    }
}
