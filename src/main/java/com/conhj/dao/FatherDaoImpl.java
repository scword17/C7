package com.conhj.dao;

import com.conhj.po.FatherEntity;
import com.conhj.po.HusbandEntity;
import com.conhj.po.SonEntity;
import com.conhj.po.WifeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class FatherDaoImpl {
    private Configuration cfg=null;
    private SessionFactory sf=null;
    @Before
    public void init(){
        cfg=new Configuration().configure("hibernate.cfg.xml");
        sf=cfg.buildSessionFactory();
    }
    @Test
    public void add(){
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            FatherEntity f=new FatherEntity();
            f.setFid("8");
            f.setFname("JKKKK");
            SonEntity son1=new SonEntity();
            son1.setId("32");
            son1.setSname("son33");

            SonEntity son2=new SonEntity();
            son2.setId("33");
            son2.setSname("son31");

            SonEntity son3=new SonEntity();
            son3.setId("34");
            son3.setSname("son32");

            son1.setFather(f);
            son2.setFather(f);
            son3.setFather(f);
            f.getSons().add(son1);
            f.getSons().add(son2);
            f.getSons().add(son3);
            session.save(f);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }



    }
    @Test
    public void del(){
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            FatherEntity f=session.load(FatherEntity.class,"7");
            session.delete(f);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }



    }

    @Test
    public void update(){
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            FatherEntity f=session.load(FatherEntity.class,"8");
           f.getSons().forEach(c->c.setSname("KK6666666"));
            session.update(f);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }




}
