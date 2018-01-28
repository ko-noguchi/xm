package com.github.ko_noguchi.xm.application;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
class IdentifiableObject {
    private final String id;

    IdentifiableObject(String id) {
        this.id = id;
    }
}
