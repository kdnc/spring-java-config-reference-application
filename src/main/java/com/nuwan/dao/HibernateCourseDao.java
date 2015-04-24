package com.nuwan.dao;

import com.nuwan.model.Course;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateCourseDao implements CourseDao {

    private SessionFactory sessionFactory;

    public HibernateCourseDao() {
//        Create a Configuration object and ask it to load the Hibernate
//        configuration file. By default, it loads hibernate.cfg.xml from the classpath
//        root when you call the configure() method.
        Configuration configuration = new Configuration().configure();
//        The purpose of a session factory
//        is to produce sessions for you to persist your objects.
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public List<Course> findAll() {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Course");
            return query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public Course findById(Long courseId) {
        Session session = sessionFactory.openSession();
        try {
            return (Course) session.get(Course.class, courseId);
        } finally {
            session.close();
        }
    }

    @Override
    public void save(Course course) {
        Session session = sessionFactory.openSession();
//        For any operation that involves
//        database update, such as saveOrUpdate() and delete(), you must
//        start a Hibernate transaction on that session.
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            session.saveOrUpdate(course);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
        } finally {
//       Finally, you must remember to close a session to release the resources held by this session.
            session.close();
        }
    }

    @Override
    public void delete(Long courseId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            Course course = (Course) session.get(Course.class, courseId);
            session.delete(course);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
