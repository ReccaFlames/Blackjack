# Blackjack

Java application that simulates game of 21. You can use random inputs or provide your own in a form of `txt` file.

## What do you need to run this app
- Java 17
- Gradle 7.4.2

## Game rules
- The game is played with a single deck of playing cards.
- There are only two players (in this case called Sam and the Dealer) who will play against each other. Initially
each player is given 2 cards from the top of a deck of cards. Cards are given in the following order: `sam, dealer, sam, dealer`
- The score of a player's hands is the sum of the individual cards.
- The score of numbered cards are their point value. Jack, Queen and King count as 10 and Ace
counts as 11.
- If either player has Blackjack with their initial hand they win the game. (Blackjack is an initial score of 21 with two cards: `A + \[10, J, Q, K\])`
- Sam wins when both players start with Blackjack
- Dealer wins when both players start going bust with a value above 21: `(A + A)`
- If neither player has Blackjack then Sam will start drawing cards from the top of the deck Sam
  - will draw a card until the score of their hand is 17 or higher
  - Sam will not draw more than their first two cards, if their initial hand is 17 or higher Sam 
  - has lost the game if their total reaches 22 or higher
- When sam has stopped drawing cards the dealer will start drawing cards from the top of the deck The 
  - dealer will stop drawing cards when their total is higher than Sam's.
  - The dealer has lost the game their total reaches 22 or higher

## How to run:

### With Deck generator
```shell
gradle run
```

### With own card deck
```shell
gradle run <<path_to_file>>
```

example:
```shell
gradle run deck-of-cards.txt
```
