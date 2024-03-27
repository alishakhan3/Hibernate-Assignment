package com.springcore.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.employee;

public class App 
{
    public static void main( String[] args )
    {
        employee e=new employee();
        e.setEmpName("Alisha Khan");
        e.setEmpEmail("alisha@accolite"); //first entry
        
        employee e2=new employee();
        e2.setEmpName("Riddhi");
        e2.setEmpEmail("riddhi@gmail"); //second entry
        
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session s= sf.openSession();
        s.beginTransaction();
        
        //create
        s.persist(e);
        s.persist(e2);
        System.out.println();
        s.createQuery("from employee", employee.class).list().forEach(System.out::println);
        System.out.println();
        
        //delete
        s.remove(e);
        s.createQuery("from employee", employee.class).list().forEach(System.out::println);
        System.out.println();
        
        //update using merge
        e2.setEmpEmail("riddhi@accolite");
        s.merge(e2);
        s.createQuery("from employee", employee.class).list().forEach(System.out::println);
        System.out.println();
        
        s.getTransaction().commit();
        s.close();
    }
}
