package com.cache.example.hazlecast.services;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.cache.example.hazlecast.models.Employee;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
public class EmployeeService {
private List<Employee>empList=new ArrayList<Employee>();
private String[] employeeDetails = null;

public EmployeeService() {}

@PostConstruct
public void init() {
	try {
	 File file = new File( getClass().getResource("/employee.csv").getFile());
	 FileReader filereader = new FileReader(file); 
	 CSVReader csvReader = new CSVReaderBuilder(filereader) 
             .withSkipLines(1) 
             .build(); 
	 while((employeeDetails = csvReader.readNext())!=null)
     {
       //Save the employee details in Employee object
         Employee emp = new Employee(Integer.parseInt(employeeDetails[0]),
                 employeeDetails[1],employeeDetails[2],
                 Integer.parseInt(employeeDetails[3]));
         empList.add(emp);
     }
	  
	} catch (Exception e) { 
        e.printStackTrace(); 
    } 
}
public List<Employee> findAll() {
    return this.empList;
}

}
