package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.SpringIntegrationTest;
import com.illia.krasnienkov.movie.dto.CommonDto;
import com.illia.krasnienkov.movie.exceptions.ResourceNotFoundException;
import com.illia.krasnienkov.movie.model.Audit;
import com.illia.krasnienkov.movie.service.ModelsService;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CommonServiceImplTest<D extends CommonDto, M extends Audit> extends SpringIntegrationTest {

    ModelsService<D, M> service;
    M model;
    D dto;
    M updatedModel;
    Map<String, Object> patchFields;

    public CommonServiceImplTest(ModelsService<D, M> service) {
        this.service = service;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public void setDto(D dto) {
        this.dto = dto;
    }

    public void setUpdatedModel(M updatedModel) {
        this.updatedModel = updatedModel;
    }

    public void setPatchFields(Map<String, Object> patchFields) {
        this.patchFields = patchFields;
    }

    @Test
    @Order(1)
    void createReturnsNotNullElement() {
        D createdDto = service.create(model);
        dto = createdDto;
        assertNotNull(createdDto);
    }

    @Test
    @Order(2)
    void readAll() {
        List<D> models = service.readAll();
        models.forEach(System.out::println);
        assertFalse(models.isEmpty());
    }

    @Test
    @Order(3)
    void readById() {
        D dtoFromDatabase = service.readById(model.getId());
        assertNotNull(dtoFromDatabase);
    }

    @Test
    @Order(4)
    void update() {
        D updatedDto = service.update(updatedModel);
        assertNotEquals(dto, updatedDto);
        assertEquals(dto.getId(), updatedDto.getId());
        assertNotNull(updatedDto.getDateUpdated());
    }

    @Test
    @Order(5)
    void patch() {
        D patchedDto = service.patch(patchFields, model.getId());
        assertEquals(dto.getId(), patchedDto.getId());
        assertNotNull(patchedDto);
        assertNotNull(patchedDto.getDateUpdated());
    }

    @Test
    @Order(6)
    void deleteById() {
        service.deleteById(model.getId());
        assertThrows(ResourceNotFoundException.class,
                () -> service.findById(model.getId()));
    }
}
