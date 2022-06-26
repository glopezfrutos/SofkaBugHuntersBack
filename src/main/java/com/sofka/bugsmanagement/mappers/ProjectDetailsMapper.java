package com.sofka.bugsmanagement.mappers;

import com.sofka.bugsmanagement.collections.Project;
import com.sofka.bugsmanagement.model.project.ProjectDTO;
import com.sofka.bugsmanagement.model.project.ProjectDetailsDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class ProjectDetailsMapper {

    private final ModelMapper modelMapper;

    public Function<Project, ProjectDetailsDto> convertEntityToDto(){
        return project -> modelMapper.map(project, ProjectDetailsDto.class);
    }
}
