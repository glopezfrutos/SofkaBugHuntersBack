package com.sofka.bugsmanagement.usecases.bug;

import com.sofka.bugsmanagement.mappers.BugMapper;
import com.sofka.bugsmanagement.mappers.TaskMapper;
import com.sofka.bugsmanagement.model.bug.BugDto;
import com.sofka.bugsmanagement.model.task.TaskDTO;
import com.sofka.bugsmanagement.repositories.IBugRepository;
import com.sofka.bugsmanagement.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GetBugByTaskIdUseCase {

    private final IBugRepository repository;
    private final BugMapper mapper;

    public Flux<BugDto> apply(String taskId) {
        return repository
                .findAll()
                .filter(entity -> Objects.equals(entity.getTaskId(), taskId))
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}
