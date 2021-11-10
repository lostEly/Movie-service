package com.illia.krasnienkov.movie.dto.model_dtos;

public class GenreDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreDto genreDto = (GenreDto) o;

        return name != null ? name.equals(genreDto.name) : genreDto.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
