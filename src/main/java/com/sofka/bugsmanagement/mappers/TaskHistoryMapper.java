package com.sofka.bugsmanagement.mappers;

import com.sofka.bugsmanagement.collections.TaskHistory;
import com.sofka.bugsmanagement.model.task.TaskHistoryDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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

}
