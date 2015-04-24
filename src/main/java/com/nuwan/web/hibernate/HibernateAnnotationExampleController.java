package com.nuwan.web.hibernate;

import com.nuwan.dao.CourseDao;
import com.nuwan.dao.HibernateCourseDao;
import com.nuwan.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.GregorianCalendar;
import java.util.List;

@Controller
@RequestMapping(value = "hibernate/annotation/courses")
public class HibernateAnnotationExampleController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Course> findAllGreetings(){
        CourseDao courseDao = new HibernateCourseDao();
        Course course = new Course();
        course.setTitle("Core Spring");
        course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
        course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
        course.setFee(1000);
        courseDao.save(course);

        List<Course> courses = courseDao.findAll();
        Long courseId = courses.get(0).getId();
        course = courseDao.findById(courseId);

        return courses;
    }

}
