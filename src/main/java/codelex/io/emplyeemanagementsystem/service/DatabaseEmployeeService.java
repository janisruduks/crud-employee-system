package codelex.io.emplyeemanagementsystem.service;

import codelex.io.emplyeemanagementsystem.exception.EmployeeNotFoundException;
import codelex.io.emplyeemanagementsystem.model.Employee;
import codelex.io.emplyeemanagementsystem.repository.DatabaseEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {

    private final DatabaseEmployeeRepository repository;

    public DatabaseService(DatabaseEmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public void deleteEmployeeById(Long id) {
        this.repository.deleteById(id);
    }

    public void saveEmployee(Employee employee) {
        this.repository.save(employee);
    }
}
