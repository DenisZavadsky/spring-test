package com.levelup.spring.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.ResultMatcher.*;
import static org.hamcrest.Matchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

/**
 * Created by denis_zavadsky on 8/8/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service.xml", "classpath:web-context.xml"})
@WebAppConfiguration
public class TestDataComtrollerTest {

    protected MockMvc mockMvc;

    @Inject
    protected WebApplicationContext webApplicationContext;


    @Before
    public void setup() {
        //Mockito.reset(userAccountServiceMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getDataTest(){
        try {
            mockMvc.perform(get("/test/data"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                    //.andExpect(jsonPath("$",hasSize(1)))
                    .andExpect(jsonPath("$.firstName", is("Ivan")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDataByIdTest(){
        try {
            mockMvc.perform(get("/test/data/{id}",10L))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(jsonPath("$", hasSize(2)))
                    .andExpect(jsonPath("$[0].firstName", is("Ivan")))
                    .andExpect(jsonPath("$[1].firstName", is("Stepan")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
