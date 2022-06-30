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
public class CreateTaskHistoryUseCase {

    private final ITaskHistoryRepository repository;
    private final TaskHistoryMapper mapper;

    public Mono<TaskHistoryDto> apply(TaskHistoryDto taskHistoryDto) {
        log.info("\n**** New Task History created Id: {} *****\n", taskHistoryDto.getTaskHistoryId());
        return repository
                .save(mapper.convertDtoToEntity().apply(taskHistoryDto))
                .map(dto-> mapper.convertEntityToDto().apply(dto));
    }
}
