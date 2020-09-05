package pl.jazapp.app.category.persistence;

import pl.jazapp.app.department.Department;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    public Category() {
    }

    public Category(String name, Department department){
        this.name = name;
        this.department = department;
    }

    public String getName(){
        return name;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) { this.id = id;}

    public void setName(String name){
        this.name = name;
    }

    public Department getDepartmentId() { return department; }

    public void setDepartment(Department department) { this.department = department; }
}
