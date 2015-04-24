package com.nuwan.web.restExamples;

import com.nuwan.dao.CourseDaoV1;
import com.nuwan.dao.HibernateCourseDaoV1;
import com.nuwan.model.CourseV1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "rest/examples/courses")
public class RestExamplesController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<CourseV1> findAllCourses(){
        CourseDaoV1 courseDao = new HibernateCourseDaoV1();
        List<CourseV1> courses = courseDao.findAll();

        return courses;
    }

}
