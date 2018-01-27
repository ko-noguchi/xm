package com.github.ko_noguchi.xm;

import org.springframework.stereotype.Service;

@Service
class MinutesService {
    private MinutesRepository repository;

    MinutesService(MinutesRepository repository) {
        this.repository = repository;
    }

    void createMinutes() {
        repository.save(new Minutes(new Clock()));
    }
}
