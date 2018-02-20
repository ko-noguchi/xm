package com.github.ko_noguchi.xm.application;

import com.github.ko_noguchi.xm.domain.MinutesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/minutes")
public class MinutesController {
    private final MinutesService service;

    public MinutesController(MinutesService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public IdentifiableObject createMinutes() {
        String minutesId = service.createMinutes();
        return new IdentifiableObject(minutesId);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Minutes getMinutes(@PathVariable String id) {
        com.github.ko_noguchi.xm.domain.Minutes minutes = service.getMinutes(id);
        return new Minutes(minutes.id());
    }
}
