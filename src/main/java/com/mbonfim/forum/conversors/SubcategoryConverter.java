package com.mbonfim.forum.conversors;

import com.mbonfim.forum.core.crud.CrudConverter;
import com.mbonfim.forum.models.dto.request.SubcategoryDTO;
import com.mbonfim.forum.models.dto.response.SubcategoryResponseDTO;
import com.mbonfim.forum.models.entities.Subcategory;
import org.springframework.stereotype.Component;

@Component
public class SubcategoryConverter implements CrudConverter<Subcategory, SubcategoryDTO, SubcategoryResponseDTO> {
    @Override
    public Subcategory dtoCadToEntity(SubcategoryDTO dtocad) {
        Subcategory subcategory = new Subcategory();
        subcategory.setName(dtocad.getNome());
        return subcategory;
    }

    @Override
    public SubcategoryResponseDTO entityToDTOResponse(Subcategory entity) {
        if (entity == null) return null;
        return new SubcategoryResponseDTO(entity.getId(), entity.getName());
    }
}
