package com.kharoud.Hibernate;




import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
    	//laptop.setAlien(alien);
   	
    	
        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class);
        
        ServiceRegistry ref = new ServiceRegistryBuilder().applySettings(con.getProperties()).
        		buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory( ref); 
        
        Session session1 = sf.openSession();
        
        Transaction tx1 = session1.beginTransaction();
        
        
        Laptop l = new Laptop();
        l.setLid(32);
        l.setBrand("Dell");
        l.setPrice(3232);
        
        session1.save(l);
        l.setPrice(300);
        tx1.commit();
        
    }
    
}
