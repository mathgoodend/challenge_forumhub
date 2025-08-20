package com.mbonfim.forum.conversors;

import com.mbonfim.forum.core.crud.CrudConverter;
import com.mbonfim.forum.models.dto.request.CourseDTO;
import com.mbonfim.forum.models.dto.response.CourseResponseDTO;
import com.mbonfim.forum.models.entities.Course;
import com.mbonfim.forum.repositories.Subcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter implements CrudConverter<Course, CourseDTO, CourseResponseDTO> {

    @Autowired
    Subcat subcategoryRepository;

    @Override
    public Course dtoCadToEntity(CourseDTO dtocad) {
        Course course = new Course();
        course.setName(dtocad.getNome());
        course.setSubcategory(subcategoryRepository.getReferenceById(dtocad.getSubcategoryId()));
        return course;
    }

    @Override
    public CourseResponseDTO entityToDTOResponse(Course entity) {
        if (entity == null) return null;
        return new CourseResponseDTO(entity.getId(), entity.getName());
    }
}
