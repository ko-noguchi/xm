package com.github.ko_noguchi.xm.application;

import com.github.ko_noguchi.xm.Clock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MinutesIntegrationTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private Clock clockStub;

    @Before
    public void setup() {
        when(clockStub.now()).thenReturn(LocalDateTime.of(2018, 1, 28, 14, 41, 42));
    }

    @Test
    public void createMinutesShouldCreateMinutesAndReturnId() throws Exception {
        //language=JSON
        String expectedJson = "{\n" +
                "  \"id\": \"20180128144142\"\n" +
                "}";
        mockMvc.perform(post("/v1/minutes"))
                .andExpect(status().isCreated())
                .andExpect(content().json(expectedJson));
    }

    @Test
    public void getMinutesShouldReturnMinutes() throws Exception {
        MvcResult postMinutesResult = mockMvc.perform(post("/v1/minutes")).andReturn();
        String id = toMinutesId(postMinutesResult);


        String expectedJson = String.format("{\"id\": \"%s\"}", id);
        mockMvc.perform(get("/v1/minutes/" + id))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    private static String toMinutesId(MvcResult postMinutesResult) throws UnsupportedEncodingException {
        String contentJson = postMinutesResult.getResponse().getContentAsString();
        Map<String, Object> jsonMap = JsonParserFactory.getJsonParser().parseMap(contentJson);
        return (String) jsonMap.get("id");
    }
}
