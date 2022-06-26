package com.sofka.bugsmanagement.usecases.task;

import com.sofka.bugsmanagement.Mappers.TaskMapper;
import com.sofka.bugsmanagement.model.task.TaskDTO;
import com.sofka.bugsmanagement.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GetTaskUseCase implements Supplier<Flux<TaskDTO>> {

    private final ITaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public Flux<TaskDTO> get() {
        return taskRepository
                .findAll()
                .map(task -> taskMapper
                        .convertEntityToDto()
                        .apply(task));
    }

}
