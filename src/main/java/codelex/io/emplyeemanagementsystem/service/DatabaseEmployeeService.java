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

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee employee = repository.findById(id).orElse(null);
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
            return repository.save(employee);
        }
        return null;
    }
}
