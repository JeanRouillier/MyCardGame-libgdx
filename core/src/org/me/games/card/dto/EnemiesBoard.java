package org.me.games.card.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import org.me.games.card.dto.board.Board;
import org.me.games.card.dto.board.BoardPosition;
import org.me.games.card.dto.ennemy.Enemy;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Log
@Data
public class EnemiesBoard extends Board {

    private List<Enemy> frontLineEnemyWaitingList = new ArrayList<>();
    private List<Enemy> backLineEnemyWaitingList = new ArrayList<>();

    public void placeEnemies(List<Enemy> enemies) {
        for (Enemy e: enemies){
            System.out.println(e.getName() + " " +e.getPosition());

            //si place pas dispo on offset jusqu'à dispo
            boolean isOccupied = isOccupied(e.getPosition());
            if(isOccupied){
                BoardPosition positiveEffective = e.getPosition().offsetSameRow();
                BoardPosition negativeEffective = e.getPosition().negativeOffsetSameRow();
                if(!isOccupied(e.getPosition().offsetSameRow())){
                    setAtPosition(positiveEffective, e);

                }else if (!isOccupied(e.getPosition().negativeOffsetSameRow())){
                    setAtPosition(negativeEffective, e);

                } else {
                    if ((e.getPosition().getX() % 1) != 0) {
                        backLineEnemyWaitingList.add(e);
                        System.out.println("Added to temp BACK");
                    } else {
                        frontLineEnemyWaitingList.add(e);
                        System.out.println("Added to temp FRONT");
                    }
                }
            } else {
                setAtPosition(e.getPosition(), e);
            }
        }
    }

    public void flush() {
        frontLineEnemyWaitingList.clear();
        backLineEnemyWaitingList.clear();
        getAllPlacedEnemies().clear();
    }

    public List<Person> getAllPlacedEnemies() {
        final ArrayList<Person> result = new ArrayList<>();
        for (int i = 0; i <= this.getBoard().length - 1; i++) {
            for (int j = 0; j <= this.getBoard()[i].length - 1; j++) {
                Person current = this.getBoard()[i][j];
                if (current != null)
                    result.add(current);
            }
        }
        return result;
    }

}
