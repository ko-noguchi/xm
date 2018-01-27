package com.github.ko_noguchi.xm;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MinutesTest {
    @Mock
    private Clock clockStub;

    private Minutes sut;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(clockStub.now()).thenReturn(LocalDateTime.of(2018, 1, 23, 21, 42, 11));

        sut = new Minutes(clockStub);
    }

    @Test
    public void constructor_constructsMinutes() {
        assertThat(sut.id()).isEqualTo("20180123214211");
    }
}
