package by.itacademy.bootcamp.task.logic;

import by.itacademy.bootcamp.task.data.Project;
import by.itacademy.bootcamp.task.data.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final EmployeeService employeeService;

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Page<Project> findAll(int page, int size) {
        var pageRequest = PageRequest.of(page, size);
        return projectRepository.findAllByOrderByName(pageRequest);
    }

    public void addEmployee(Long projectId, Long employeeId) {
        var project = projectRepository.findById(projectId).orElseThrow(() ->
                new IllegalArgumentException("There is no project with id " + projectId));
        var employeeExistsInProject = project.getEmployees().stream()
                .anyMatch(e -> e.getId().equals(employeeId));

        if (employeeExistsInProject) {
            throw new IllegalArgumentException(format("Employee %s already exists in the project %s", employeeId, projectId));
        }

        var employee = employeeService.findById(employeeId).orElseThrow(() ->
                new IllegalArgumentException("There is no employee with id " + projectId));

        project.getEmployees().add(employee);
        projectRepository.save(project);
    }
}
