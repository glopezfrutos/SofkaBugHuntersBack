package com.sofka.bugsmanagement.mappers;

import com.sofka.bugsmanagement.collections.history.ProjectHistory;
import com.sofka.bugsmanagement.collections.history.TaskHistory;
import com.sofka.bugsmanagement.model.history.TaskHistoryDto;
import com.sofka.bugsmanagement.model.project.ProjectDto;
import com.sofka.bugsmanagement.model.task.TaskDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class TaskHistoryMapper {

    private final ModelMapper modelMapper;

    public Function<TaskHistory, TaskHistoryDto> convertEntityToDto() {
        return entity -> modelMapper.map(entity, TaskHistoryDto.class);
    }

    public Function<TaskHistoryDto, TaskHistory> convertDtoToEntity() {
        return dto -> modelMapper.map(dto, TaskHistory.class);
    }

    public Function<TaskDto, TaskHistory> convertTaskDtoToTaskHistory() {
        return taskDto -> new TaskHistory(taskDto.getId(),
                LocalDate.now().toString(),
                taskDto.getProjectId(),
                taskDto.getProjectName(),
                taskDto.getName(),
                taskDto.getCreatedAt(), taskDto.getClosedAt(), taskDto.getTag(),
                taskDto.getDescription(),
                taskDto.getAdditionalFilesId(),
                taskDto.getResponsibleEmail(),
                taskDto.getStatus().toString());
    }

}
