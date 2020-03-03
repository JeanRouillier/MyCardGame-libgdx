package org.me.games.card.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.me.games.card.dto.board.BoardPosition;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"name"})
public class Person {

    public String name;
    public BoardPosition position;
    public String textureName;

}
