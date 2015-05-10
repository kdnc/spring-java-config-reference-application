package com.nuwan.web.hibernate;

import com.nuwan.dao.CourseDaoV1;
import com.nuwan.dao.HibernateCourseDaoV1;
import com.nuwan.model.CourseV1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.GregorianCalendar;
import java.util.List;

@Controller
@RequestMapping(value = "data-persistence-orm-transactions/orm/hibernate-xml-mapping/courses")
public class HibernateXMLMappingExampleController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<CourseV1> findAllGreetings(){
        CourseDaoV1 courseDao = new HibernateCourseDaoV1();
        CourseV1 course = new CourseV1();
        course.setTitle("Core Spring");
        course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
        course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
        course.setFee(1000);
        courseDao.save(course);

        List<CourseV1> courses = courseDao.findAll();
        Long courseId = courses.get(0).getId();
        course = courseDao.findById(courseId);

        return courses;
    }

}
