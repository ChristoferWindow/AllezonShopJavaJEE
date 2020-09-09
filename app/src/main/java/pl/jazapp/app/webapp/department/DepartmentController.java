package pl.jazapp.app.webapp.department;

import pl.jazapp.app.department.Department;
import pl.jazapp.app.department.DepartmentService;
import pl.jazapp.app.department.persistence.DepartmentCommandRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class DepartmentController {

    @Inject
    DepartmentService service;

    @Inject
    private DepartmentRequest departmentRequest;

    @Inject
    private DepartmentCommandRepository commandRepository;

    public String create(DepartmentRequest request) {
        service.create(request.getName());
        departmentRequest.setId(null);
        return "/departments/list.xhtml?faces-redirect=true";
    }

    public String OpenEditingSite(DepartmentRequest departmentRequest) {
        var id = departmentRequest.getId();
        var departmentData = service.getById(Long.parseLong(String.valueOf(id)));
        if (departmentData.isPresent()) {
            return "/departments/edit.xhtml?departmentId=" + id + "&faces-redirect=true&includeViewParams=true";
        }
        return  "/departments/list.xhtml?faces-redirect=true";
    }

    public String update(DepartmentRequest request) {
        var id = request.getId();
        if (id != null) {
            service.update(id, request.getName());
        }
        departmentRequest.setId(null);
        return "/departments/list.xhtml?faces-redirect=true";
    }

    public String delete(Long id) {
        service.delete(id);
        return "/departments/list.xhtml?faces-redirect=true";
    }

    public List<Department> getAll() {
        return service.getAll();
    }
}
