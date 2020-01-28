package com.kharoud.Hibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien kharoud = new Alien();
        kharoud.setAid(1);
        kharoud.setAname("kharoud");
        kharoud.setColors("black");
        
        //Install JBoss from eclipse marketplace and add hibernate.cfg.xml
        //Configure hibernate 4.2.20.Final
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory(); 
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save( kharoud );
        tx.commit();
    	
    	System.out.println("hell0");
    }
    
}
