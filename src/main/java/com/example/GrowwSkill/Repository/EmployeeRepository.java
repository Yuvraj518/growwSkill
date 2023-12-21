package com.example.GrowwSkill.Repository;

import com.example.GrowwSkill.modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
//    @Query(value = "select first_name,last_name,picture from employee;",nativeQuery = true)
//    List<Employee> getAlEmployees();
//    Employee getEmployeeById(int id);
//    void updateEmployee(Employee employee);
    @Query(value="select * from employee as e where e.department=:department or e.position=:position limit :paginationLimit",nativeQuery = true)
    List<Employee> filterEmployees(String department, String position,int paginationLimit);
}
