package shop.mtcoding.blog.borad;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardPersistRepository boardPersistRepository;
    private final BoardNativeRepository boardNativeRepository;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        // 조회하기
        List<Board> boardList = boardPersistRepository.findAll();
        // 가방에 담기
        request.setAttribute("boardList", boardList);

        return "index"; // 서버가 내부적으로 index를 요청 - 외부에서는 다이렉트 접근이 안됨
    }

    @PostMapping("/board/save")
    public String save(BoardRequest.SaveDTO reqDTO){
        boardPersistRepository.save(reqDTO.toEntity());
        return "redirect:/";
    }
    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable Integer id, HttpServletRequest request) {
        Board board = boardPersistRepository.findById(id);
        request.setAttribute("board", board);
        return "board/detail";
    }
    @GetMapping("/board/{id}/update-form")
    public String updateForm(@PathVariable Integer id, HttpServletRequest request) {
        Board board = boardPersistRepository.findById(id);
        request.setAttribute("board", board);
        return "/board/update-form"; // 서버가 내부적으로 index를 요청 - 외부에서는 다이렉트 접근이 안됨
    }
    @PostMapping("/board/{id}/update")
    public String update(@PathVariable Integer id, BoardRequest.UpdateDTO reqDTO){
        boardPersistRepository.updateById(id, reqDTO);
        return "redirect:/board/"+id;
    }
    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable int id) { // DTO 없이 구현
        boardPersistRepository.deleteById(id);
        return "redirect:/";
    }
}
