package com.mbonfim.forum.services;

import com.mbonfim.forum.core.crud.CrudService;
import com.mbonfim.forum.models.entities.Course;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends CrudService<Course, Long> {
    @Override
    protected Course editEntity(Course oldEntity, Course entityToSave) {
        oldEntity.setName(entityToSave.getName());
        return oldEntity;
    }

    @Override
    public Course getReferenceByIdIfExist(Long id) {
        if (!existsById(id)) throw new EntityNotFoundException("Course with id " + id + " not exist!");
        return getReferenceById(id);
    }
}
