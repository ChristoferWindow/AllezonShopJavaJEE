package pl.jazapp.app.categories.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class CategoryCommandRepository {

    @PersistenceContext()
    private EntityManager em;

    @Transactional
    public void create(String name, Long departmentId){
        Category category = new Category(name, departmentId);
        em.persist(category);
    }

    @Transactional
    public void update(Long id, String newName, Long departmentId){
        var category = em.find(Category.class, id);
        var merge = em.merge(category);
        merge.setName(newName);
        merge.setDepartmentId(departmentId);
        em.persist(merge);
    }

    public void delete(Long id) {
    }
}
