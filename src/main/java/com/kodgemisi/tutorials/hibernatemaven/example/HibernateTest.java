package com.kodgemisi.tutorials.hibernatemaven.example;
 
import java.util.List;
 
 


import com.kodgemisi.tutorials.hibernatemaven.domain.Department;
import com.kodgemisi.tutorials.hibernatemaven.domain.Employee;
import com.kodgemisi.tutorials.hibernatemaven.util.*;

import org.hibernate.*;
 
public class HibernateTest {
 
public static void main(String[] args) {
          
        Session session = HibernateUtil.getSessionFactory().openSession();
  
        session.beginTransaction();
 
        Department department = new Department("java");
        session.save(department);
 
        session.save(new Employee("First Employee",department));
        session.save(new Employee("Second Employee",department));
      
        session.getTransaction().commit();
 
        Query q = session.createQuery("From Employee ");
                 
        List<Employee> resultList = q.list();
        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }
 
        System.exit(0);
    }
    
}