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

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee employee = getEmployeeById(id);
        repository.deleteEmployee(employee);
        if (employee != null) {
            if (!updatedEmployee.getEmail().equals("")) {
                employee.setEmail(updatedEmployee.getEmail());
            }
            if (!updatedEmployee.getFirstName().equals("")) {
                employee.setFirstName(updatedEmployee.getFirstName());
            }
            if (!updatedEmployee.getLastName().equals("")) {
                employee.setLastName(updatedEmployee.getLastName());
            }
            if (!updatedEmployee.getPhoneNumber().equals("")) {
                employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
            }
            repository.saveEmployee(employee);
            return employee;
        }
        return null;
    }

    public void deleteEmployeeById(Long id) {
        repository.deleteEmployee(getEmployeeById(id));
    }

}
