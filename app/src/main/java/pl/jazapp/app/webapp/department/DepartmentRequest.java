package pl.jazapp.app.webapp.department;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class DepartmentRequest {
    private String name;

    private String editedName;

    private Long id;

    public void setName(String name){
        this.name = name;
    }

    public String getName() { return name; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getEditedName() {
        return editedName;
    }

    public void setEditedName(String editedName) {
        this.editedName = editedName;
    }
}
