package pl.jazapp.app.webapp.categories;

import pl.jazapp.app.category.CategoryService;
import pl.jazapp.app.category.persistence.Category;
import pl.jazapp.app.department.Department;
import pl.jazapp.app.department.DepartmentService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Named
@RequestScoped
public class CategoryController {

    @Inject
    CategoryService service;

    @Inject
    DepartmentService departmentService;

    public String create(CategoryRequest request) {
        Optional<Department> department = departmentService.getById(request.getDepartmentId());
        department.ifPresent(value -> service.create(request.getName(), value));
        return "/categories/list.xhtml?faces-redirect=true";
    }

    public String OpenEditingSite(CategoryRequest request) {
        var id = request.getId();
        var departmentData = service.getById(Long.parseLong(String.valueOf(id)));
        if (departmentData.isPresent()) {
            return "/categories/edit.xhtml?categoryId=" + id + "&faces-redirect=true&includeViewParams=true";
        }
        return  "/categories/list.xhtml?faces-redirect=true";
    }

    public String update(CategoryRequest request) {
        var id = request.getId();
        Optional<Department> department = departmentService.getById(request.getDepartmentId());
        if (id != null && department.isPresent()) {
            service.update(id, request.getName(), department.get());
        }
        return "/categories/list.xhtml?faces-redirect=true";
    }

    public Category getById(CategoryRequest request){
        Optional<Category> category = service.getById(request.getId());
        return  category.get();
    }

    public List<Category> getAll() {
        return service.getAll();
    }
}
