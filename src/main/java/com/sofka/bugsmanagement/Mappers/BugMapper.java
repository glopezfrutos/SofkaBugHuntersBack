package com.sofka.bugsmanagement.Mappers;

import com.sofka.bugsmanagement.collections.Bug;
import com.sofka.bugsmanagement.collections.User;
import com.sofka.bugsmanagement.model.bug.BugDto;
import com.sofka.bugsmanagement.model.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class BugMapper {

    private final ModelMapper modelMapper;

    public Function<Bug, BugDto> convertEntityToDto(){
        return entity -> modelMapper.map(entity, BugDto.class);
    }

    public Function<BugDto, Bug> convertDtoToEntity(){
        return dto -> modelMapper.map(dto, Bug.class);
    }
}
