package com.neclecture.app.entity;

import java.util.Date;

public class Notice {
    private int id;
    private String title;
    private String writerId;
    private Date regDate;
    private String content;
    private int hit;
    private String files;
    
    public Notice() {
    
    }
    
    public Notice(int id, String title, String writerId, Date regDate, String content, int hit, String files) {
        this.id = id;
        this.title = title;
        this.writerId = writerId;
        this.regDate = regDate;
        this.content = content;
        this.hit = hit;
        this.files = files;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getWriterId() {
        return writerId;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }
    
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public void setHit(int hit) {
        this.hit = hit;
    }
    
    public String getFiles() {
        return files;
    }
    
    public void setFiles(String files) {
        this.files = files;
    }
    
    public Date getRegDate() {
        return regDate;
    }
    
    public String getContent() {
        return content;
    }
    
    public int getHit() {
        return hit;
    }
    
    public int getId() {
        return id;
    }
    
}
