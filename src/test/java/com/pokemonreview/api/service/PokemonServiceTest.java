package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.repository.PokemonRepository;
import com.pokemonreview.api.service.impl.PokemonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {

	@Mock
	private PokemonRepository pokemonRepository;

	@InjectMocks
	private PokemonServiceImpl pokemonService;

	@Test
	public void PokemonService_CreatePokemon_ReturnPokemonDto() {
		Pokemon pokemon = Pokemon.builder().name("pikachu").type("electric").build();

		PokemonDto pokemonDto = PokemonDto.builder().name("pikachu").type("electric").build();

		when(pokemonRepository.save(any(Pokemon.class))).thenReturn(pokemon);

		//Act
		PokemonDto savePolemon = pokemonService.createPokemon( pokemonDto);
		assertThat(savePolemon).isEqualTo(pokemonDto);

	}


}
