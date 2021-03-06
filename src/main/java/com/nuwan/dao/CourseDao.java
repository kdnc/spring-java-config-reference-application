package com.nuwan.dao;

import com.nuwan.model.Course;

import java.util.List;

public interface CourseDao {

    public List<Course> findAll();

    public Course findById(Long courseId);

//Usually, when using ORM for persisting objects, the insert and update operations are
//combined into a single operation (e.g., save).
//This is to let the ORM framework (not you) decide whether an object should be inserted or updated.
    public void save(Course course);

    public void delete(Long courseId);

}
