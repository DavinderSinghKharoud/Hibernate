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
        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("DELL");
        
        Student s = new Student();
        s.setName("Davinder");
        s.setRollno(1);
        s.setMarks(100);
        //It has create another table called as student_laptop
        s.getLaptop().add(laptop);
        
        
        //Install JBoss from eclipse marketplace and add hibernate.cfg.xml
        //Configure hibernate 4.2.20.Final
        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        
        ServiceRegistry ref = new ServiceRegistryBuilder().applySettings(con.getProperties()).
        		buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory( ref); 
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(laptop);
        session.save(s);
        
        tx.commit();
    	
    }
    
}
