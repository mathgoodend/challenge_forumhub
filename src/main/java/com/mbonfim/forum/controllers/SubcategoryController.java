package com.mbonfim.forum.controllers;

import com.mbonfim.forum.core.crud.CrudController;
import com.mbonfim.forum.models.dto.request.SubcategoryDTO;
import com.mbonfim.forum.models.dto.response.SubcategoryResponseDTO;
import com.mbonfim.forum.models.entities.Subcategory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subcategories")
public class SubcategoryController extends CrudController<Subcategory, Long, SubcategoryDTO, SubcategoryResponseDTO> {

}
