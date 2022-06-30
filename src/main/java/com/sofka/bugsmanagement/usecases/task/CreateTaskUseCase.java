package com.sofka.bugsmanagement.usecases.task;

import com.sofka.bugsmanagement.collections.history.TaskHistory;
import com.sofka.bugsmanagement.mappers.TaskHistoryMapper;
import com.sofka.bugsmanagement.mappers.TaskMapper;
import com.sofka.bugsmanagement.model.task.TaskDto;
import com.sofka.bugsmanagement.repositories.ITaskRepository;
import com.sofka.bugsmanagement.repositories.history.ITaskHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class CreateTaskUseCase  {

    private final ITaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final ITaskHistoryRepository taskHistoryRepository;
    private final TaskHistoryMapper taskHistoryMapper;

    public Mono<TaskDto> apply(@Valid TaskDto taskDTO) {
        log.info("\n***** New Task created. Id: {} *****\n", taskDTO.getId());
        return taskHistoryRepository
                .save(taskHistoryMapper
                        .convertTaskDtoToTaskHistory()
                        .apply(taskDTO))
                .then(
                taskRepository
               .save(taskMapper
                       .convertDtoToEntity()
                       .apply(taskDTO))
               .map(task -> taskMapper.convertEntityToDto().apply(task)));
   }
}
