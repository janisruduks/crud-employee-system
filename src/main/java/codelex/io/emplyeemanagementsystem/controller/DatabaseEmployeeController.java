package codelex.io.emplyeemanagementsystem.controller;

import codelex.io.emplyeemanagementsystem.model.Employee;
import codelex.io.emplyeemanagementsystem.repository.DatabaseEmployeeRepositoryImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/emp")
public class DatabaseEmployeeController {

    private final DatabaseEmployeeRepositoryImpl employeeRepository;

    public DatabaseEmployeeController(DatabaseEmployeeRepositoryImpl employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello world!");
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(this.employeeRepository.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(this.employeeRepository.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
        this.employeeRepository.deleteById(id);
        return "Employee deleted successfully!";
    }

    @PutMapping("/save")
    public String saveEmployee(@RequestBody Employee employee) {
        ResponseEntity.ok(this.employeeRepository.save(employee));
        return "Employee saved successfully!";
    }
}
