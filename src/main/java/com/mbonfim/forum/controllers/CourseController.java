package com.mbonfim.forum.controllers;

import com.mbonfim.forum.core.crud.CrudController;
import com.mbonfim.forum.models.dto.request.CourseDTO;
import com.mbonfim.forum.models.dto.response.CourseResponseDTO;
import com.mbonfim.forum.models.entities.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController extends CrudController<Course, Long, CourseDTO, CourseResponseDTO> {
}
