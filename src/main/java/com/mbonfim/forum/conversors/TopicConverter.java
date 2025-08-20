package com.mbonfim.forum.conversors;

import com.mbonfim.forum.core.crud.CrudConverter;
import com.mbonfim.forum.models.dto.request.TopicDTO;
import com.mbonfim.forum.models.dto.response.TopicResponseDTO;
import com.mbonfim.forum.models.entities.Category;
import com.mbonfim.forum.models.entities.Course;
import com.mbonfim.forum.models.entities.Subcategory;
import com.mbonfim.forum.models.entities.Topic;
import com.mbonfim.forum.models.entities.enums.TopicStatus;
import com.mbonfim.forum.services.CategoryService;
import com.mbonfim.forum.services.CourseService;
import com.mbonfim.forum.services.SubcategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TopicConverter implements CrudConverter<Topic, TopicDTO, TopicResponseDTO> {

    CourseConverter courseConverter;
    CourseService courseService;

    CategoryConverter categoryConverter;
    CategoryService categoryService;

    SubcategoryConverter subcategoryConverter;
    SubcategoryService subcategoryService;

    @Override
    public Topic dtoCadToEntity(TopicDTO dtocad) {
        Topic topic = new Topic();
        topic.setTitle(dtocad.getTitle());
        topic.setMessage(dtocad.getMessage());
        if (dtocad.getCourseID() != null) {
            Course course = courseService.getReferenceByIdIfExist(dtocad.getCourseID());
            Subcategory subcategory = course.getSubcategory();
            Category category = subcategory.getCategory();
            topic.setCourse(course);
            topic.setSubcategory(subcategory);
            topic.setCategory(category);
        } else {
            if (dtocad.getSubcategoryId() != null)
                topic.setSubcategory(subcategoryService.getReferenceByIdIfExist(dtocad.getSubcategoryId()));
            if (dtocad.getCategoryId() != null)
                topic.setCategory(categoryService.getReferenceByIdIfExist(dtocad.getCategoryId()));
        }
        return topic;
    }

    @Override
    public TopicResponseDTO entityToDTOResponse(Topic entity) {
        return new TopicResponseDTO(entity.getId(),
                entity.getTitle(),
                entity.getMessage(),
                entity.getCreatedAt(),
                TopicStatus.findById(entity.getStatus()),
                categoryConverter.entityToDTOResponse(entity.getCategory()),
                subcategoryConverter.entityToDTOResponse(entity.getSubcategory()),
                courseConverter.entityToDTOResponse(entity.getCourse()),
                entity.getAuthor().getName()
        );
    }
}
