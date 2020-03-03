package org.me.games.card.dto.ennemy;

import org.me.games.card.dto.board.BoardPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.me.games.card.dto.misc.AttackTypeEnum.HEAVY;
import static org.me.games.card.dto.misc.AttackTypeEnum.MAGICAL;
import static org.me.games.card.dto.misc.ConditionEnum.FROST;

public class Enemies {


    public static List<Enemy> initLevelOneEnemyList(){
        Enemy irithyllianBeastHound = new Enemy()
                .withName("irithyllianBeastHound")
                .withLevel(1)
                .withSouls(1)
                .withArmor(1)
                .withHp(1)
                .withSensibility(MAGICAL)
                .withAttack(2)
                .withAttackType(FROST)
                .withAttackTarget(Stream.of(
                        new BoardPosition(1,0 ))
                        .collect(Collectors.toList()))
                .withPosition(new BoardPosition(0, 2));

        irithyllianBeastHound.setTextureName("enemies_00018");

        Enemy hollowManservant = new Enemy()
                .withName("hollowManservant")
                .withLevel(1)
                .withSouls(2)
                .withArmor(0)
                .withHp(2)
                .withAttack(4)
                .withAttackTarget(Stream.of(
                        new BoardPosition(0,2 ))
                        .collect(Collectors.toList()))
                .withPosition(new BoardPosition(0, 0));
        hollowManservant.setTextureName("enemies_00011");


        Enemy hollowSoldier = new Enemy()
                .withName("hollowSoldier")
                .withLevel(1)
                .withSouls(3)
                .withArmor(2)
                .withHp(1)
                .withSensibility(HEAVY)
                .withAttack(2)
                .withAttackTarget(Stream.of(
                        new BoardPosition(0,1 ))
                        .collect(Collectors.toList()))
                .withPosition(new BoardPosition(0, 1));
        hollowSoldier.setTextureName("enemies_00007");


        return Stream.of(
                irithyllianBeastHound,
                hollowManservant,
                hollowSoldier
        ).collect(Collectors.toList());
    }

    public static List<Enemy> initLevelTwoEnemyList(){
        return new ArrayList<>();
    }

    public static List<Enemy> initLevelThreeEnemyList(){
        Enemy blackKnightUltraGreatSwordsman = new Enemy()
                .withLevel(3)
                .withSouls(11)
                .withArmor(3)
                .withHp(2)
                .withSensibility(MAGICAL)
                .withAttack(4)
                .withAttackTarget(Stream.of(
                        new BoardPosition(0,0),
                        new BoardPosition(0,1),
                        new BoardPosition(0,2))
                        .collect(Collectors.toList()))
                .withAreaAttack(true)
                .withPosition(new BoardPosition(0, 0));

        return Stream.of(blackKnightUltraGreatSwordsman).collect(Collectors.toList());
    }

}
