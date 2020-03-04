package org.me.games.card.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.me.games.card.dto.board.Board;

@EqualsAndHashCode(callSuper = true) @Data public class AlliesBoard extends Board {

    public AlliesBoard() {
        super();
    }

}
