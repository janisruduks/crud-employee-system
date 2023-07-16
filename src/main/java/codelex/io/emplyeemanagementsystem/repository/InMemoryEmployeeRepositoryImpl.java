package codelex.io.emplyeemanagementsystem.repository;

import codelex.io.emplyeemanagementsystem.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryEmployeeRepositoryImpl {

    private final List<Employee> employees;

    public InMemoryEmployeeRepositoryImpl() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void saveEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public void deleteEmployeeById(Long id) {
        employees.remove(getEmployeeById(id));
    }
}
