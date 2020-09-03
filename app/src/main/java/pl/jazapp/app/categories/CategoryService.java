package pl.jazapp.app.categories;

import pl.jazapp.app.categories.persistence.Category;
import pl.jazapp.app.categories.persistence.CategoryCommandRepository;
import pl.jazapp.app.categories.persistence.CategoryQueryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

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
    public void delete(Long id) { commandRepository.delete(id);}
    public void update(Long id, String name, Long departmentId) { commandRepository.update(id, name, departmentId); }
    public void create(String name, Long departmentId) { commandRepository.create(name, departmentId); }
}
