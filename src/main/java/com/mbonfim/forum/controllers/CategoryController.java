package com.mbonfim.forum.controllers;

import com.mbonfim.forum.core.crud.CrudController;
import com.mbonfim.forum.models.dto.request.CategoryDTO;
import com.mbonfim.forum.models.dto.response.CategoryResponseDTO;
import com.mbonfim.forum.models.entities.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController extends CrudController<Category, Long, CategoryDTO, CategoryResponseDTO> {

}
