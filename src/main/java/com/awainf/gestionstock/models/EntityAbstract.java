package com.awainf.gestionstock.models;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntityAbstract {

    @Id
    @GeneratedValue

    private Integer id;

    @Column(name = "creationDate", nullable = false)
    @JsonIgnore
    @CreatedDate
    private Instant creationDate;

    @Column(name = "lastModifieDate")
    @JsonIgnore
    @LastModifiedDate
    private Instant lastModifieDate;

}
