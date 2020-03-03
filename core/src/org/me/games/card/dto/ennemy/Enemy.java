package org.me.games.card.dto.ennemy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;
import org.me.games.card.dto.Person;
import org.me.games.card.dto.board.BoardPosition;
import org.me.games.card.dto.misc.AttackTypeEnum;
import org.me.games.card.dto.misc.ConditionEnum;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class Enemy extends Person {

    private String name;
    private int level;
    private int souls;
    private int armor;
    private int hp;
    private AttackTypeEnum sensibility;
    private int attack;
    private ConditionEnum attackType;
    private List<BoardPosition> attackTarget;
    private boolean isAreaAttack;
    private BoardPosition position;
    private BoardPosition effectivePosition;
}
