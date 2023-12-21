package com.example.GrowwSkill.Transformer;

import com.example.GrowwSkill.DTO.RequestDTO.EmployeeRequestDTO;
import com.example.GrowwSkill.DTO.ResponseDTO.EmployeeResponseDTO;
import com.example.GrowwSkill.modal.Employee;
import lombok.experimental.UtilityClass;

import java.util.Base64;

@UtilityClass
public class EmployeeTransformer {
    public static Employee employeeRequestDTOToEmployee(EmployeeRequestDTO employeeRequestDTO){
        Employee emp1=new Employee();
        emp1.setFirstName(employeeRequestDTO.getFirstName());
        emp1.setLastName(employeeRequestDTO.getLastName());
        emp1.setSalary(employeeRequestDTO.getSalary());
        emp1.setDepartment(employeeRequestDTO.getDepartment());
        emp1.setPosition(employeeRequestDTO.getPosition());
        emp1.setEmailId(employeeRequestDTO.getEmailId());
        emp1.setContactNumber(employeeRequestDTO.getContactNumber());
        return emp1;
    }
    public static EmployeeResponseDTO employeeToEmployeeResponseDTO(Employee employee){
        EmployeeResponseDTO employeeResponseDTO=new EmployeeResponseDTO();
        employeeResponseDTO.setId(employee.getId());
        employeeResponseDTO.setFirstName(employee.getFirstName());
        employeeResponseDTO.setLastName(employee.getLastName());
        employeeResponseDTO.setDepartment(employee.getDepartment());
        employeeResponseDTO.setContactNumber(employee.getContactNumber());
        employeeResponseDTO.setPosition(employee.getPosition());
        employeeResponseDTO.setSalary(employee.getSalary());
        employeeResponseDTO.setEmailId(employee.getEmailId());

//        employeeResponseDTO.setPicture(Base64.getEncoder().encodeToString(employee.getPicture()));
        return employeeResponseDTO;
    }
}
