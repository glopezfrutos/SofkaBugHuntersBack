package com.sofka.bugsmanagement.mappers;

import com.sofka.bugsmanagement.collections.BugHistory;
import com.sofka.bugsmanagement.collections.ProjectHistory;
import com.sofka.bugsmanagement.model.bug.BugHistoryDto;
import com.sofka.bugsmanagement.model.project.ProjectHistoryDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class ProjectHistoryMapper {
    private final ModelMapper modelMapper;

    public Function<ProjectHistory, ProjectHistoryDto> convertEntityToDto() {
        return entity -> modelMapper.map(entity, ProjectHistoryDto.class);
    }

    public Function<ProjectHistoryDto, ProjectHistory> convertDtoToEntity() {
        return dto -> modelMapper.map(dto, ProjectHistory.class);
    }
}
