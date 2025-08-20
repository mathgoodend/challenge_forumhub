package com.mbonfim.forum.conversors;

import com.mbonfim.forum.core.crud.CrudConverter;
import com.mbonfim.forum.models.dto.request.CategoryDTO;
import com.mbonfim.forum.models.dto.response.CategoryResponseDTO;
import com.mbonfim.forum.models.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements CrudConverter<Category, CategoryDTO, CategoryResponseDTO> {

    @Override
    public Category dtoCadToEntity(CategoryDTO dtocad) {
        Category category = new Category();
        category.setName(dtocad.getNome());
        return category;
    }

    @Override
    public CategoryResponseDTO entityToDTOResponse(Category entity) {
        return new CategoryResponseDTO(entity.getId(), entity.getName());
    }
}
