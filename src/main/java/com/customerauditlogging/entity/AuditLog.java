package com.customerauditlogging.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "audit_log")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String entityId;

    private String module;

    private String staffId;

    private String action;

    private String comment;

    @CreationTimestamp
    private Timestamp createdTime;
}
