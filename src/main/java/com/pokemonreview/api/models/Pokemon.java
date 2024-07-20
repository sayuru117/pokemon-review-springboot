package com.pokemonreview.api.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;

    public Pokemon(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

}
