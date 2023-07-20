package codelex.io.emplyeemanagementsystem.service;

import codelex.io.emplyeemanagementsystem.exception.EmployeeNotFoundException;
import codelex.io.emplyeemanagementsystem.model.Employee;
import codelex.io.emplyeemanagementsystem.repository.InMemoryEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class InMemoryEmployeeService {

    private final InMemoryEmployeeRepository repository;

    public InMemoryEmployeeService(InMemoryEmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.getEmployees();
    }

    public Employee saveEmployee(Employee employee) {
        Random random = new Random();
        Long id = random.nextLong(1000);
        employee.setId(id);
        repository.saveEmployee(employee);
        return employee;
    }

    public Employee getEmployeeById(Long id) {
        return getAllEmployees().stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public void deleteEmployeeById(Long id) {
        repository.deleteEmployee(getEmployeeById(id));
    }

}
