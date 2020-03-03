package org.me.games.card.service;

import org.me.games.card.dto.AlliesBoard;
import org.me.games.card.dto.encounter.EncounterRow;
import org.me.games.card.dto.ennemy.Enemies;
import org.me.games.card.dto.ennemy.Enemy;
import org.me.games.card.dto.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class EnemyService {

    static{
        one = Enemies.initLevelOneEnemyList();
        two = Enemies.initLevelTwoEnemyList();
        three = Enemies.initLevelThreeEnemyList();
    }
    private static List<Enemy> one ;
    private static List<Enemy> two;
    private static List<Enemy> three;

    public static List<Enemy> pickEnemies(EncounterRow encounterRow){
        ArrayList<Enemy> result = new ArrayList<>();
        result.addAll(pickSpecificEnemy(1, encounterRow.getLevelOneNumber()));
        result.addAll(pickSpecificEnemy(2, encounterRow.getLevelTwoNumber()));
        result.addAll(pickSpecificEnemy(3, encounterRow.getLevelThreeNumber()));
        return result;

    }

    public static List<Enemy> pickSpecificEnemy(int level, int qty){
        Random rand = new Random();
        ArrayList<Enemy> enemyOneCopy = new ArrayList<>(one);
        ArrayList<Enemy> enemyTwoCopy = new ArrayList<>(two);
        ArrayList<Enemy> enemyThreeCopy = new ArrayList<>(three);

        ArrayList<Enemy> result = new ArrayList<>();
        for(int i = 0; i<= qty-1; i++){
            switch (level){
                case 1:
                    result.add(enemyOneCopy.remove(rand.nextInt(enemyOneCopy.size())));
                    break;
                case 2:
                    result.add(enemyTwoCopy.remove(rand.nextInt(enemyTwoCopy.size())));
                    break;
                case 3:
                    result.add(enemyThreeCopy.remove(rand.nextInt(enemyThreeCopy.size())));
                    break;
            }
        }
        return result;
    }

    public static void enemyAttack(List<Enemy> enemyList, AlliesBoard alliesBoard){
        alliesBoard.print();
        for (Enemy e : enemyList) {
            out.println("ATTACKER : " + e.getName() + " attacks => "+e.getAttackTarget());
            if(!e.isAreaAttack()){
                alliesBoard.getAtPosition(e.getAttackTarget().get(0))
                        .ifPresent(p -> {
                            Player attackedPlayer = ((Player)p);
                            out.println("DEFENDER "+attackedPlayer.getName());
                            attackedPlayer.defend(e.getAttack());

                        });
                }else{

            }
        }

    }
}
