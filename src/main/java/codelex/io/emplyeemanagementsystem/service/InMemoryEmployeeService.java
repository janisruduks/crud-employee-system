package codelex.io.emplyeemanagementsystem.service;

import codelex.io.emplyeemanagementsystem.model.Employee;
import codelex.io.emplyeemanagementsystem.repository.InMemoryEmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class InMemoryService {

    private final InMemoryEmployeeRepository repository;

    public InMemoryService(InMemoryEmployeeRepository repository) {
        this.repository = repository;
    }



    public Employee getEmployeeById(Long id) {
        return repository.getEmployees().stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public void deleteEmployeeById(Long id) {
        repository.deleteEmployee(getEmployeeById(id));
    }

}
