package com.example.GrowwSkill.controller;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
import com.example.GrowwSkill.DTO.RequestDTO.EmployeeRequestDTO;
import com.example.GrowwSkill.DTO.ResponseDTO.EmployeeResponseDTO;
import com.example.GrowwSkill.Service.EmployeeService;
import com.example.GrowwSkill.modal.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/rr")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/registration")
    public String registerPage() {
        return "index";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute EmployeeRequestDTO employeeRequestDTO) throws IOException {
        boolean check=employeeService.addEmployee(employeeRequestDTO);
        return "redirect:/rr/registration";
    }

    @GetMapping("/all")
    public ModelAndView getAllEmpolyees(){
        List<EmployeeResponseDTO> getAllEmployees=employeeService.getAllEmployees();
        ModelAndView md=new ModelAndView();
        md.setViewName("allEmployees");
        md.addObject("getAllEmployees",getAllEmployees);
        return md;
    }
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable int id,Model model){
        EmployeeResponseDTO employeeResponseDTO=employeeService.editEmployee(id);
        model.addAttribute("employeeResponseDTO", employeeResponseDTO);
        return "edit";
    }

    @PostMapping(value = "/update",consumes = "multipart/form-data")
    public String updateEmployee(@RequestBody EmployeeResponseDTO employeeResponseDTO) throws Exception {
        boolean check=employeeService.updateEmployee(employeeResponseDTO);
        return "allEmployees";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "redirect:/rr/all";
    }
    @GetMapping("/filtration")
    public String filterPage() {
        return "filter";
    }
    @PostMapping("/filter")
    public String filterEmployees(@RequestParam(name = "department", required = false) String department,
                                  @RequestParam(name = "position", required = false) String position,
                                  @RequestParam(name = "paginationLimit", required = false) Integer paginationLimit,
                                  Model model) {
        List<Employee> filteredEmployees = employeeService.filterEmployees(department, position, paginationLimit);
        model.addAttribute("getAllEmployees", filteredEmployees);
        return "allFilter";
    }
      @RequestMapping("*")
      public String handleUndefinedPath() {
    return "errors";
}
}
