package com.cache.example.hazlecast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.cache.example.hazlecast.services.EmployeeService;
import com.cache.example.hazlecast.models.Employee;
@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeService {
	    @Mock
	    EmployeeService service;
	    
	    @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	    @Test
	    public void findAllTest() {
	        List<Employee> list = new ArrayList<Employee>();
	        Employee empOne = new Employee(1, "John", "Bangalore", 3456.8);
	        Employee empTwo = new Employee(2, "Alex", "Mumbai", 555677.98);
	        Employee empThree = new Employee(3, "Steve", "Kolkata", 234556.67);
	         
	        list.add(empOne);
	        list.add(empTwo);
	        list.add(empThree);
	         
	        when(service.findAll()).thenReturn(list);
	         
	        //test
	        List<Employee> empList = service.findAll();
	         
	        assertEquals(3, empList.size());
	        verify(service,times(1)).findAll();
	    }
	    @Test
	    public void findAllTest2() {
	        List<Employee> list = new ArrayList<Employee>();
	        Employee empOne = new Employee(1, "John", "Bangalore", 3456.8);
	        Employee empTwo = new Employee(2, "Alex", "Mumbai", 555677.98);
	        Employee empThree = new Employee(3, "Steve", "Kolkata", 234556.67);
	         
	        list.add(empOne);
	        list.add(empTwo);
	        list.add(empThree);
	         
	        when(service.findAll()).thenReturn(list);
	         
	        //test
	        List<Employee> empList = service.findAll();
	         
	        assertNotEquals(4, empList.size());
	        verify(service,times(1)).findAll();
	    }
	    @Test
	    public void updateEmployeeTest() {
	    	List<Employee> list = new ArrayList<Employee>();
	    	  Employee empOne = new Employee(1, "John", "Bangalore", 3456.8*1.50);
		      Employee empTwo = new Employee(2, "Alex", "Mumbai", 555677.98*1.50);
		      Employee empThree = new Employee(3, "Steve", "Bangalore", 234556.67*1.50);
		      list.add(empOne);
		      list.add(empTwo);
		      list.add(empThree);
		      when(service.updateEmployee("Bangalore",50.00)).thenReturn(list); 
		      
		    //test
		       List<Employee> empList = service.updateEmployee("Bangalore",50.00);
		       assertEquals(list, empList);
		       verify(service,times(1)).updateEmployee("Bangalore",50.00);
	    	
	    }
	    @Test
	    public void updateEmployeeTest2() {
	    	List<Employee> list = new ArrayList<Employee>();
	    	  Employee empOne = new Employee(1, "John", "Bangalore", 3456.8*1.50);
		      Employee empTwo = new Employee(2, "Alex", "Mumbai", 555677.98*1.50);
		      Employee empThree = new Employee(3, "Steve", "Bangalore", 234556.67*1.50);
		      list.add(empOne);
		      list.add(empTwo);
		      list.add(empThree);
		      List<Employee> list2 = new ArrayList<Employee>();
	    	  Employee empfour = new Employee(4, "John", "Bangalore", 3456.8*1.50);
		      Employee empfive = new Employee(5, "Alex", "Mumbai", 555677.98*1.50);
		      Employee empsix = new Employee(6, "Steve", "Bangalore", 234556.67*1.50);
		      list2.add(empfour);
		      list2.add(empfive);
		      list2.add(empsix);
		      when(service.updateEmployee("Bangalore",50.00)).thenReturn(list); 
		      
		    //test
		       List<Employee> empList = service.updateEmployee("Bangalore",50.00);
		       assertNotEquals(list2, empList);
		       verify(service,times(1)).updateEmployee("Bangalore",50.00);
	    	
	    }
  
}
