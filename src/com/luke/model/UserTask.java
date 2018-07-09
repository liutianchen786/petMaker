package com.luke.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-05-15
 */
public class UserTask implements Serializable{
    /**
	 * 1
	 */
	private static final long serialVersionUID = 419887551428222665L;


	/**
     * 任务ID
     */
    private Integer taskid;


    /**
     * 任务名称
     */
    private String taskname;

    /**
     * 任务得分
     */
    private Integer taskscore;

    /**
     * 任务类型 0定时更新任务 1不更新任务
     */
    private String tasktype;

    /**
     * 是否完成任务 1完成 0 未完成
     */
    private String doneornot;

    /**
     * 操作人id
     */
    private String operationid;

    /**
     * 操作时间
     */
    private Date operationtime;

    /**
     * 0为不作废 1为作废
     */
    private String zfflag;

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }


    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
    }

    public Integer getTaskscore() {
        return taskscore;
    }

    public void setTaskscore(Integer taskscore) {
        this.taskscore = taskscore;
    }

    public String getTasktype() {
        return tasktype;
    }

    public void setTasktype(String tasktype) {
        this.tasktype = tasktype == null ? null : tasktype.trim();
    }

    public String getDoneornot() {
        return doneornot;
    }

    public void setDoneornot(String doneornot) {
        this.doneornot = doneornot == null ? null : doneornot.trim();
    }

    public String getOperationid() {
        return operationid;
    }

    public void setOperationid(String operationid) {
        this.operationid = operationid == null ? null : operationid.trim();
    }

    public Date getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Date operationtime) {
        this.operationtime = operationtime;
    }

    public String getZfflag() {
        return zfflag;
    }

    public void setZfflag(String zfflag) {
        this.zfflag = zfflag == null ? null : zfflag.trim();
    }
}