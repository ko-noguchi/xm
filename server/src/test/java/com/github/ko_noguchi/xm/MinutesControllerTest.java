package com.github.ko_noguchi.xm;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class MinutesControllerTest {
    @Mock
    private MinutesService service;

    private MinutesController sut;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        sut = new MinutesController(service);
    }

    @Test
    public void createMinutes_callsCreateMinutes() {
        sut.createMinutes();

        verify(service).createMinutes();
    }
}
