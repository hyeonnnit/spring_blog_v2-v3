package shop.mtcoding.blog.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    public User findById(int id){
        User user = em.find(User.class, id);
        return user;
    }
    @Transactional
    public User save1(String username, String password, String email){
        Query q1 = em.createNativeQuery("insert into user_tb(username, password, email, created_at) values(?, ?, ?, now())");
        q1.setParameter(1, username);
        q1.setParameter(2, password);
        q1.setParameter(3, email);
        q1.executeUpdate();

        Query q2 = em.createNativeQuery("select * from user_tb where id = (select max(id) from user_tb)", User.class);
        User user = (User) q2.getSingleResult();
        return user;
    }

    @Transactional
    public User save(User user){
        em.persist(user);
        return user;
    }
    public User findByUsernameAndPassword(String username, String password){
        Query query = em.createQuery("select u from User u where u.username = :username and u.password = :password", User.class);
        query.setParameter("username",username);
        query.setParameter("password",password);
        return (User) query.getSingleResult();
    }
}
