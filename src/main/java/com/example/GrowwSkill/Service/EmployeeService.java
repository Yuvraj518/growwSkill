package com.example.GrowwSkill.Service;

import com.example.GrowwSkill.DTO.RequestDTO.EmployeeRequestDTO;
import com.example.GrowwSkill.DTO.ResponseDTO.EmployeeResponseDTO;
import com.example.GrowwSkill.modal.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface EmployeeService {

    List<EmployeeResponseDTO> getAllEmployees();
//
    boolean updateEmployee(EmployeeResponseDTO employeeResponseDTO) throws Exception;
//
    boolean addEmployee(EmployeeRequestDTO employeeRequestDTO) throws IOException;

    void deleteEmployee(int id);

    EmployeeResponseDTO editEmployee(int id);
//
    List<Employee> filterEmployees(String department, String position, Integer paginationLimit);
}
