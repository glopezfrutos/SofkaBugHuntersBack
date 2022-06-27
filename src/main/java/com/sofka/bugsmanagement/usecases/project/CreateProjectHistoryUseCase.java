package com.sofka.bugsmanagement.usecases.project;


import com.sofka.bugsmanagement.mappers.ProjectHistoryMapper;
import com.sofka.bugsmanagement.model.project.ProjectHistoryDto;
import com.sofka.bugsmanagement.repositories.IProjectHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateProjectHistoryUseCase {

    private final IProjectHistoryRepository repository;
    private final ProjectHistoryMapper mapper;

    public Mono<ProjectHistoryDto> apply(ProjectHistoryDto projectHistoryDto) {
        log.info("\n**** New Project History created Id: {} *****\n", projectHistoryDto.getProjectHistoryId());
        return repository
                .save(mapper.convertDtoToEntity().apply(projectHistoryDto))
                .map(dto -> mapper
                        .convertEntityToDto()
                        .apply(dto));
    }
}
