package by.itacademy.bootcamp.task.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 60)
    @NotEmpty
    @Size(max = 60)
    private String name;

    @Column(nullable = false, length = 150)
    @NotEmpty
    @Size(max = 150)
    private String description;

    @ManyToMany
//    @JoinTable(
//            name = "preoject_employee",
//            joinColumns = @JoinColumn(name = "project_id"),
//            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;



}
