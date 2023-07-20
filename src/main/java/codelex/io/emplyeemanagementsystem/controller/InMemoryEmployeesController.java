package codelex.io.emplyeemanagementsystem.controller;

import codelex.io.emplyeemanagementsystem.model.Employee;
import codelex.io.emplyeemanagementsystem.service.InMemoryEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/no-auth/employees")
public class InMemoryEmployeesController {

    private final InMemoryEmployeeService service;

    public InMemoryEmployeesController(InMemoryEmployeeService service) {
        this.service = service;
    }

    @PutMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return service.getEmployeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
        service.deleteEmployeeById(id);
        return "Employee removed successfully";
    }

    @GetMapping("/get/all")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }
}