package com.sofka.bugsmanagement.usecases.task;

import com.sofka.bugsmanagement.Mappers.TaskMapper;
import com.sofka.bugsmanagement.model.task.TaskDTO;
import com.sofka.bugsmanagement.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.function.Function;

@Service
@Validated
@RequiredArgsConstructor
public class CreateTaskUseCase /*implements Function<TaskDTO, Mono<TaskDTO>>*/ {

    private final ITaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public Mono<TaskDTO> apply(@Valid TaskDTO taskDTO) {
       return taskRepository
               .save(taskMapper.convertDtoToEntity().apply(taskDTO))
               .map(task -> taskMapper.convertEntityToDto().apply(task));
   }
}
