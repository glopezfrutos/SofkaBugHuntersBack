package com.sofka.bugsmanagement.mappers;

import com.sofka.bugsmanagement.collections.Dashboard;
import com.sofka.bugsmanagement.model.dashboard.DashboardDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class DashboardMapper {

    private final ModelMapper modelMapper;

    public Function<Dashboard, DashboardDto> convertEntityToDto() {return entity -> modelMapper.map(entity,DashboardDto.class);}

    public Function<DashboardDto, Dashboard> convertDtoToEntity() {return dto -> modelMapper.map(dto,Dashboard.class);}


}
