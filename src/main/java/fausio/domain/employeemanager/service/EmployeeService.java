package fausio.domain.employeemanager.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fausio.domain.employeemanager.Exception.EmployeeNotFoundException;
import fausio.domain.employeemanager.model.Employee;
import fausio.domain.employeemanager.repository.EmployeeRepo;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee Create(Employee model) {
        try {
            model.setCode(UUID.randomUUID().toString()); // generate ramdom code and convert to string
            return employeeRepo.save(model);
        } catch (Exception e) {

            System.out.println("Error trying to Create Employee: " + e.toString());
            throw e;
        }
    }

    public List<Employee> Read() {

        try {

            return employeeRepo.findAll();

        } catch (Exception e) {
            System.out.println("Error trying to Read Employee: " + e.toString());
            throw e;
        }
    }

    public Employee Update(Employee model) {
        try {
            return employeeRepo.save(model);
        } catch (Exception e) {
            System.out.println("Error trying to Update Employee: " + e.toString());
            throw e;
        }
    }

    public void Delete(Long Id) {
        try {

            Optional<Employee> employeeToDelete = employeeRepo.findById(Id); // query method

            if (employeeToDelete != null) {

                employeeRepo.delete(employeeToDelete.get());
            } else {
                System.out.println("Employee with id:" + Id.toString() + "was not found");
            }

        } catch (Exception e) {
            System.out.println("Error trying to Delete Employee: " + e.toString());
            throw e;
        }
    }

    // query method
    public void DeleteByQueryMethod(Long Id) {
        try {

            employeeRepo.deleteEmployeeById(Id);

        } catch (Exception e) {
            System.out.println("Error trying to DeleteNavite Employee: " + e.toString());
            throw e;
        }
    }

    // query method
    public Employee Read(Long Id) throws Exception {
        try {
            // method
            return employeeRepo.findById(Id)
                    .orElseThrow(
                            () -> new EmployeeNotFoundException("Employee with id:" + Id.toString() + "was not found")); // query

        } catch (Exception e) {
            System.out.println("Error trying to Read by Id  Employee: " + e.toString());
            throw e;
        }
    }

}
