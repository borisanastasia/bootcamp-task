package by.itacademy.bootcamp.task.presentation;

import by.itacademy.bootcamp.task.data.Employee;
import by.itacademy.bootcamp.task.data.Project;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.instancio.Select.field;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
class ProjectControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void create() {
        var project = Generator.project();

        mockMvc.perform(post("/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(project)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", isA(Integer.class)));

    }

    @Test
    @SneakyThrows
    void findAll() {
        var count = 3;
        for (int i = 0; i < count; i++) {
            createProject();
        }

        mockMvc.perform(get("/projects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.page.totalElements", greaterThanOrEqualTo(count)));
    }

    @SneakyThrows
    @Test
    void addEmployee() {
        var project = createProject();
        var employee = createEmployee();

        mockMvc.perform(post("/projects/" + project.getId() + "/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new AddEmployeeRequest(employee.getId()))))
                .andExpect(status().isOk());
    }

    @SneakyThrows
    private Project createProject() {
        var project = Generator.project();
        var result = mockMvc.perform(post("/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(project)))
                .andReturn();

        return objectMapper.readValue(result.getResponse().getContentAsString(), Project.class);
    }

    @SneakyThrows
    private Employee createEmployee() {
        var employee = Generator.employee();
        var result = mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andReturn();

        return objectMapper.readValue(result.getResponse().getContentAsString(), Employee.class);
    }

}