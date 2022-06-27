package com.sofka.bugsmanagement.mappers;

import com.sofka.bugsmanagement.collections.Project;
import com.sofka.bugsmanagement.model.project.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class ProjectMapper {

    private final ModelMapper modelMapper;

    public Function<Project, ProjectDto> convertEntityToDto(){
        return project -> modelMapper.map(project, ProjectDto.class);
    }

    public Function<ProjectDto, Project> convertDtoToEntity(){
        return projectDTO -> modelMapper.map(projectDTO, Project.class);
    }
}
