package com.fullstack.service.test;

import com.fullstack.model.Employee;
import com.fullstack.repository.EmployeeRepository;
import com.fullstack.service.IEmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

    @Autowired
    private IEmployeeService employeeService;

    @MockitoBean
    private EmployeeRepository employeeRepository;

    @Test
    public void saveTest() {

        Employee employee = new Employee(121, "SWARA", "PCMC, INDIA", 98998989989L, 98000);

        employeeService.save(employee);

        Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);

    }

    @Test
    public void findAllTest() {

        Mockito.when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(122, "DARSHAN", "INDIA", 9899898989L, 96000),
                new Employee(123, "RUPESH", "INDIA", 6699898989L, 91000),
                new Employee(191, "SHUBHAM", "INDIA", 9999898989L, 99000)).toList());

        Assert.assertEquals(3, employeeService.findAll().size());


    }

    @Test
    public void updateTest() {
        Employee employee = new Employee(121, "SWARA", "PCMC, INDIA", 98998989989L, 98000);

        employeeService.update(employee);

        Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);
    }

    @Test
    public void deleteByIdTest() {
        Employee employee = new Employee(121, "SWARA", "PCMC, INDIA", 98998989989L, 98000);

        employeeService.deleteById(employee.getEmpId());

        Mockito.verify(employeeRepository, Mockito.times(1)).deleteById(employee.getEmpId());
    }


}
