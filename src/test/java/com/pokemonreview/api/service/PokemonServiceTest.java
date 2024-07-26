package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.dto.PokemonResponse;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.repository.PokemonRepository;
import com.pokemonreview.api.service.impl.PokemonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {

	@Mock
	private PokemonRepository pokemonRepository;

	@Mock
	PokemonServiceImpl pokemonService1;



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
		assertThat(savePolemon).isNotNull();

	}
	 @Test
	public void PokemonService_GetAllPokemon_ReturnPokemonResponseDTO() {
		 PokemonResponse pokemonReturn = Mockito.mock(PokemonResponse.class);

		 Page<Pokemon> pokemons = Mockito.mock(Page.class);

		 when(pokemonRepository.findAll(Mockito.any(Pageable.class)))	.thenReturn(pokemons);


		 //Act
		 PokemonResponse pokemonResponse = pokemonService.getAllPokemon(0, 10);
		 assertThat(pokemonResponse).isEqualTo(pokemonReturn);
		 assertThat(pokemonResponse).isNotNull();

	 }

	@Test
	public void whenNotUseMockAnnotation_thenCorrect() {
		List mockList = Mockito.mock(ArrayList.class);

		mockList.add("one");
		Mockito.verify(mockList).add("one");
		assertEquals(0, mockList.size());

		Mockito.when(mockList.size()).thenReturn(100);
		assertEquals(100, mockList.size());
	}

	@Test
	public void myMockMethod(){
		spiedList.add("one");
		verify(spiedList).add("one");
		assertEquals(0, spiedList.size());

		Mockito.when(spiedList.size()).thenReturn(100);
		assertEquals(100, spiedList.size());


	}
	@Spy
	List<String> spiedList = new ArrayList<>();

	@Test
	public void whenUseSpyAnnotation_thenSpyIsInjectedCorrectly() {
		spiedList.add("one");
		spiedList.add("two");

		Mockito.verify(spiedList).add("one");
		Mockito.verify(spiedList).add("two");

		assertEquals(2, spiedList.size());

		Mockito.doReturn(100).when(spiedList).size();
		assertEquals(100, spiedList.size());
	}



}
