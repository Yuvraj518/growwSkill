package com.example.GrowwSkill.Service.service_impl;

import com.example.GrowwSkill.DTO.RequestDTO.EmployeeRequestDTO;
import com.example.GrowwSkill.DTO.ResponseDTO.EmployeeResponseDTO;
import com.example.GrowwSkill.Repository.EmployeeRepository;
import com.example.GrowwSkill.Service.EmployeeService;
import com.example.GrowwSkill.Transformer.EmployeeTransformer;
import com.example.GrowwSkill.modal.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService_impl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public boolean addEmployee(EmployeeRequestDTO employeeRequestDTO) throws IOException {
        Employee emp1= EmployeeTransformer.employeeRequestDTOToEmployee(employeeRequestDTO);
//        emp1.setPicture(picture.getBytes());
        employeeRepository.save(emp1);
        return true;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeResponseDTO editEmployee(int id) {
        Optional<Employee> op1=employeeRepository.findById(id);
        // op1 can't be null as we are fetching details from table elements only.
        Employee emp2=op1.get();
        EmployeeResponseDTO er1=EmployeeTransformer.employeeToEmployeeResponseDTO(emp2);
        return er1;
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employees= employeeRepository.findAll();
        List<EmployeeResponseDTO> responseDTOS=new ArrayList<>();
        for(Employee emp: employees){
            EmployeeResponseDTO er=EmployeeTransformer.employeeToEmployeeResponseDTO(emp);
            responseDTOS.add(er);
        }
        return responseDTOS;
    }
//
    @Override
    public boolean updateEmployee(EmployeeResponseDTO employeeResponseDTO) throws Exception {
        Optional<Employee> op1= employeeRepository.findById(employeeResponseDTO.getId());
        if(op1.isEmpty()){
            throw new Exception("Employee not found");
        }
        Employee emp1=op1.get();
        emp1.setFirstName(employeeResponseDTO.getFirstName());
        emp1.setLastName(employeeResponseDTO.getLastName());
        emp1.setSalary(employeeResponseDTO.getSalary());
        emp1.setDepartment(employeeResponseDTO.getDepartment());
        emp1.setPosition(employeeResponseDTO.getPosition());
        emp1.setEmailId(employeeResponseDTO.getEmailId());
        emp1.setContactNumber(employeeResponseDTO.getContactNumber());
        employeeRepository.save(emp1);
        return true;
    }

    @Override
    public List<Employee> filterEmployees(String department, String position, Integer paginationLimit) {
        List<Employee> employeeList= employeeRepository.filterEmployees(department,position,paginationLimit);
        return employeeList;
    }


}
