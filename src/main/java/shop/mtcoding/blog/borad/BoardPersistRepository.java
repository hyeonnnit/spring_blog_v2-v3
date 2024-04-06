package shop.mtcoding.blog.borad;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardPersistRepository {
    private final EntityManager em;

    @Transactional
    public Board save (Board board){
        em.persist(board);
        return board;
    }
}