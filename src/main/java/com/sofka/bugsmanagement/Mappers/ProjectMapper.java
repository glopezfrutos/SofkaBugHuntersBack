package com.sofka.bugsmanagement.Mappers;

import com.sofka.bugsmanagement.collections.Project;
import com.sofka.bugsmanagement.model.project.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class ProjectMapper {

    private final ModelMapper modelMapper;

    public Function<Project, ProjectDTO> convertEntityToDto(){
        return project -> modelMapper.map(project, ProjectDTO.class);
    }

    public Function<ProjectDTO, Project> convertDtoToEntity(){
        return projectDTO -> modelMapper.map(projectDTO, Project.class);
    }
}
