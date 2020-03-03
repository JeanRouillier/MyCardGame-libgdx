package org.me.games.card.dto.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.me.games.card.dto.Person;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player extends Person {

    public List<Object> hand = new ArrayList<>(5);
    public List<Object> deck = new ArrayList<>();

    public Player(String name, List<Object> hand, List<Object> deck , String t){
        super(name, null, t);
        this.hand = hand;
        this.deck = deck;
    }

    public void defend(int hitValue){
        System.out.println("Position attacked " + position);
        System.out.println("ATTACKED ! hit point " + hitValue);
    }
}
