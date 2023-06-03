package com.ercan.clients.QuizPortalClient.pojo;

import lombok.Data;

@Data
public class Category {

    public int id;
    public String createdDate;
    public String createdBy;
    public int recordStatus;
    public String title;
    public String description;

}
