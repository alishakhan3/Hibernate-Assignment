package com.springcore.hibernate2;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Users;
import entity.Netflix;
import entity.Countries;

public class App 
{
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
        Session s= sf.openSession();
        s.beginTransaction();

        //Basic account
        Netflix account1 = new Netflix();
        account1.setName("Basic");
        
        //Premium Account
        Netflix account2 = new Netflix();
        account2.setName("Premium");

        //Users
        Users user1 = new Users();
        user1.setName("Alisha");
        user1.setAccount(account1);

        Users user2 = new Users();
        user2.setName("Riddhi");
        user2.setAccount(account1);
        
        //Countries
        Countries country1 = new Countries();
        country1.setName("USA");

        Countries country2 = new Countries();
        country2.setName("UK");

        //set values
        account1.setUsers(Arrays.asList(user1, user2));
        account1.setCountries(Arrays.asList(country1, country2));
        account2.setCountries(Arrays.asList(country1));

        //persist
        s.persist(account1);
        s.persist(account2);
        s.persist(user1);
        s.persist(user2);
        s.persist(country1);
        s.persist(country2);
        
        s.getTransaction().commit();
        
        Netflix n = s.find(Netflix.class, account1.getId());
        
        System.out.println("\n1. One To One:\n");
        
        for (Users users : n.getUsers()) {
        	System.out.println(users.getName() + " has user ID: "+users.getId());
        }
        
        System.out.println("\n2. One To Many:\n");

        System.out.println("One " + n.getName() + " Netflix account is being used by:");
        for (Users users : n.getUsers()) {
            System.out.println(users.getName());
        }
        
        System.out.println("\n3. Many To One:\n");
        
        for (Users users : n.getUsers()) {
        	System.out.println(users.getName() + " is using Netflix account: "+account1.getName());
        }
        
        System.out.println("\n4. Many To Many:\n");
        
        System.out.println("Netflix account "+ n.getName() +" available in :");
        for (Countries country : n.getCountries()) {
            System.out.print(country.getName()+". ");
        }
        
        Netflix n2 = s.find(Netflix.class, account2.getId());
        System.out.println("\n\nNetflix account "+ n2.getName() +" available in :");
        for (Countries country : n2.getCountries()) {
            System.out.print(country.getName()+". ");
        }
        
        s.close();
    }
}

