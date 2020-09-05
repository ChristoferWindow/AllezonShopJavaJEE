package pl.jazapp.app.department.persistence;

import pl.jazapp.app.department.Department;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DepartmentQueryRepository {

    @PersistenceContext()
    private EntityManager em;

    @Transactional
    public List<Department> getAll(){
        return em.createQuery("from Department", Department.class).getResultList();
    }

    @Transactional
    public Optional<Department> getById(Long id){
        return em.createQuery("from Department WHERE id = :id", Department.class).setParameter("id", id).getResultList().stream().findFirst();
    }

    @Transactional
    public Optional<Department> getByName(String name){
        return em.createQuery("from Department WHERE name =:name", Department.class).setParameter("name", name).getResultList().stream().findFirst();
    }
}
