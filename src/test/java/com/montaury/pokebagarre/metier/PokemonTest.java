package com.montaury.pokebagarre.metier;

import com.montaury.pokebagarre.fixtures.ConstructeurDePokemon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PokemonTest {
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    @Test
    void est_vainqueur_contre_pokemon_avec_moins_attaque() {
        //GIVEN
        pokemon1 = new ConstructeurDePokemon().avecAttaque(100).avecDefense(100).construire();
        pokemon2 = new ConstructeurDePokemon().avecAttaque(10).avecDefense(100).construire();

        // WHEN
        var estVainqueur = pokemon1.estVainqueurContre(pokemon2);

        // THEN
        assertThat(estVainqueur).isEqualTo(true);
    }

    @Test
    void est_vainqueur_contre_pokemon_avec_meme_attaque_mais_moins_defense() {
        // GIVEN
        pokemon1 = new ConstructeurDePokemon().avecAttaque(10).avecDefense(10).construire();
        pokemon2 = new ConstructeurDePokemon().avecAttaque(10).avecDefense(25).construire();

        // WHEN
        var estVainqueur = pokemon1.estVainqueurContre(pokemon2);

        // THEN
        assertThat(estVainqueur).isEqualTo(false);
    }

    @Test
    void est_vainqueur_contre_pokemon_avec_meme_stat() {
        // GIVEN
        pokemon1 = new ConstructeurDePokemon().avecAttaque(10).avecDefense(10).construire();
        pokemon2 = new ConstructeurDePokemon().avecAttaque(10).avecDefense(10).construire();

        // WHEN
        var estVainqueur = pokemon1.estVainqueurContre(pokemon2);

        // THEN
        assertThat(estVainqueur).isEqualTo(true);
    }
}
