package com.example.airlineTicketing.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TestEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String test;
}
