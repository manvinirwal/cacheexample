package com.cache.example.hazlecast.services;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.cache.example.hazlecast.models.Employee;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
@CacheConfig(cacheNames={"empList"})
public class EmployeeService {
private List<Employee>empList=new ArrayList<Employee>();
private String[] employeeDetails = null;
private Logger logger = LoggerFactory.getLogger(EmployeeService.class);

public EmployeeService() {}

@PostConstruct
public  List<Employee> init() {
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
                 Double.parseDouble(employeeDetails[3]));
         empList.add(emp);
     }
	
	
	  
	} catch (Exception e) { 
		logger.error("An exception occurred!",e); 
    }
	 //to load data into cache
	 List<Employee>emp=findAll();
	 return emp;
}
@Cacheable
public List<Employee> findAll() {
    return this.empList;
}
//@CachePut
//public Employee updateEmployee(Employee employee) {
//    this.empList.set(0, employee);
//    return this.empList.get(0);
//}
@CachePut
public  List<Employee> updateEmployee(String employeePlace, double percentInc) {
	
	for (int i=0;i<this.empList.size();i++) {
		if(this.empList.get(i).getPlace().equals(employeePlace)) {
			Employee employee=this.empList.get(i);
			employee.setSalary(employee.getSalary()*(1+percentInc/100));
			this.empList.set(i, employee);
		}
	}
	return this.empList;
	
}

}
