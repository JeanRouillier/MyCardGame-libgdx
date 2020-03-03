package org.me.games.card.dto.misc;

import lombok.AllArgsConstructor;

@AllArgsConstructor public enum RoundState {

    START(0), ENCOUNTER_PICKED(1), ALLIES_PLACED(2), ENEMIES_ATTACKED(3), ALLIES_ATTACKED(4);

    private Integer value;
}
