package org.me.games.card.input;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.me.games.card.CardGame;
import org.me.games.card.dto.encounter.Encounter;
import org.me.games.card.service.Rules;

import static org.me.games.card.dto.misc.RoundState.ENCOUNTER_PICKED;
import static org.me.games.card.dto.misc.RoundState.START;

@RequiredArgsConstructor
@AllArgsConstructor
public class EncounterButtonClickListener extends ClickListener {

    private CardGame gameCard;

    @Override public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        if (START.equals(CardGame.currentRound.getState())) {
            //PICK ENCOUNTER
            Encounter encounter = Rules.selectEncounter(gameCard.getEncounterList(), 1);
            CardGame.currentRound.setActiveEncounter(encounter);
            System.out.println("Encounter name: " + encounter.getName());
            System.out.println("Encounter detail: " + encounter.getDetail());
            CardGame.currentRound.setState(ENCOUNTER_PICKED);
        }
    }
    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        return true;
    }
}
