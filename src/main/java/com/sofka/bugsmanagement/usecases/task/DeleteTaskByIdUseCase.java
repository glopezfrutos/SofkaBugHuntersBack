package com.sofka.bugsmanagement.usecases.task;

import com.sofka.bugsmanagement.repositories.ITaskRepository;
import com.sofka.bugsmanagement.usecases.bug.DeleteBugByIdUseCase;
import com.sofka.bugsmanagement.usecases.bug.GetBugByTaskIdUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class DeleteTaskByIdUseCase {
    private final ITaskRepository taskRepository;

    private final GetBugByTaskIdUseCase getBugByTaskIdUseCase;
    private final DeleteBugByIdUseCase deleteBugByIdUseCase;


    public Mono<Void> apply(String taskId) {
        log.info("\n***** Task deleted. Id: {} *****\n", taskId);
        return getBugByTaskIdUseCase
                .apply(taskId)
                .flatMap(bug -> deleteBugByIdUseCase.apply(bug.getId()))
                .then(taskRepository.deleteById(taskId));
    }
}
