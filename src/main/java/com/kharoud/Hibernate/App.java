package com.kharoud.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        
//        Configuration con = new Configuration();
//        SessionFactory sf = con.buildSessionFactory(); 
//        Session session = sf.openSession();
//        session.save( kharoud );
    }
}
