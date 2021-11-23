package com.illia.krasnienkov.movie.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.illia.krasnienkov.movie.SpringIntegrationTest;
import com.illia.krasnienkov.movie.TestDataFactory;
import com.illia.krasnienkov.movie.dto.model_dtos.MovieDto;
import com.illia.krasnienkov.movie.model.Movie;
import com.illia.krasnienkov.movie.repository.MovieRepository;
import com.illia.krasnienkov.movie.test_data.MovieTestData;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MovieControllerTest extends SpringIntegrationTest {

    private static final String LOCALHOST = "http://localhost:8080/movies/";
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    void create() throws Exception {
        Movie movie = TestDataFactory.createMovie();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(LOCALHOST)
                        .content(objectMapper.writeValueAsString(movie))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
        String jsonResponse = result.getResponse().getContentAsString();
        MovieDto movieDto = objectMapper.readValue(jsonResponse, MovieDto.class);
        assertNotNull(movieDto);
        assertEquals(MovieTestData.ID, movieDto.getId().toString());
    }

    @Test
    @Order(2)
    void readAll() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(LOCALHOST)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String jsonResponse = result.getResponse().getContentAsString();
        List<MovieDto> movieDtoList = objectMapper.readValue(jsonResponse,
                objectMapper.getTypeFactory().constructCollectionType(List.class, MovieDto.class));
        assertFalse(movieDtoList.isEmpty());
        MovieDto addedMovieDto = TestDataFactory.createMovieDto();
        assertTrue(movieDtoList.contains(addedMovieDto));
    }

    @Test
    @Order(3)
    void readById() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(LOCALHOST + MovieTestData.ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String jsonResponse = result.getResponse().getContentAsString();
        MovieDto movieDto = objectMapper.readValue(jsonResponse, MovieDto.class);
        assertNotNull(movieDto);
        assertEquals(MovieTestData.ID, movieDto.getId().toString());
    }

    @Test
    @Order(4)
    void update() throws Exception {
        Movie updatedMovie = TestDataFactory.createUpdatedMovie();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put(LOCALHOST)
                        .content(objectMapper.writeValueAsString(updatedMovie))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String jsonResponse = result.getResponse().getContentAsString();
        MovieDto movieDto = objectMapper.readValue(jsonResponse, MovieDto.class);
        assertNotNull(movieDto);
        assertEquals(updatedMovie.getId(), movieDto.getId().toString());
        assertNotNull(movieDto.getDateUpdated());
        assertEquals(updatedMovie.getName(), movieDto.getName());
    }

    @Test
    @Order(5)
    void patch() throws Exception {
        Map<String, Object> patchFields = TestDataFactory.createMoviePatchFields();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.patch(LOCALHOST + MovieTestData.ID)
                        .content(objectMapper.writeValueAsString(patchFields))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String jsonResponse = result.getResponse().getContentAsString();
        MovieDto movieDto = objectMapper.readValue(jsonResponse, MovieDto.class);
        assertNotNull(movieDto);
        assertEquals(patchFields.get("name"), movieDto.getName());
        assertEquals(patchFields.get("description"), movieDto.getDescription());
    }

    @Test
    @Order(8)
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(LOCALHOST + MovieTestData.ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();
        Optional<Movie> movie = movieRepository.findById(MovieTestData.ID);
        assertTrue(movie.isEmpty());
    }
}