package org.me.games.card.dto.behaviour;

import org.me.games.card.dto.misc.AttackTypeEnum;

public interface EnemyDefend {

    void defend(int hitPoint, AttackTypeEnum type);
}
