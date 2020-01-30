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
    	laptop.setAlien(alien);
   	
    	
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        
        ServiceRegistry ref = new ServiceRegistryBuilder().applySettings(con.getProperties()).
        		buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory( ref); 
        
        Session session1 = sf.openSession();
        
        Transaction tx1 = session1.beginTransaction();
//        
//        Random r = new Random();
//        
//        for(int i = 1; i<=50;i++) {
//        	Student s= new Student();
//        	s.setRollno(i);
//        	s.setMarks(r.nextInt(100));
//        	s.setName("Sunny");
//        	session1.save(s);
//        }
      
        //Native Queries
        SQLQuery query = session1.createSQLQuery("Select name, marks from student where marks>60");
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List students = query.list();
        
        
        for( Object o: students) {
        	Map m =(Map)o;
        	System.out.println(m.get("name")+" : " + m.get("marks"));
        }
        tx1.commit();
        
    }
    
}
