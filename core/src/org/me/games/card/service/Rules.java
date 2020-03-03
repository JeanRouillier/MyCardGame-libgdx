package org.me.games.card.service;

import org.me.games.card.dto.AlliesBoard;
import org.me.games.card.dto.board.BoardPosition;
import org.me.games.card.dto.encounter.Encounter;
import org.me.games.card.dto.player.Player;

import java.util.List;
import java.util.Random;

public class Rules {

    public static Encounter selectEncounter(EncounterService list, int level){
        Encounter result = new Encounter();
        Random rand = new Random();
        switch (level){
            case 1:
                List<Encounter> one = list.getOne();
                result = one.get(rand.nextInt(one.size()));
                break;
            case 2:
                List<Encounter> two = list.getTwo();
                result = two.get(rand.nextInt(two.size()));
                break;
            case 3:
                List<Encounter> three = list.getThree();
                result = three.get(rand.nextInt(three.size()));
                break;
        }
        return result;
    }

    public static void placePlayers(AlliesBoard alliesBoard, Player player, BoardPosition wishedPosition){
        boolean b = alliesBoard.setAtPosition(wishedPosition, player);
        if(b){
            System.out.println("Player placed: "+player.getName());
        }
        alliesBoard.print();
    }
}
