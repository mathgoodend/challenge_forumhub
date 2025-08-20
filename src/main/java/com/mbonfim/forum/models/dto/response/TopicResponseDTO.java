package com.mbonfim.forum.models.dto.response;

import com.mbonfim.forum.models.entities.enums.TopicStatus;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TopicResponseDTO {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdAt;
    private TopicStatus status;
    private CategoryResponseDTO category;
    private SubcategoryResponseDTO subcategory;
    private CourseResponseDTO course;
    private String user;
}
