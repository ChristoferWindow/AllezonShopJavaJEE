package pl.jazapp.app.department;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Department() {
    }

    public Department(String name){
        this.name = name;
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
}

