package io.github.wesleyosantos91.v1.controller;

import io.github.wesleyosantos91.person.usecase.CreatePersonUserCase;
import io.github.wesleyosantos91.v1.request.PersonRequest;
import io.github.wesleyosantos91.v1.response.PersonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static io.github.wesleyosantos91.v1.mapper.PersonHttpMapper.INSTANCE;

@Slf4j
@RestController
@RequestMapping("/v1/persons")
public class PersonController {

    private final CreatePersonUserCase createPersonUserCase;

    public PersonController(CreatePersonUserCase createPersonUserCase) {
        this.createPersonUserCase = createPersonUserCase;
    }

    @GetMapping
    public String get() {
        return "ola mundo";
    }

    @PostMapping
    public ResponseEntity<PersonResponse> create(@Valid @RequestBody PersonRequest request) {
        log.info("Function started 'create person'");
        var person = createPersonUserCase.create(INSTANCE.toDomain(request));
        log.info("finished function with sucess 'create person'");
        return ResponseEntity.status(HttpStatus.CREATED).body(INSTANCE.toResponse(person));
    }

}
