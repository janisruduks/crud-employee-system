package codelex.io.emplyeemanagementsystem.service;

import codelex.io.emplyeemanagementsystem.exception.EmployeeNotFoundException;
import codelex.io.emplyeemanagementsystem.model.Employee;
import codelex.io.emplyeemanagementsystem.repository.DatabaseEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseEmployeeService {

    private final DatabaseEmployeeRepository repository;

    public DatabaseEmployeeService(DatabaseEmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public void deleteEmployeeById(Long id) {
        this.repository.deleteById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return this.repository.save(employee);
    }
}
