package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class EmployeeDto {

    private Long id;


    @NotBlank(message = "Name of the employee cannot be blank ")
    @Size(min = 5 ,max = 15)
    private String name;

    @NotBlank(message = "Email of the employee  cannot be blank ")
    @Email(message = "Email should be a valid email")
    private String email;


    @NotNull(message = "Age cannot be null")
    @Max(value = 100, message = "age is cannot be greater than 80")
    @Min(value = 18, message = "age is cannot be less than 18")
    @Positive // we don't needed bcz we use max or min
    private Integer age;

    @PastOrPresent(message = "date of joining of employee cannot be future ")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    private Boolean isActive;

    public EmployeeDto(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

    public EmployeeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


}
