package org.me.games.card.dto.player;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class Players {

    private static Player WIZARD = new Player("wizard", null, null,
            "wizard.png");
    private static Player ASSASSIN = new Player("assassin", null, null,
            "assassin.png");
    private static Player KNIGHT = new Player("knight", null, null,
            "knight.png");
    private static Player HERALD = new Player("herald", null, null,
            "herald.png");

    public static List<Player> playersList = new ArrayList<>(Arrays.asList(WIZARD, ASSASSIN, KNIGHT, HERALD));

    public static Player getWIZARD(){
        return WIZARD;
    }

    public static Player getASSASSIN(){
        return ASSASSIN;
    }

    public static Player getKNIGHT(){
        return KNIGHT;
    }

    public static Player getHERALD(){
        return HERALD;
    }
}
