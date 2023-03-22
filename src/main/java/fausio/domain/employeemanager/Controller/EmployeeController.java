package fausio.domain.employeemanager.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fausio.domain.employeemanager.model.Employee;
import fausio.domain.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService eService) {
        this.employeeService = eService;
    }

    @GetMapping("/read")
    public ResponseEntity Read() {
        try {

            List<Employee> result = employeeService.Read();
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/read/{id}")
    public ResponseEntity Read(@PathVariable("id") Long id) throws Exception {
        try {

            Employee result = employeeService.Read(id);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace(); // see note 2
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @PostMapping("/create")
    public ResponseEntity Create(@RequestBody Employee model) {
        try {

            Employee result = employeeService.Create(model);
            return new ResponseEntity<>(result, HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @PutMapping("/update")
    public ResponseEntity Update(@RequestBody Employee model) {
        try {

            employeeService.Update(model);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity Create(@PathVariable("id") Long id) {
        try {

            employeeService.DeleteByQueryMethod(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }
}
