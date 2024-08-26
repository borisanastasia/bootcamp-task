package by.itacademy.bootcamp.task.presentation;

import by.itacademy.bootcamp.task.data.Employee;
import by.itacademy.bootcamp.task.data.Project;
import org.instancio.Instancio;

import static org.instancio.Select.field;

class Generator {

    static Employee employee() {
        return Instancio.of(Employee.class)
                .ignore(field(Employee::getId))
                .ignore(field(Employee::getProjects))
                .generate(field(Employee::getEmail), gen -> gen.net().email())
                .create();
    }

    static Project project() {
        return Instancio.of(Project.class)
                .ignore(field(Project::getId))
                .ignore(field(Project::getEmployees))
                .create();
    }
}
