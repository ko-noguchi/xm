package com.github.ko_noguchi.xm.infrastructure;

import com.github.ko_noguchi.xm.domain.Minutes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinutesRepository extends CrudRepository<Minutes, String> {
}
