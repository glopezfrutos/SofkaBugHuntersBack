package com.sofka.bugsmanagement.mappers;

import com.sofka.bugsmanagement.collections.history.BugHistory;
import com.sofka.bugsmanagement.collections.history.TaskHistory;
import com.sofka.bugsmanagement.model.bug.BugDto;
import com.sofka.bugsmanagement.model.history.BugHistoryDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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

    public Function<BugDto,BugHistory> convertBugDtoToBugHistory() {
        return bugDto -> new BugHistory(bugDto.getId(),
                LocalDate.now().toString(),
                bugDto.getProjectId(),
                bugDto.getTaskId(),
                bugDto.getTitle(),
                bugDto.getDescription(),
                bugDto.getCreatedAt(),
                bugDto.getResponsible(),
                bugDto.getContextInfo(),
                bugDto.getLifecycle().toString(),
                bugDto.getAdditionalFile(),
                bugDto.getSeverity().toString(),
                bugDto.getPriority().toString(),
                bugDto.getStatus().toString(),
                bugDto.getConclusion(),
                bugDto.getGlobalIssues(),
                bugDto.getReferences(),
                bugDto.getClosedAt(),
                bugDto.getClosedAt(),
                bugDto.getSolutionResponsible(),
                bugDto.getDeveloperObservations());
    }
}
