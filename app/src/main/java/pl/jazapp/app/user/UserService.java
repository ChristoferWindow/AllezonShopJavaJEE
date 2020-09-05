package pl.jazapp.app.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@ApplicationScoped
public class UserService {
    @PersistenceContext
    private EntityManager em;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public boolean create(User user) {
        var entity = new UserEntity();
        entity.setUsername(user.getUsername());
        entity.setFirstname(user.getFirstname());
        entity.setLastname(user.getLastname());
        entity.setBirthdate(user.getBirthdate());
        entity.setEmail(user.getEmail());
        entity.setPassword(passwordEncoder.encode(user.getPassword()));
        entity.setRole("DEFAULT");

        em.persist(entity);

        return  true;
    }

    public Optional<UserEntity> getUserByUsername(String username)
    {
        return em.createQuery("from UserEntity where username = :username", UserEntity.class)
                .setParameter("username", username)
                .getResultList().stream()
                .findFirst();
    }

    public Optional<UserEntity> getById(Long id)
    {
        return em.createQuery("from UserEntity where id = :id", UserEntity.class)
                .setParameter("id", id)
                .getResultList().stream()
                .findFirst();
    }

}
