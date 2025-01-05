package com.example.cacSpringBoot.services.integrationTest;

import com.example.cacSpringBoot.dto.response.HelloDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
            //.writer().withDefaultPrettyPrinter();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSayHelloOutputOk() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/sayHello/{name}", "Cat"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.saludo").value("hola Cat"))
                .andReturn();

        assertEquals("application/json",mvcResult.getResponse().getContentType());
        assertEquals(200,mvcResult.getResponse().getStatus());
        assertEquals("{\"saludo\":\"hola Cat\"}",mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testSayHelloOutputOk2() throws Exception {
        this.mockMvc.perform(get("/sayHello")
                        .param("name", "Cat"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.saludo").value("hola Cat"));
    }

    @Test
    public void testPostOk() throws Exception{
        HelloDto payload = new HelloDto("hola Cat");

        String payloadJson = writer.writeValueAsString(payload);

        this.mockMvc.perform(post("/crearSaludo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testPostRespuestaCompletaOk() throws Exception {
        HelloDto payload = new HelloDto("hola Cat");
        HelloDto responseDto = new HelloDto("hola Cat agregado");

        String payloadJson = writer.writeValueAsString(payload);
        String responseJson = writer.writeValueAsString(responseDto);

        MvcResult response = this.mockMvc.perform(post("/crearSaludo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andReturn();

//        assertEquals("{\"saludo\":\"hola Cat agregado\"}", response.getResponse().getContentAsString());
        assertEquals(responseJson, response.getResponse().getContentAsString());
        assertEquals(200, response.getResponse().getStatus());
        assertEquals("application/json", response.getResponse().getContentType());

        /*
        * @WebMvcTest dshabilita e
        * l autoconfigure y nos permite configurar algunas cosas
        * @MockBean
        * @InjectMocks
        * @ExtendWith
        * @ContextConfiguration
        * @WebAppConfiguration
        * */
    }
}
