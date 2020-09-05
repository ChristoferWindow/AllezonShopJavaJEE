package pl.jazapp.app.category.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategoryQueryRepository {
    @PersistenceContext()
    private EntityManager em;

    @Transactional
    public List<Category> getAll(){
        return em.createQuery("from Category", Category.class).getResultList();
    }

    @Transactional
    public Optional<Category> getById(Long id){
        return em.createQuery("from Category WHERE id = :id", Category.class).setParameter("id", id).getResultList().stream().findFirst();
    }

    @Transactional
    public Optional<Category> getByName(String name){
        return em.createQuery("from Category WHERE name =:name", Category.class).setParameter("name", name).getResultList().stream().findFirst();
    }
}
