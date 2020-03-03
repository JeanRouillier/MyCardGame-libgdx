package org.me.games.card.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import org.me.games.card.CardGame;
import org.me.games.card.dto.board.BoardPosition;
import org.me.games.card.dto.player.Players;
import org.me.games.card.service.Rules;

import java.util.Optional;

import static org.me.games.card.dto.misc.RoundState.ALLIES_PLACED;
import static org.me.games.card.dto.misc.RoundState.ENCOUNTER_PICKED;

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
        if (button == Input.Buttons.LEFT && ENCOUNTER_PICKED.equals(CardGame.currentRound.getState())) {
            Optional<BoardPosition> boardPosition = PositionConvertor.convertInputToBoardPosition(screenX, screenY);
            if (boardPosition.isPresent()) {
                Rules.placePlayers(CardGame.alliesBoard, Players.getWIZARD(), boardPosition.get());
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
