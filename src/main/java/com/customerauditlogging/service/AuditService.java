package com.customerauditlogging.service;

import com.customerauditlogging.entity.AuditLog;
import com.customerauditlogging.repository.AuditRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public void storeAuditLog(String action,
                              String module,
                              String staffId,
                              String entityId, String comment) {
        AuditLog auditLog = AuditLog
                .builder()
                .action(action)
                .entityId(entityId)
                .module(module)
                .staffId(staffId)
                .build();
        auditRepository.save(auditLog);
    }
}
