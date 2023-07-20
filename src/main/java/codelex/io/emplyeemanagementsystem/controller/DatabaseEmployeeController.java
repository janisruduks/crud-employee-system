package codelex.io.emplyeemanagementsystem.controller;

import codelex.io.emplyeemanagementsystem.model.Employee;
import codelex.io.emplyeemanagementsystem.service.DatabaseEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/auth/emp")
public class DatabaseEmployeeController {

    private final DatabaseEmployeeService service;

    public DatabaseEmployeeController(DatabaseEmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String authCheck() {
        return "Authenticated successfully";
    }

    @PutMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
        service.deleteEmployeeById(id);
        return "Employee deleted successfully!";
    }

    @GetMapping("/get/all")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Employee updated = service.updateEmployee(id, updatedEmployee);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }
}
