package com.organize.my.life.api.workspace.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WorkspaceTest {
    @Test 
    void shouldCreateWorkspace() {
        Workspace workspace = new Workspace(
            "Game Engine",
            "Projeto de desenvolvimento"
        );

        assertNotNull(workspace.getId());
        assertEquals("Game Engine", workspace.getName());
        assertNotNull(workspace.getCreatedAt());
        assertEquals(
            workspace.getCreatedAt(),
            workspace.getUpdatedAt()
        );
    }    
    
    @Test 
    void shouldRejectBlankName() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Workspace("  ", "Descrição")
        );
    }

    @Test 
    void shoudlUpdateWorkspace() {
        Workspace workspace = new Workspace(
            "Antigo nome", 
            null
        );

        workspace.update("Novo nome", "Nova descrição");

        assertEquals("Novo nome", workspace.getName());
        assertEquals("Nova descrição", workspace.getDescription());
    }

    @Test 
    void shouldRejectLongDescription() {
        String description = "A".repeat(501);

        assertThrows(
            IllegalArgumentException.class, 
            () -> new Workspace("Projeto", description)
        );
    }
}
