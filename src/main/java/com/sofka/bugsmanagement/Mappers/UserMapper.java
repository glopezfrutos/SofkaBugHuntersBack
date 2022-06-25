package com.sofka.bugsmanagement.Mappers;

import com.sofka.bugsmanagement.collections.User;
import com.sofka.bugsmanagement.model.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;

    public Function<User, UserDto> convertEntityToDto(){
        return entity -> modelMapper.map(entity, UserDto.class);
    }

    public Function<UserDto, User> convertDtoToEntity(){
        return dto -> modelMapper.map(dto, User.class);
    }
}
