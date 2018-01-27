package com.github.ko_noguchi.xm;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class MinutesServiceTest {
    @Mock
    private MinutesRepository repositorySpy;

    private MinutesService sut;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        sut = new MinutesService(repositorySpy);
    }

    @Test
    public void createMinutes_createsAndSavesMinutes() {
        sut.createMinutes();

        verify(repositorySpy).save((Minutes) any());
    }
}
