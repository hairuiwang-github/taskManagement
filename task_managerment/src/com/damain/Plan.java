package com.damain;

import java.util.Date;

public class Plan {
    private int id;//计划编号
    private String plan_name;//计划名称
    private String plan_state;//计划状态
    private String feedback;//回馈状态
    private Date plan_begin_date;//计划开始时间
    private Date plan_end_date;//计划结束时间
    private String plan_description;//计划描述
    private String plan_feedback;//反馈信息
    private String task_id;//任务编号


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public String getPlan_state() {
        return plan_state;
    }

    public void setPlan_state(String plan_state) {
        this.plan_state = plan_state;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getPlan_begin_date() {
        return plan_begin_date;
    }

    public void setPlan_begin_date(Date plan_begin_date) {
        this.plan_begin_date = plan_begin_date;
    }

    public Date getPlan_end_date() {
        return plan_end_date;
    }

    public void setPlan_end_date(Date plan_end_date) {
        this.plan_end_date = plan_end_date;
    }

    public String getPlan_description() {
        return plan_description;
    }

    public void setPlan_description(String plan_description) {
        this.plan_description = plan_description;
    }

    public String getPlan_feedback() {
        return plan_feedback;
    }

    public void setPlan_feedback(String plan_feedback) {
        this.plan_feedback = plan_feedback;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", plan_name='" + plan_name + '\'' +
                ", plan_state='" + plan_state + '\'' +
                ", feedback='" + feedback + '\'' +
                ", plan_begin_date=" + plan_begin_date +
                ", plan_end_date=" + plan_end_date +
                ", plan_description='" + plan_description + '\'' +
                ", plan_feedback='" + plan_feedback + '\'' +
                ", task_id='" + task_id + '\'' +
                '}';
    }
}
