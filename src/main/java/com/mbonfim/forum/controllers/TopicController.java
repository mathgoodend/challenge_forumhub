package com.mbonfim.forum.controllers;

import com.mbonfim.forum.conversors.AnswerConverter;
import com.mbonfim.forum.core.crud.CrudController;
import com.mbonfim.forum.models.dto.request.AnswerDTO;
import com.mbonfim.forum.models.dto.request.TopicDTO;
import com.mbonfim.forum.models.dto.response.AnswerResponseDTO;
import com.mbonfim.forum.models.dto.response.TopicResponseDTO;
import com.mbonfim.forum.models.entities.Answer;
import com.mbonfim.forum.models.entities.Topic;
import com.mbonfim.forum.models.projections.AnswerSlim;
import com.mbonfim.forum.models.projections.TopicCompleteDTO;
import com.mbonfim.forum.models.projections.TopicSlimDTO;
import com.mbonfim.forum.services.AnswerService;
import com.mbonfim.forum.services.TopicService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
@AllArgsConstructor
public class TopicController extends CrudController<Topic, Long, TopicDTO, TopicResponseDTO> {

    private TopicService topicService;
    private AnswerService answerService;
    private AnswerConverter answerConverter;

    @Override
    public ResponseEntity<Page<TopicSlimDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(topicService.findAllSlim(pageable));
    }

    @Override
    public ResponseEntity<TopicCompleteDTO> findById(@PathVariable("id") Long aLong) {
        return ResponseEntity.ok(topicService.findComplete(aLong));
    }

    @GetMapping("/{id}/answers")
    public ResponseEntity<Page<AnswerSlim>> findAnswersByTopic(@PathVariable("id") Long id, Pageable pageable) {
        Page<AnswerSlim> answers = answerService.findAllByTopicId(id, pageable);
        return ResponseEntity.ok(answers);
    }

    @Transactional
    @PostMapping("/{id}/answers")
    public ResponseEntity<AnswerResponseDTO> addAnswerToPost(@PathVariable("id") Long id, @RequestBody @Valid AnswerDTO answerDTO) {
        Answer answer = answerConverter.dtoCadToEntity(answerDTO);
        Answer answer1 = topicService.addAnswerToPost(answer, id);
        return ResponseEntity.ok(answerConverter.entityToDTOResponse(answer1));
    }


}
