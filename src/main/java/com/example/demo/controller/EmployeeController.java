package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping("/employees")

public class EmployeeController {

   /* @GetMapping(path = "/getSecretMessage")
    public String getSuperSecretMessages() {
        return "Secret Messages: hello ";
    }*/

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        /* return new EmployeeDto(employeeId , "Ashish" , "ashu857@gmail.com",25 , LocalDate.of(2025,7,25),true);*/
       Optional<EmployeeDto> employeeDto = employeeService.getEmployeeById(id);
      return employeeDto
              .map(employeeDto1 -> ResponseEntity.ok(employeeDto1))
              .orElseThrow(() -> new NoSuchElementException("Employee Not found"));
    }
    @ExceptionHandler(NoSuchElementException.class)
    public String handleEmployedNotFound(NoSuchElementException exception) {
        return "Employee are not found";

    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees(@RequestParam(required = false, name = "input age") Integer age,
                                             @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployee();

    }

    // create method
    //
    @PostMapping
    public EmployeeDto createNewEmployee(@RequestBody @Valid EmployeeDto inputEmployee) {
        return employeeService.createNewEmployee(inputEmployee);
    }

//    @PostMapping
//    public String createToNewEmployee() {
//        return "Hello from post";
//    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDto updateEmployeeById(@RequestBody EmployeeDto employeeDto,
                                          @PathVariable Long employeeId) {
        return employeeService.updateEmployeeById(employeeId, employeeDto);
    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDto updatePartialEmployeeById(@RequestBody Map<String , Object> updates,
                                                 @PathVariable Long employeeId) {
        return employeeService.updatePartialEmployeeById(employeeId, updates);
    }

    

}
