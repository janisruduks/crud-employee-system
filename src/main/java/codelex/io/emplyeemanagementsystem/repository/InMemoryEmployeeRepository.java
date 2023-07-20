package codelex.io.emplyeemanagementsystem.repository;

import codelex.io.emplyeemanagementsystem.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class InMemoryEmployeeRepository {

    private final LinkedList<Employee> employees;

    public InMemoryEmployeeRepository() {
        this.employees = new LinkedList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void saveEmployee(Employee employee) {
        synchronized (employees) {
            employees.add(employee);
        }
    }

    public void deleteEmployee(Employee employee) {
        synchronized (employees) {
            employees.remove(employee);
        }
    }
}
