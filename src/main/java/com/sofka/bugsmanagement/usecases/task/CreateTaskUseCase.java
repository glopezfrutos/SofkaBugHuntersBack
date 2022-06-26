package com.sofka.bugsmanagement.usecases.task;

import com.sofka.bugsmanagement.mappers.TaskMapper;
import com.sofka.bugsmanagement.model.task.TaskDTO;
import com.sofka.bugsmanagement.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CreateTaskUseCase implements Function<TaskDTO, Mono<TaskDTO>> {

    private final ITaskRepository taskRepository;
    private final TaskMapper taskMapper;

   @Override
    public Mono<TaskDTO> apply(TaskDTO taskDTO) {
       return taskRepository
               .save(taskMapper.convertDtoToEntity().apply(taskDTO))
               .map(task -> taskMapper.convertEntityToDto().apply(task));
   }
}
