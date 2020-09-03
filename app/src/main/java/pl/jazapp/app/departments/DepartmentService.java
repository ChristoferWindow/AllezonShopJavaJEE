package pl.jazapp.app.departments;

import pl.jazapp.app.categories.persistence.Category;
import pl.jazapp.app.departments.persistence.DepartmentCommandRepository;
import pl.jazapp.app.departments.persistence.DepartmentQueryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DepartmentService {
    @Inject
    private DepartmentQueryRepository queryRepository;

    @Inject
    private DepartmentCommandRepository commandRepository;

    public List<Department> getAll(){
        return queryRepository.getAll();
    }

    public Optional<Department> getById(Long id) {
        return queryRepository.getById(id);
    }

    public void delete(Long id) { commandRepository.delete(id);}

    public void update(Long id, String name) {
        commandRepository.update(id, name);
    }

    public void create(String name) {
        commandRepository.create(name);
    }
}
