package com.softserveinc.illia.krasnienkov.movie.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class Audit {
    @Id
    private UUID id;

    private LocalDateTime dateAdded;
}
