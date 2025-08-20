package com.mbonfim.forum.conversors;

import com.mbonfim.forum.core.crud.CrudConverter;
import com.mbonfim.forum.models.dto.request.AnswerDTO;
import com.mbonfim.forum.models.dto.response.AnswerResponseDTO;
import com.mbonfim.forum.models.dto.response.UserResponseDTO;
import com.mbonfim.forum.models.entities.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswerConverter implements CrudConverter<Answer, AnswerDTO, AnswerResponseDTO> {

    @Override
    public Answer dtoCadToEntity(AnswerDTO dtocad) {
        Answer answer = new Answer();
        answer.setMessage(dtocad.getMessage());
        return answer;
    }

    @Override
    public AnswerResponseDTO entityToDTOResponse(Answer entity) {
        return new AnswerResponseDTO(entity.getId(), entity.getMessage(), entity.getCreatedAt(), new UserResponseDTO(entity.getAuthor().getName()));
    }
}
