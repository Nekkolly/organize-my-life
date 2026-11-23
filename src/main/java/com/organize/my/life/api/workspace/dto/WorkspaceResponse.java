package com.organize.my.life.api.workspace.dto;

import java.time.Instant;
import java.util.UUID;

import com.organize.my.life.api.workspace.model.Workspace;

public record WorkspaceResponse (
    UUID id,
    String name,
    String description,
    Instant createdAt,
    Instant updatedAt
){
    public static WorkspaceResponse from(Workspace workspace) {
        return new WorkspaceResponse(
            workspace.getId(), 
            workspace.getName(), 
            workspace.getDescription(), 
            workspace.getCreatedAt(),
            workspace.getUpdatedAt()
        );
    }
}
