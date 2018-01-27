package com.github.ko_noguchi.xm;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.format.DateTimeFormatter;

@Entity
public class Minutes {
    private static final DateTimeFormatter ID_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    @Id
    private String id;

    @SuppressWarnings("unused")
    private Minutes() {}

    Minutes(Clock clock) {
        id = ID_FORMATTER.format(clock.now());
    }

    public String id() {
        return id;
    }
}
