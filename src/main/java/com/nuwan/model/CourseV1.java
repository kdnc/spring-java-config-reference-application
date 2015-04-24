package com.nuwan.model;

import java.util.Date;

public class CourseV1 {

    //For each entity class, you must define an identifier property to uniquely identify an entity.
    //It’s a best practice to define an auto-generated identifier because this has no business meaning and thus won’t be changed under any
    //circumstances. Moerover, this identifier will be used by the ORM framework to determine an entity’s state.
    //If the identifier value is null, this entity will be treated as a new and unsaved entity. When this entity is persisted, an insert
    //SQL statement will be issued; otherwise, an update statement will. To allow the identifier to be null, you should
    //choose a primitive wrapper type like java.lang.Integer and java.lang.Long for the identifier.
    private Long id;
    private String title;
    private Date beginDate;
    private Date endDate;
    private int fee;

    //Remember that for each entity class to be persisted by an ORM framework, a
    //default constructor with no argument is required.
    public CourseV1(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

}
