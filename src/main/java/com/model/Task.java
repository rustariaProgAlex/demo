package com.model;


import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "executor")
    private Long executor;

    @Column(name = "TasksGroupId")
    private Long tasksGroupId;

    @Column(name = "startDate")
    private Timestamp startDate;

    @Column(name = "finishDate")
    private Timestamp finishDate;

    @Column(name = "priority")
    private byte priority;

    @Column(name = "pos")
    private int pos;

    @Column(name = "parent")
    private Long parent;

    @Column(name = "cover")
    private String cover;

    @Lob
    @Column(name = "[file]")
    private byte[] file;

    @Column(name = "color")
    private String color;

    @Column(name = "status")
    private boolean status;

    // getters and setters

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return BigInteger return the executor
     */
    public Long getExecutor() {
        return executor;
    }

    /**
     * @param executor the executor to set
     */
    public void setExecutor(Long executor) {
        this.executor = executor;
    }

    /**
     * @return BigInteger return the tasksGroupId
     */
    public Long getTasksGroupId() {
        return tasksGroupId;
    }

    /**
     * @param tasksGroupId the tasksGroupId to set
     */
    public void setTasksGroupId(Long tasksGroupId) {
        this.tasksGroupId = tasksGroupId;
    }

    /**
     * @return Timestamp return the startDate
     */
    public Timestamp getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    /**
     * @return Timestamp return the finishDate
     */
    public Timestamp getFinishDate() {
        return finishDate;
    }

    /**
     * @param finishDate the finishDate to set
     */
    public void setFinishDate(Timestamp finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * @return byte return the priority
     */
    public byte getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(byte priority) {
        this.priority = priority;
    }

    /**
     * @return short return the pos
     */
    public int getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(int pos) {
        this.pos = pos;
    }

    /**
     * @return BigInteger return the parent
     */
    public Long getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }

    /**
     * @return String return the cover
     */
    public String getCover() {
        return cover;
    }

    /**
     * @param cover the cover to set
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * @return Blob return the file
     */
    public  byte[] getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile( byte[] file) {
        this.file = file;
    }

    /**
     * @return String return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return boolean return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}


    
    


