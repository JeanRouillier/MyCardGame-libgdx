package org.me.games.card.input;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import org.me.games.card.CardGame;

import static org.me.games.card.dto.misc.RoundState.START;

public class ResetRoundButtonClickListener extends ClickListener {

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        CardGame.currentRound.setState(START);
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        return true;
    }
}
