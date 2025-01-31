package com.globant.educationalcenter.auditories;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Audit {

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
