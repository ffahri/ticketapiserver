package com.webischia.apiserver.api.v1.model;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class AccessLevelDTO {
    private int id;

    private String description;
    private Date creationDate = new Date();
}
