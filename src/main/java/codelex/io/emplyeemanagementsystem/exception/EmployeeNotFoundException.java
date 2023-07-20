package codelex.io.emplyeemanagementsystem.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("Employee not found");
    }
}
