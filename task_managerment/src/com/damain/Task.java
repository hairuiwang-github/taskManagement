package com.damain;

import java.util.Date;

public class Task {
    private int id;//任务编号
    private String task_name;//任务名称
    private Date task_begin_time;//任务开始时间
    private Date task_end_time;//任务结束时间
    private String task_description;//任务描述
    private String task_state;//任务状态
    private String staff_id;//员工id
    private String emp_id;//主管id


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public Date getTask_begin_time() {
        return task_begin_time;
    }

    public void setTask_begin_time(Date task_begin_time) {
        this.task_begin_time = task_begin_time;
    }

    public Date getTask_end_time() {
        return task_end_time;
    }

    public void setTask_end_time(Date task_end_time) {
        this.task_end_time = task_end_time;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public String getTask_state() {
        return task_state;
    }

    public void setTask_state(String task_state) {
        this.task_state = task_state;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task_name='" + task_name + '\'' +
                ", task_begin_time=" + task_begin_time +
                ", task_end_time=" + task_end_time +
                ", task_description='" + task_description + '\'' +
                ", task_state='" + task_state + '\'' +
                ", staff_id='" + staff_id + '\'' +
                ", emp_id='" + emp_id + '\'' +
                '}';
    }
}
