package com.github.ko_noguchi.xm.domain;

import com.github.ko_noguchi.xm.Clock;
import com.github.ko_noguchi.xm.infrastructure.MinutesRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class MinutesService {
    private static final DateTimeFormatter ID_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private MinutesRepository repository;
    private Clock clock;

    MinutesService(MinutesRepository repository, Clock clock) {
        this.repository = repository;
        this.clock = clock;
    }

     public String createMinutes() {
         String id = ID_FORMATTER.format(clock.now());
         repository.save(new Minutes(id));
         return id;
     }

    public Minutes getMinutes(String id) {
        return repository.findOne(id);
    }
}
