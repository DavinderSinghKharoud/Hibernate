package com.kharoud.Hibernate;




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
    	
    	
    	
    	
        //Install JBoss from eclipse marketplace and add hibernate.cfg.xml
        //Configure hibernate 4.2.20.Final
        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
//        
//        ServiceRegistry ref = new ServiceRegistryBuilder().applySettings(con.getProperties()).
//        		buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory( ); 
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(alien);
        session.save(alien1);
        session.save(laptop);
        
        tx.commit();
    	
    }
    
}
