package by.itacademy.bootcamp.task.presentation;

import by.itacademy.bootcamp.task.data.Employee;
import by.itacademy.bootcamp.task.logic.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(CREATED)
    public Employee create(@Valid @RequestBody Employee employee) {
        return employeeService.save(employee);
    }
}
