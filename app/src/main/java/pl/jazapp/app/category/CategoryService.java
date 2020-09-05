package pl.jazapp.app.category;

import pl.jazapp.app.category.persistence.Category;
import pl.jazapp.app.category.persistence.CategoryCommandRepository;
import pl.jazapp.app.category.persistence.CategoryQueryRepository;
import pl.jazapp.app.department.Department;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@ApplicationScoped
public class CategoryService {
    @Inject
    CategoryQueryRepository queryRepository;
    @Inject
    CategoryCommandRepository commandRepository;

    public List<Category> getAll(){
        return queryRepository.getAll();
    }
    public Optional<Category> getById(Long id) {
        return queryRepository.getById(id);
    }
    public Optional<Category> getByName(String name) {
        return queryRepository.getByName(name);
    }
    public void update(Long id, String name, Department department) { commandRepository.update(id, name, department); }
    public void create(String name, Department department) { commandRepository.create(name, department); }
}
