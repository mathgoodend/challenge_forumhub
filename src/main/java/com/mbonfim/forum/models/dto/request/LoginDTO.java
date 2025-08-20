package com.mbonfim.forum.models.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank
        String login,
        @NotBlank
        String password) {
}
