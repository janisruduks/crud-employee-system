package codelex.io.emplyeemanagementsystem.repository;

import codelex.io.emplyeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseEmployeeRepositoryImpl extends JpaRepository<Employee, Long> {
}
