package org.example.deck;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DeckProviderTest {

    private final DeckProvider deckProvider = new DeckProvider();

    @Test
    void shouldReturnRandomData() {
        //given
        //when
        var result = deckProvider.provide(null);

        //then
        assertThat(result.getCards()).isNotNull();
        final List<String> cards = new ArrayList<>(result.getCards());
        assertThat(cards).asList().hasSize(52);
    }

    @Test
    void shouldReturnDataFromFile() {
        //given
        final String filename = "deck-of-cards.txt";

        //when
        var result = deckProvider.provide(filename);

        //then
        assertThat(result).isNotNull();
        assertThat(result.getCards()).asList().containsExactly("CA", "D4", "H7", "SJ", "S5", "S9", "D10");
    }

    @Test
    void shouldReturnDataFromFilePredictably() {
        //given
        final String filename = "deck-of-cards.txt";

        //when
        var result = deckProvider.provide(filename);
        var result2 = deckProvider.provide(filename);

        //then
        assertThat(result).isNotNull();
        assertThat(result.getCards()).asList().containsExactly(result2.getCards().toArray());
    }

    @Test
    void shouldThrowExceptionWhenInsufficientInput() {
        //given
        final String filename = "3-card-deck.txt";
        
        //when
        assertThatThrownBy(() -> deckProvider.provide(filename))
            //then
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Provided deck should contain at minimum 4 cards");
    }
}