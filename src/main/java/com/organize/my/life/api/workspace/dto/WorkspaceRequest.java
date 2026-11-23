package com.organize.my.life.api.workspace.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record WorkspaceRequest (
    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    String name,
    
    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
    String description
){}
