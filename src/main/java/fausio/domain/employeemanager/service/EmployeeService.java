package fausio.domain.employeemanager.service;
 
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

            System.out.println("Error trying to save Employee: " + e.toString());
            throw e;
        }
    }

}
