package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

   /* public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }*/


    public Optional<EmployeeDto> getEmployeeById(Long id) {
    /*   Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1 , EmployeeDto.class));*/
   return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity , EmployeeDto.class));
    }


    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class))
                .collect(Collectors.toList());
    }


    public EmployeeDto createNewEmployee(EmployeeDto inputEmployee) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity saveEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(saveEmployeeEntity, EmployeeDto.class);

    }


    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDto.class);
    }


    public boolean isExistByEmployeeId(Long employeeId) {
        return employeeRepository.existsById(employeeId);
    }

    public boolean deleteEmployeeById(Long employeeId) {
        boolean exists = isExistByEmployeeId(employeeId);
        if (!exists)
            return false;
        employeeRepository.deleteById(employeeId);
        return true;
    }


    public EmployeeDto updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        boolean exists = isExistByEmployeeId(employeeId);
        if (!exists)
            return null;
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
       updates.forEach((field , value) -> {
          Field field1 =   ReflectionUtils.findField(EmployeeEntity.class, field);
          field1.setAccessible(true);
          ReflectionUtils.setField(field1 , employeeEntity , value);
       });
     return modelMapper.map(employeeRepository.save(employeeEntity) , EmployeeDto.class);
    }
}
