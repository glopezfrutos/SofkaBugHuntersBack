package com.sofka.bugsmanagement.mappers;


import com.sofka.bugsmanagement.collections.Task;
import com.sofka.bugsmanagement.model.task.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final ModelMapper modelMapper;

    public Function<Task, TaskDTO> convertEntityToDto() {
        return task -> modelMapper.map(task, TaskDTO.class);
    }

    public Function<TaskDTO, Task> convertDtoToEntity() {
        return taskDTO -> modelMapper.map(taskDTO, Task.class);
  }
}
