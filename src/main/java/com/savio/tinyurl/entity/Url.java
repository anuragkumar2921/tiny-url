package com.savio.tinyurl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by anurag on 17/2/21.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String originalUrl;
    private String tinyUrl;
    private Date createdDate;
    private Date updatedDate;
}
