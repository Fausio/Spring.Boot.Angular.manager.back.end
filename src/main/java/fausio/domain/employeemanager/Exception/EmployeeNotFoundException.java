package fausio.domain.employeemanager.Exception;

public class EmployeeNotFoundException extends RuntimeException {
    
    public EmployeeNotFoundException(String msg){
     super(msg);
    }
}
