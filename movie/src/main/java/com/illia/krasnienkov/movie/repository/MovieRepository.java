package com.illia.krasnienkov.movie.repository;

import com.illia.krasnienkov.movie.dto.movie_info.EmployeeInformationDto;
import com.illia.krasnienkov.movie.dto.movie_info.MovieInformationDto;
import com.illia.krasnienkov.movie.dto.movie_info.MovieInformationRow;
import com.illia.krasnienkov.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, String> {
    @Query(nativeQuery = true)
    Movie namedGetRandomMovie();

    @Query(nativeQuery = true)
    Movie namedSortMoviesByRating();

    @Query(nativeQuery = true)
//    @NamedNativeQuery( name = "Info", query = "SELECT * from movie;", resultSetMapping = "MovieInfo")
    List<MovieInformationRow> namedGetAllMovieInfo(@Param("id") String id);
}
