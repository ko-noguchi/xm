package com.github.ko_noguchi.xm.application;

import com.github.ko_noguchi.xm.domain.MinutesService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MinutesControllerTest {
    private static String STUB_MINUTES_ID = "20180128133245";

    @Mock private MinutesService service;

    private MinutesController sut;

    @Before
    public void setup() {
        initMocks(this);

        when(service.createMinutes()).thenReturn(STUB_MINUTES_ID);

        com.github.ko_noguchi.xm.domain.Minutes stubMinutes = new com.github.ko_noguchi.xm.domain.Minutes(STUB_MINUTES_ID);
        when(service.getMinutes(STUB_MINUTES_ID)).thenReturn(stubMinutes);

        sut = new MinutesController(service);
    }

    @Test
    public void createMinutes_callsServiceCreateMinutes() {
        IdentifiableObject minutesId = sut.createMinutes();


        IdentifiableObject expectedId = new IdentifiableObject(STUB_MINUTES_ID);
        assertThat(minutesId).isEqualTo(expectedId);
    }

    @Test
    public void getMinutes_callsServiceGetMinutes() {
        Minutes minutes = sut.getMinutes(STUB_MINUTES_ID);


        assertThat(minutes).isEqualTo(new Minutes(STUB_MINUTES_ID));
    }
}
