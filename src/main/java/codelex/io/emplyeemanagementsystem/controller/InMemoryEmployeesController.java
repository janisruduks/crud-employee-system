package codelex.io.emplyeemanagementsystem.controller;

import codelex.io.emplyeemanagementsystem.model.Employee;
import codelex.io.emplyeemanagementsystem.repository.InMemoryEmployeeRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api/v1/employees")
public class InMemoryEmployeesController {

    private final InMemoryEmployeeRepositoryImpl employeeRepository;

    public InMemoryEmployeesController(InMemoryEmployeeRepositoryImpl employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PutMapping("/save")
    public String saveEmployee(@RequestBody Employee employee) {
        Random random = new Random();
        Long id = random.nextLong(1000);
        employee.setId(id);
        employeeRepository.saveEmployee(employee);
        return "Employee saved successfully!";
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeRepository.getEmployeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
        employeeRepository.deleteEmployeeById(id);
        return "Employee removed successfully";
    }

    @GetMapping("/get/all")
    public List<Employee> getAllEmployees() {
        return employeeRepository.getEmployees();
    }
}