package com.sofka.bugsmanagement.mappers;

import com.sofka.bugsmanagement.collections.BugHistory;
import com.sofka.bugsmanagement.model.bug.BugHistoryDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class BugHistoryMapper {

    private final ModelMapper modelMapper;

    public Function<BugHistory, BugHistoryDto> convertEntityToDto() {
        return entity -> modelMapper.map(entity, BugHistoryDto.class);
    }

    public Function<BugHistoryDto, BugHistory> convertDtoToEntity() {
        return dto -> modelMapper.map(dto, BugHistory.class);
    }
}
