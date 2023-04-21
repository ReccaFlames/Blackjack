package org.example.blackjack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.example.deck.Deck;
import org.example.deck.DeckProvider;
import org.example.player.Player;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class BlackjackGameTest {

    private final DeckProvider deckProvider = mock(DeckProvider.class);
    private final BlackjackGame game = new BlackjackGame(deckProvider);

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, List.of("CA", "D5", "H9", "HQ", "S8"), "sam", getPlayer("sam", List.of("CA", "H9")),
                        getPlayer("dealer", List.of("D5", "HQ", "S8"))},
                {null, List.of("CA", "D5", "HJ", "HQ", "S8"), "sam", getPlayer("sam", List.of("CA", "HJ")),
                        getPlayer("dealer", List.of("D5", "HQ"))},
                {null, List.of("CA", "D5", "H5", "HQ", "S5"), "sam", getPlayer("sam", List.of("CA", "H5", "S5")),
                        getPlayer("dealer", List.of("D5", "HQ"))},
                {null, List.of("CA", "D5", "HA", "HQ", "S6"), "dealer", getPlayer("sam", List.of("CA", "HA")),
                        getPlayer("dealer", List.of("D5", "HQ", "S6"))},
                {null, List.of("CA", "DA", "H5", "HQ", "S6"), "dealer", getPlayer("sam", List.of("CA", "H5")),
                        getPlayer("dealer", List.of("DA", "HQ"))},
                {null, List.of("CA", "DA", "HA", "SA", "S6"), "dealer", getPlayer("sam", List.of("CA", "HA")),
                        getPlayer("dealer", List.of("DA", "SA"))},
        });
    }

    private static Player getPlayer(String name, List<String> hand) {
        var player = new Player(name);
        hand.forEach(player::addCard);
        return player;
    }

    @ParameterizedTest
    @MethodSource("data")
    void shouldReturnCorrectResult(
            String filename,
            List<String> deckValues,
            String winner,
            Player expectedPlayer,
            Player expectedDealer
    ) {
        //given
        given(deckProvider.provide(filename)).willReturn(new Deck(deckValues));

        //when
        var result = game.play(filename);

        //then
        assertThat(result).isEqualToComparingFieldByFieldRecursively(
                new Result(winner, expectedPlayer, expectedDealer));
    }
}
