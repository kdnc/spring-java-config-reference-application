package com.nuwan.dao;

import com.nuwan.model.CourseV1;

import java.util.List;

public interface CourseDaoV1 {

    public List<CourseV1> findAll();

    public CourseV1 findById(Long courseId);

//Usually, when using ORM for persisting objects, the insert and update operations are
//combined into a single operation (e.g., save).
//This is to let the ORM framework (not you) decide whether an object should be inserted or updated.
    public void save(CourseV1 course);

    public void delete(Long courseId);

}
