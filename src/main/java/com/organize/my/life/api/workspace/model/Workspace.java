package com.organize.my.life.api.workspace.model;

import java.time.Instant;
import java.util.UUID;

public class Workspace {
    private final UUID id;
    private String name;
    private String description;
    private final Instant createdAt;
    private Instant updatedAt;

    public Workspace(String name, String description) {
        this.id = UUID.randomUUID();
        this.name = validateName(name);
        this.description = normalizeDescription(description);
        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
    }

    public void update(String name, String description) {
        String validName = validateName(name);
        String validDescription = normalizeDescription(description);

        this.name = validName;
        this.description = validDescription;
        this.updatedAt = Instant.now();
    }

    public static String validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O nome da área de trabalho é obrigatório");
        }
        String normalized = name.strip();
        if (normalized.length() > 100) {
            throw new IllegalArgumentException("O nome deve ter no máximo 100 caracteres");
        }
        return normalized;
    }

    public static String normalizeDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("A descrição da área de trabalho é obrigatório");
        }
        String normalized = description.strip();
        if (normalized.length() > 500) {
            throw new IllegalArgumentException("A descrição deve ter no máximo 500 caracteres");
        }
        return normalized;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
