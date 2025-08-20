package com.mbonfim.forum.services;

import com.mbonfim.forum.core.crud.CrudService;
import com.mbonfim.forum.models.entities.Category;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends CrudService<Category, Long> {
    @Override
    protected Category editEntity(Category oldEntity, Category entityToSave) {
        oldEntity.setName(entityToSave.getName());
        return oldEntity;
    }

    @Override
    public Category getReferenceByIdIfExist(Long id) {
        if (!existsById(id)) throw new EntityNotFoundException("Category with id " + id + " not exist!");
        return getReferenceById(id);
    }

}
