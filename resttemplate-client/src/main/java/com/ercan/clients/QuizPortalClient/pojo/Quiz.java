package com.ercan.clients.QuizPortalClient.pojo;

import lombok.Data;

@Data
public class Quiz {

    public int id;
    public String createdDate;
    public String createdBy;
    public int recordStatus;
    public String title;
    public String description;
    public String maxMarks;
    public String numberOfQuestions;
    public int enabled;
    public Category category;
}
