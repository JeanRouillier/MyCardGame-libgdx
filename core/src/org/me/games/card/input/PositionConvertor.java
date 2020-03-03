package org.me.games.card.input;

import org.me.games.card.dto.board.BoardPosition;

import java.util.Optional;

import static org.me.games.card.render.BoardRenderer.HEIGHT;
import static org.me.games.card.render.BoardRenderer.WIDTH;
import static org.me.games.card.render.BoardRenderer.halfWidth;

public class PositionConvertor {

    public static Optional<BoardPosition> convertInputToBoardPosition(int inputX, int inputY){
        final BoardPosition result = new BoardPosition();
        Integer x = null;
        if(inputX >= (halfWidth + halfWidth/3) && inputX<= (halfWidth + 2*halfWidth/3)){
            x = 0;
        }else if(inputX > (halfWidth + 2*halfWidth/3) && inputX<= WIDTH){
            x = 1;
        }

        Integer y = null;
        if(inputY >= 0 && inputY<= HEIGHT/3){
            y = 2;
        }else if(inputY > HEIGHT/3  && inputY<= 2*HEIGHT/3){
            y = 1;
        }else if(inputY > 2*HEIGHT/3 && inputY<= HEIGHT){
            y = 0;
        }

        if(x == null || y == null){
           return Optional.empty();
        }
        result.setX(x);
        result.setY(y);
        return Optional.of(result);
    }
}
