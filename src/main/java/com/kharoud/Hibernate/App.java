package com.kharoud.Hibernate;




import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
 
    	Alien alien = new Alien();
    	alien.setAid(1);
    	alien.setAname("Sunny");
        
    	Alien alien1 = new Alien();
    	alien1.setAid(2);
    	alien1.setAname("Kharoud");
    	
    	Laptop laptop = new Laptop();
    	laptop.setLid(101);
    	laptop.setBrand("DELL");
    	laptop.setPrice(1000);
    	laptop.setAlien(alien);
   	
    	
    	
  
        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
        
        ServiceRegistry ref = new ServiceRegistryBuilder().applySettings(con.getProperties()).
        		buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory( ref); 
        Session session1 = sf.openSession();
        
        Transaction tx1 = session1.beginTransaction();
        
//        session.save(alien1);
//        session.save(alien);
//        session.save(laptop);
     
        Alien a = (Alien) session1.get(Alien.class, 1);
        System.out.println(a);
        tx1.commit();
        
        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();
        
     
        Alien a2 = (Alien) session2.get(Alien.class, 1);
        System.out.println(a);
        tx2.commit();
    	
    }
    
}
