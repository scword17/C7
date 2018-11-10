package com.conhj.dao;

import com.conhj.po.HusbandEntity;
import com.conhj.po.WifeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class HusbandDaoImpl {
    private Configuration cfg=null;
    private SessionFactory sf=null;

    @Before
    public void init()
    {
        cfg=new Configuration().configure("hibernate.cfg.xml");
        sf=cfg.buildSessionFactory();
    }
    @Test
    public void add(){
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HusbandEntity hus=new HusbandEntity();
            WifeEntity wife=new WifeEntity();

            hus.setId("5");
            hus.setName("HLJ");
            wife.setWid("5");
            wife.setName("jilin");
            hus.setWife(wife);
            wife.setHus(hus);
            session.save(hus);
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
            HusbandEntity hus=session.load(HusbandEntity.class,"5");
            session.delete(hus);
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
            HusbandEntity hus=session.load(HusbandEntity.class,"5");
            hus.setName("LLL");
            hus.getWife().setName("kkk");
            session.update(hus);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }



    }
    @Test
    public void query(){
        Session session=sf.openSession();
        try{
            HusbandEntity hus=session.load(HusbandEntity.class,"5");
            System.out.println(hus.getName()+"的妻子是"+hus.getWife().getName());

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }



    }





}
