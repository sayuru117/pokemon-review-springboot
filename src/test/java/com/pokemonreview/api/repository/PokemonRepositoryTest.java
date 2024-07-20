package com.pokemonreview.api.repository;

import com.pokemonreview.api.models.Pokemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PokemonRepositoryTest {

	@Autowired
	private PokemonRepository pokemonRepository;

	@Test
	public void PokemonRepository_SaveAll_ReturnSavedPokemon() {

		//Arrange
		Pokemon pokemon = Pokemon.builder().name("Pikachu").type("Electric").build();


		//Act
		Pokemon savedPokemon = pokemonRepository.save(pokemon);


		//Assert
		assertThat(savedPokemon.getId()).isNotNull();
		assertThat(savedPokemon.getId()).isGreaterThan(0);

	}
}
