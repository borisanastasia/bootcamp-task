package by.itacademy.bootcamp.task.presentation;

import by.itacademy.bootcamp.task.data.Project;
import by.itacademy.bootcamp.task.logic.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    @ResponseStatus(CREATED)
    public Project add(@Valid @RequestBody Project project){
      return projectService.save(project);
    }

    @GetMapping
    public Page<Project> findAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size) {
        return projectService.findAll(page, size);
    }

    @PostMapping("/{projectId}/employees")
    public void addEmployee(@PathVariable Long projectId, @RequestBody AddEmployeeRequest addEmployeeRequest) {
        projectService.addEmployee(projectId, addEmployeeRequest.getEmployeeId());
    }
}
