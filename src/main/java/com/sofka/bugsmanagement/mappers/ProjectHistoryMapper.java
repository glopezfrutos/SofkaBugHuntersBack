package com.sofka.bugsmanagement.mappers;

import com.sofka.bugsmanagement.collections.history.ProjectHistory;
import com.sofka.bugsmanagement.collections.history.TaskHistory;
import com.sofka.bugsmanagement.model.history.ProjectHistoryDto;
import com.sofka.bugsmanagement.model.project.ProjectDto;
import com.sofka.bugsmanagement.model.task.TaskDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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


    public Function<ProjectDto, ProjectHistory> convertProjectDtoToProjectHistory() {
        return projectDto -> new ProjectHistory(projectDto.getId(),
                LocalDate.now().toString(),
                projectDto.getName(),
                projectDto.getCreatedAt(),
                projectDto.getClosedAt(),
                projectDto.getTeamEmails(),
                projectDto.getOwners(),
                projectDto.getDescription(),
                projectDto.getStatus().toString());
    }


}

