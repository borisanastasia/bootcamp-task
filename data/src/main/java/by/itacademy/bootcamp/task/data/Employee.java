package by.itacademy.bootcamp.task.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    @NotEmpty
    @Size(max = 20)
    private String firstname;

    @Column(nullable = false, length = 40)
    @NotEmpty
    @Size(max = 40)
    private String lastname;

    @Column(nullable = false, length = 40)
    @NotEmpty
    @Size(max = 40)
    private String surname;

    @Column(nullable = false, length = 60)
    @Size(max = 60)
    @Email
    private String email;

    @Column(nullable = false, length = 40)
    @NotEmpty
    @Size(max = 40)
    private String role;

    @JsonIgnore
    @ManyToMany(mappedBy = "employees")
    List<Project> projects;
}
