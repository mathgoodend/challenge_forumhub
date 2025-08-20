package com.mbonfim.forum.services;

import com.mbonfim.forum.core.crud.CrudService;
import com.mbonfim.forum.models.entities.Answer;
import com.mbonfim.forum.models.entities.Topic;
import com.mbonfim.forum.models.entities.User;
import com.mbonfim.forum.models.entities.enums.TopicStatus;
import com.mbonfim.forum.models.projections.TopicCompleteDTO;
import com.mbonfim.forum.models.projections.TopicSlimDTO;
import com.mbonfim.forum.repositories.AnswerRepository;
import com.mbonfim.forum.repositories.TopicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicService extends CrudService<Topic, Long> {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    protected Topic editEntity(Topic oldEntity, Topic entityToSave) {
        oldEntity.setCategory(entityToSave.getCategory());
        oldEntity.setSubcategory(entityToSave.getSubcategory());
        oldEntity.setCourse(entityToSave.getCourse());
        oldEntity.setMessage(entityToSave.getMessage());
        oldEntity.setTitle(entityToSave.getTitle());
        return oldEntity;
    }

    @Override
    public Topic save(Topic entity) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        entity.setAuthor(user);
        return super.save(entity);
    }

    public Page<TopicSlimDTO> findAllSlim(Pageable pageable) {
        return topicRepository.findAllBy(pageable);
    }

    public TopicCompleteDTO findComplete(Long id) {
        return topicRepository.findTopicCompleteById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topic with id " + id + " not found!"));
    }

    public Answer addAnswerToPost(Answer answer, Long idPost) {
        Topic topic = getReferenceByIdIfExist(idPost);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        answer.setTopic(topic);
        answer.setCreatedAt(LocalDateTime.now());
        answer.setAuthor(user);
        if (topicRepository.findStatusById(idPost) == 1) {
            topic.setStatus(TopicStatus.NAO_SOLUCIONADO.getId());
        }
        return answerRepository.save(answer);
    }

    @Override
    public Topic getReferenceByIdIfExist(Long id) {
        if (!existsById(id)) throw new EntityNotFoundException("Topic with id " + id + " not exist!");
        return getReferenceById(id);
    }

}
