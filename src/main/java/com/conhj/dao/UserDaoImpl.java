package com.conhj.dao;

import com.conhj.po.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.sql.ResultSet;
import java.util.List;

public class UserDaoImpl {
    private Configuration configuration=null;
    private SessionFactory sessionFactory=null;

    public UserDaoImpl(){
        configuration=new Configuration().configure("hibernate.cfg.xml");;
        sessionFactory=configuration.buildSessionFactory();
    }

    @Test
    public void add(){
        Session session=null;
        session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        UserEntity user=new UserEntity();
        user.setPwd("SSSSS");
        user.setName("kkkkk");
        try{
            session.save(user);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        session.close();
    }

    @Test
    public void del(){
        Session session=null;
        session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        UserEntity user=session.load(UserEntity.class,40);

        try{
            session.delete(user);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        session.close();
    }

    @Test
    public void update(){
       Session session=sessionFactory.openSession();
       Transaction transaction=session.beginTransaction();
       UserEntity user=session.load(UserEntity.class,39);
        try{
            user.setName("JK");
            user.setAge(18);
            user.setPwd("Rs");
            session.update(user);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        session.close();
    }
    @Test
    public void queryOne(){
        Session session=sessionFactory.openSession();
        try{
            UserEntity user=session.load(UserEntity.class,39);
          //  System.out.println("ok");
            System.out.println(user.getName()+" "+user.getPwd());
        }catch(Exception e){
            e.printStackTrace();
        }
        session.close();
    }
    @Test
    public void queryAll(){
        Session session=null;
        session=sessionFactory.openSession();
        List<UserEntity> list=session.createQuery("from UserEntity").list();
        list.forEach(user->System.out.printf("%s-%s\n",user.getName(),user.getPwd()));
        session.close();
    }

}
