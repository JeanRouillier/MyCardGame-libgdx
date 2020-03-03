package org.me.games.card.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.me.games.card.dto.encounter.Encounter;
import org.me.games.card.dto.misc.RoundState;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Round {

    private Encounter activeEncounter;
    private RoundState state = RoundState.START;

    private boolean hasActiveEncounter = false;
    private boolean isEnded = false;

    public boolean getHasActiveEncounter(){
        return activeEncounter != null;
    }
}
