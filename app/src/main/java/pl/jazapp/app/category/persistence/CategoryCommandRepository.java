package pl.jazapp.app.category.persistence;

import pl.jazapp.app.department.Department;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class CategoryCommandRepository {

    @PersistenceContext()
    private EntityManager em;

    @Transactional
    public void create(String name, Department department){
        Category category = new Category(name, department);
        em.persist(category);
    }

    @Transactional
    public void update(Long id, String newName, Department department){
        var category = em.find(Category.class, id);
        var merge = em.merge(category);
        merge.setName(newName);
        merge.setDepartment(department);
        em.persist(merge);
    }

    public void delete(Long id) {
    }
}
