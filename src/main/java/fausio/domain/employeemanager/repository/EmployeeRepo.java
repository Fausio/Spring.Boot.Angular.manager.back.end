package fausio.domain.employeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fausio.domain.employeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository< Employee,Long> {
    
}
