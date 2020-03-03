package org.me.games.card.dto.encounter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EncounterRow {

    private int treasureNumber;
    private int levelOneNumber;
    private int levelTwoNumber;
    private int levelThreeNumber;
}
