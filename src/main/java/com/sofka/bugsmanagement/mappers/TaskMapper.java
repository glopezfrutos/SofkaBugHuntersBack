package com.sofka.bugsmanagement.mappers;


import com.sofka.bugsmanagement.collections.Task;
import com.sofka.bugsmanagement.model.task.TaskDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final ModelMapper modelMapper;

    public Function<Task, TaskDto> convertEntityToDto() {
        return task -> modelMapper.map(task, TaskDto.class);
    }

    public Function<TaskDto, Task> convertDtoToEntity() {
        return taskDTO -> modelMapper.map(taskDTO, Task.class);
  }
}
