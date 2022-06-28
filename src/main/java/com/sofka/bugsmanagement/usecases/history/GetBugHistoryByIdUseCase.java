package com.sofka.bugsmanagement.usecases.history;


import com.sofka.bugsmanagement.mappers.TaskHistoryMapper;
import com.sofka.bugsmanagement.model.history.TaskHistoryDto;
import com.sofka.bugsmanagement.repositories.history.ITaskHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetBugHistoryByIdUseCase {

    private final ITaskHistoryRepository repository;
    private final TaskHistoryMapper mapper;

    public Mono<TaskHistoryDto> apply(String taskId) {
        log.info("\n***** Getting History Bug by Id: {} *****\n", taskId);
        return repository
                .findById(taskId)
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}
