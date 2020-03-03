package org.me.games.card.dto.encounter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Encounter {

    private String name;
    private Map<Integer, EncounterRow> detail;
    private boolean isActive;
    private String textureName;
}
