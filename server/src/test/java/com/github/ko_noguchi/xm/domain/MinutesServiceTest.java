package com.github.ko_noguchi.xm.domain;

import com.github.ko_noguchi.xm.Clock;
import com.github.ko_noguchi.xm.infrastructure.MinutesRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MinutesServiceTest {
    private static final LocalDateTime STUB_LOCAL_DATE_TIME =
            LocalDateTime.of(2018, 1, 23, 21, 42, 11);
    private static final String STUB_MINUTES_ID = "20180123214211";

    @Mock private MinutesRepository repositoryStubSpy;
    @Mock private Clock clockStub;

    private MinutesService sut;

    @Before
    public void setup() {
        initMocks(this);

        when(clockStub.now()).thenReturn(STUB_LOCAL_DATE_TIME);
        when(repositoryStubSpy.findOne(STUB_MINUTES_ID)).thenReturn(new Minutes(STUB_MINUTES_ID));

        sut = new MinutesService(repositoryStubSpy, clockStub);
    }

    @Test
    public void createMinutes_callsRepositorySave() {
        String minutesId = sut.createMinutes();


        verify(repositoryStubSpy).save(new Minutes(minutesId));
        assertThat(minutesId).isEqualTo(STUB_MINUTES_ID);
    }

    @Test
    public void getMinutes_callsRepositoryFindOne() {
        Minutes minutes = sut.getMinutes(STUB_MINUTES_ID);


        assertThat(minutes).isEqualTo(new Minutes(STUB_MINUTES_ID));
    }
}
