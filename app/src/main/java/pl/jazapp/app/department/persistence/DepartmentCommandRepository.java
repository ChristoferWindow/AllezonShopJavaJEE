package pl.jazapp.app.department.persistence;

import pl.jazapp.app.department.Department;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class DepartmentCommandRepository {

    @PersistenceContext()
    private EntityManager em;

    @Transactional
    public void create(String name){
        Department department = new Department(name);
        em.persist(department);
    }

    @Transactional
    public void update(Long id, String newName){
        var department = em.find(Department.class, id);
        var merge = em.merge(department);
        merge.setName(newName);
        em.persist(merge);
    }

    @Transactional
    public void delete(Long id) {
        Department department = em.find(Department.class, id);
        em.remove(department);
    }
}
