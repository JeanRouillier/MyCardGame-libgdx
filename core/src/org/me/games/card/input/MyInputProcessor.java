package org.me.games.card.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import org.me.games.card.CardGame;
import org.me.games.card.dto.board.BoardPosition;
import org.me.games.card.dto.player.Player;
import org.me.games.card.dto.player.Players;
import org.me.games.card.service.Rules;

import java.util.Optional;
import java.util.Random;

import static org.me.games.card.dto.misc.RoundState.ALLIES_PLACED;
import static org.me.games.card.dto.misc.RoundState.ENEMIES_PLACED;

public class MyInputProcessor implements InputProcessor {

    @Override public boolean keyDown(int keycode) {
        return false;
    }

    @Override public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //Ally to place
        if (button == Input.Buttons.LEFT && ENEMIES_PLACED.equals(CardGame.currentRound.getState())) {
            Optional<BoardPosition> boardPosition = PositionConvertor.convertInputToBoardPosition(screenX, screenY);

            if (boardPosition.isPresent() && !CardGame.alliesBoard.getAtPosition(boardPosition.get()).isPresent()) {

                final Player player = Players.activePlayers
                        .get(new Random().nextInt(Players.activePlayers.size()));
                Rules.placePlayers(CardGame.alliesBoard, player, boardPosition.get());
                CardGame.currentRound.setState(ALLIES_PLACED);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
