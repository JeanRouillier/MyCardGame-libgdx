package org.me.games.card.dto.behaviour;

import org.me.games.card.dto.Person;
import org.me.games.card.dto.misc.ConditionEnum;

public interface Attacker {

    void attack(Person e, ConditionEnum conditionEnum);
}
