package com.illia.krasnienkov.movie.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "userr")
//@NamedNativeQueries({
//        @NamedNativeQuery(name = "Book.findAllNative",
//                query = "SELECT * FROM book b ORDER BY b.title DESC",
//                resultClass = User.class)
//})
public class User extends Audit {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sex sex;

    @Column(nullable = false)
    private LocalDate dateOfBirthday;

    @Column(unique = true, nullable = false)
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String telephone;

    @Email
    @Column(nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    @OneToMany
    private List<MovieList> movieLists = new ArrayList<>();

    public void addMovieList(MovieList movieList) {
        movieList.setUser(this);
        this.movieLists.add(movieList);
    }

    public void removeMovieList(MovieList movieList) {
        movieList.setUser(null);
        this.movieLists.remove(movieList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<MovieList> getMovieLists() {
        return movieLists;
    }

    public enum Sex {
        MALE, FEMALE
    }
}
