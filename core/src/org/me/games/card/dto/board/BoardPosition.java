package org.me.games.card.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import static java.lang.Math.abs;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Wither
public class BoardPosition {

    private int x;
    private int y;

    public BoardPosition offsetSameRow(){
        y = abs((y + 1) % 2);
        return new BoardPosition(x, y);
    }

    public BoardPosition negativeOffsetSameRow(){
        y = abs((y - 1) % 2);
        return new BoardPosition(x, y);
    }
}
