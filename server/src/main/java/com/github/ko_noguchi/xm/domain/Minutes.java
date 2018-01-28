package com.github.ko_noguchi.xm.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode
@ToString
public class Minutes {
    @Id
    private String id;

    @SuppressWarnings("unused")
    private Minutes() {}

    public Minutes(String id) {
        this.id = id;
    }
}
