package com.sofka.bugsmanagement.routes.project;

import com.sofka.bugsmanagement.collections.Project;
import com.sofka.bugsmanagement.repositories.IProjectPageableRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GetAllProjectsPagedRoute {
    private final IProjectPageableRepository repository;

    @GetMapping("/api/v1/project-paged")
    public Flux<Project> getProjectPaged(final @RequestParam(name = "page") int page,
                                      final @RequestParam(name = "size") int size) {
        log.info("\n***** Getting all projects paged ***** \n*** Projects per page: {} ***\n*** Page number: {} ***", page, size);
        return repository.retrieveAllProjectsPaged(PageRequest.of(page, size));
    }
}
