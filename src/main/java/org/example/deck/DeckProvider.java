package org.example.deck;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DeckProvider {

    public Deck provide(String filename) {
        if (filename == null || filename.isEmpty()) {
            return new Deck(true);
        }
        List<String> values = getValuesFromFile(filename);
        return new Deck(values);
    }

    private List<String> getValuesFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            List<String> values = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                values.addAll(Stream.of(line.split(",")).map(String::trim).toList());
            }
            if (values.size() < 4) {
                throw new IllegalArgumentException("Provided deck should contain at minimum 4 cards");
            }
            return values;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
