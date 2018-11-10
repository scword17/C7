package com.conhj.dao;

import com.conhj.po.CourseEntity;
import com.conhj.po.StudentEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class StuDaoImpl {
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
            StudentEntity stu1=new StudentEntity();
            CourseEntity cou1=new CourseEntity();
            StudentEntity stu2=new StudentEntity();
            CourseEntity cou2=new CourseEntity();
            stu1.setSno("40");
            stu2.setSno("41");
            stu1.setSname("qq40");
            stu2.setSname("qq41");

            cou1.setCno("10");
            cou1.setCname("java");
            cou2.setCno("11");
            cou2.setCname("java ee");
            stu1.getCourses().add(cou1);
            stu1.getCourses().add(cou2);
            stu2.getCourses().add(cou1);
            stu2.getCourses().add(cou2);

            cou1.getStus().add(stu1);
            cou1.getStus().add(stu2);
            cou2.getStus().add(stu1);
            cou2.getStus().add(stu2);

            session.save(stu1);
            session.save(stu2);

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
            StudentEntity stu=session.load(StudentEntity.class,"41");
            session.delete(stu);
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
            StudentEntity stu=session.load(StudentEntity.class,"41");
            stu.setSname("qq41");
            session.update(stu);
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
            StudentEntity stu=session.load(StudentEntity.class,"41");
            stu.getCourses().forEach(c->System.out.println(c.getCname()));

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Test
    public void TestLazyLoad(){
        Session session=sf.openSession();
        StudentEntity stu=null;
        try{
            stu=session.load(StudentEntity.class,"41");
        //    stu.getCourses().forEach(c->System.out.println(c.getCname()));
            if(!Hibernate.isInitialized(stu.getCourses()))
            {
                Hibernate.initialize(stu.getCourses());

            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            System.out.println(stu.getCourses().size());
        }
    }

}
