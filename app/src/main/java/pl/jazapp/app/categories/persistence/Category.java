package pl.jazapp.app.categories.persistence;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "department_id")
    private Long departmentId;

    public Category() {

    }

    public Category(String name, Long departmentId){
        this.name = name;
        this.departmentId = departmentId;
    }

    public String getName(){
        return name;
    }

    public Long getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getDepartmentId() { return departmentId; }

    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }
}
