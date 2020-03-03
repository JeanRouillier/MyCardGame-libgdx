package org.me.games.card;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.me.games.card.asset.AssetLoader;
import org.me.games.card.dto.AlliesBoard;
import org.me.games.card.dto.EnemiesBoard;
import org.me.games.card.dto.encounter.EncounterRow;
import org.me.games.card.dto.ennemy.Enemy;
import org.me.games.card.input.MyInputProcessor;
import org.me.games.card.render.BoardRenderer;
import org.me.games.card.service.EncounterService;
import org.me.games.card.service.EnemyService;
import org.me.games.card.service.Round;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.me.games.card.dto.misc.RoundState.ALLIES_ATTACKED;
import static org.me.games.card.dto.misc.RoundState.ALLIES_PLACED;
import static org.me.games.card.dto.misc.RoundState.ENCOUNTER_PICKED;
import static org.me.games.card.dto.misc.RoundState.ENEMIES_ATTACKED;
import static org.me.games.card.dto.misc.RoundState.ENEMIES_PLACED;

@Data
@EqualsAndHashCode(callSuper = true)
public class CardGame extends ApplicationAdapter {

	public static final String GAME_IDENTIFIER = "org.me.games.card";

	public static AlliesBoard alliesBoard = new AlliesBoard();
	public static EnemiesBoard enemiesBoard = new EnemiesBoard();

	private EncounterService encounterList = new EncounterService();
	public static Round currentRound = new Round();

	public Stage stage;

	public AssetLoader assetLoader;
	public BoardRenderer boardRenderer;

	@Override public void create() {
		assetLoader = new AssetLoader();
		MyInputProcessor inputProcessor = new MyInputProcessor();
		stage = new Stage(new ScreenViewport());
		InputMultiplexer multiplexer = new InputMultiplexer(stage, inputProcessor);
		Gdx.input.setInputProcessor(multiplexer);

		boardRenderer = new BoardRenderer(this, new SpriteBatch(), new ShapeRenderer());
		boardRenderer.renderEncounterButton(stage);
	}

	@Override public void resize(int width, int height) {

	}

	@Override public void render() {

		if (ENCOUNTER_PICKED.equals(currentRound.getState())) {
			//PLACE ENEMIES
			Map<Integer, EncounterRow> detail = currentRound.getActiveEncounter().getDetail();
			List<Enemy> enemies = EnemyService.pickEnemies(detail.get(1));
			enemiesBoard.placeEnemies(enemies);
			currentRound.setState(ENEMIES_PLACED);
		}
		if(ENEMIES_PLACED.equals(currentRound.getState())){
			//Place allies

		}

		if (ALLIES_PLACED.equals(currentRound.getState())) {
			//ENEMY ATTACK
			//All enemies
			final ArrayList<Enemy> enemies = new ArrayList<>(enemiesBoard.getBackLineEnemyWaitingList());
			enemies.addAll(enemiesBoard.getFrontLineEnemyWaitingList());
			EnemyService.enemyAttack(enemies, alliesBoard);
			currentRound.setState(ENEMIES_ATTACKED);
		}
		if(ENEMIES_ATTACKED.equals(currentRound.getState())){
			currentRound.setState(ALLIES_ATTACKED);
		}
		if(ALLIES_ATTACKED.equals(currentRound.getState())){

		}

		boardRenderer.render(assetLoader, enemiesBoard, currentRound.getActiveEncounter());
		stage.act();
		stage.draw();
	}

	@Override
	public void dispose () {
		boardRenderer.dispose();
	}
}
