package org.me.games.card.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.me.games.card.CardGame;
import org.me.games.card.asset.AssetLoader;
import org.me.games.card.dto.Person;
import org.me.games.card.dto.encounter.Encounter;
import org.me.games.card.dto.misc.RoundState;
import org.me.games.card.input.EncounterButtonClickListener;
import org.me.games.card.input.ResetRoundButtonClickListener;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BoardRenderer {

    public final static int WIDTH = Gdx.graphics.getWidth();
    public final static int HEIGHT = Gdx.graphics.getHeight();

    public final static int halfWidth = Gdx.graphics.getWidth() / 2;
    public final static int thirdWidth = Gdx.graphics.getWidth() / 3;
    public final static int thirdHeight = Gdx.graphics.getHeight() / 3;

    private CardGame cg;
    private SpriteBatch spriteBatch;
    private ShapeRenderer shapeRenderer;

    public void render(AssetLoader assetLoader, Encounter currentEncounter) {
        spriteBatch.begin();
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.begin();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        final int halfWidth = Gdx.graphics.getWidth() / 2;
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.line(halfWidth, 0, halfWidth, Gdx.graphics.getHeight());

        renderAllyBoardGrid(shapeRenderer);
        renderEnemyBoardGrid(shapeRenderer);

        renderCurrentEncounter(spriteBatch, assetLoader, currentEncounter);

        CardGame.alliesBoard.getAllPlaced().forEach(p -> renderPerson(spriteBatch, assetLoader, p, true));
        CardGame.enemiesBoard.getAllPlacedEnemies().forEach(e -> renderPerson(spriteBatch, assetLoader, e, false));
        renderCurrentRoundState();
        spriteBatch.end();
        shapeRenderer.end();
    }

    public void renderEnemyBoardGrid(ShapeRenderer shapeRenderer) {
        //Vertical
        shapeRenderer.line(halfWidth / 3, 0, halfWidth / 3, Gdx.graphics.getHeight());

        shapeRenderer.line(2 * halfWidth / 3, 0, 2 * halfWidth / 3, Gdx.graphics.getHeight());

        //Horizontal
        shapeRenderer.line(0, thirdHeight, 2*halfWidth/3, thirdHeight);
        shapeRenderer.line(0, 2* thirdHeight, 2*halfWidth/3, 2*thirdHeight);

    }

    public void renderAllyBoardGrid(ShapeRenderer shapeRenderer) {
        //Vertical
        shapeRenderer.line(halfWidth + halfWidth / 3, 0, halfWidth + halfWidth / 3, Gdx.graphics.getHeight());

        shapeRenderer.line(halfWidth + 2 * halfWidth / 3, 0, halfWidth + 2 * halfWidth / 3, Gdx.graphics.getHeight());

        //Horizontal
        shapeRenderer.line(halfWidth + thirdWidth/2, thirdHeight, Gdx.graphics.getWidth(), thirdHeight);
        shapeRenderer.line(halfWidth + thirdWidth/2, 2* thirdHeight, Gdx.graphics.getWidth(), 2*thirdHeight);

    }

    public void renderPerson(SpriteBatch sb, AssetLoader a, Person p, boolean isAlly) {
        if (isAlly) {
            renderAlly(sb, a, p);
        } else {
            renderEnemy(sb, a, p);
        }
    }

    private void renderAlly(SpriteBatch spriteBatch, AssetLoader a, Person p) {
        if (p.getPosition() == null) {
            return;
        }
        final int x = p.getPosition().getX();
        final int y = p.getPosition().getY();
        final int halfWidth = Gdx.graphics.getWidth() / 2;
        final int thirdHeight = Gdx.graphics.getHeight() / 3;

        int x0 = 0;
        int y0 = 0;
        //Front lane
        if(x == 0  && y == 0){
            x0 = halfWidth + halfWidth/3;
            y0 = 0;
        }
        if(x == 0  && y == 1){
            x0 = halfWidth + halfWidth/3;
            y0 = thirdHeight;
        }
        if(x == 0  && y == 2){
            x0 = halfWidth + halfWidth/3;
            y0 = 2* thirdHeight;
        }
        //Back lane
        if(x == 1  && y == 0){
            x0 = halfWidth + 2*halfWidth/3;
            y0 = 0;
        }
        if(x == 1  && y == 1){
            x0 = halfWidth + 2*halfWidth/3;
            y0 = thirdHeight;
        }
        if(x == 1  && y == 2){
            x0 = halfWidth + 2*halfWidth/3;
            y0 = 2* thirdHeight;
        }

        Texture texture = new Texture(Gdx.files.internal("allies/"+ p.getTextureName()), true);
        texture.setFilter(Texture.TextureFilter.MipMapLinearLinear, Texture.TextureFilter.Linear);
        spriteBatch.draw(texture, x0, y0, 100, 150);
    }

    private void renderEnemy(SpriteBatch spriteBatch, AssetLoader a, Person p) {
        if (p.getPosition() == null && p.getTextureName() == null) {
            return;
        }
        final int x = p.getPosition().getX();
        final int y = p.getPosition().getY();

        final int halfWidth = Gdx.graphics.getWidth() / 2;
        final int thirdHeight = Gdx.graphics.getHeight() / 3;

        int x0 = 0;
        int y0 =0;
        //Front lane
        if(x == 0  && y == 0){
            x0 = halfWidth/3;
            y0 = 0;
        }
        if(x == 0  && y == 1){
            x0 = halfWidth/3;
            y0 = thirdHeight;
        }
        if(x == 0  && y == 2){
            x0 = halfWidth/3;
            y0 = 0;
        }
        //Back lane
        if(x == 1  && y == 0){
            x0 = 2*halfWidth/3;
            y0 = 2* thirdHeight;
        }
        if(x == 1  && y == 1){
            x0 = 2*halfWidth/3;
            y0 = thirdHeight;
        }
        if(x == 1  && y == 2){
            x0 = 2*halfWidth/3;
            y0 = 0;
        }

        TextureAtlas.AtlasRegion region = a.getEnemiesAtlas().findRegion(p.getTextureName());
        spriteBatch.draw(region, x0, y0, 100, 150);
    }

    public void renderEncounterButton(Stage stage) {

        TextureRegionDrawable encounterFrontDrawable = new TextureRegionDrawable(
                new TextureRegion(new Texture(Gdx.files.internal("board/encounter_level_1_back.png"))));

        TextureRegionDrawable encounterBackDrawable = new TextureRegionDrawable(
                new TextureRegion(new Texture(Gdx.files.internal("board/encounter_level_1_back.png"))));

        ImageButton button1 = new ImageButton(encounterFrontDrawable, encounterBackDrawable);
        button1.addListener(new EncounterButtonClickListener(this.getCg()));
        button1.setPosition(2 * halfWidth / 3 + 1, 0);
        button1.setSize(button1.getWidth() / 10, button1.getHeight() / 10);
        stage.addActor(button1);
    }

    public void renderResetRoundButton(Stage stage) {

        TextureRegionDrawable resetFrontDrawable = new TextureRegionDrawable(
                new TextureRegion(new Texture(Gdx.files.internal("board/bonfire_back.png"))));

        TextureRegionDrawable resetBackDrawable = new TextureRegionDrawable(
                new TextureRegion(new Texture(Gdx.files.internal("board/bonfire_back.png"))));

        ImageButton button1 = new ImageButton(resetFrontDrawable, resetBackDrawable);
        button1.addListener(new ResetRoundButtonClickListener());
        button1.setPosition(2 * halfWidth / 3 + 1, HEIGHT / 2);
        button1.setSize(button1.getWidth() / 10, button1.getHeight() / 10);
        stage.addActor(button1);
    }

    public void renderCurrentEncounter(SpriteBatch spriteBatch, AssetLoader a, Encounter currentEncounter) {
        if (currentEncounter == null || currentEncounter.getTextureName() == null) {
            return;
        }
        TextureAtlas.AtlasRegion region = a.getBoardAtlas().findRegion(currentEncounter.getTextureName());
        spriteBatch.draw(region, halfWidth, 0, 100, 150);
    }

    public void renderCurrentRoundState() {
        BitmapFont font = new BitmapFont();
        final RoundState state = CardGame.currentRound.getState();
        String toPrint = "";
        switch(state){
            case START:
                toPrint = "Pick encounter";
                break;
            case ENCOUNTER_PICKED:
                toPrint = "Placing enemies";
                break;
            case ENEMIES_PLACED:
                toPrint = "Place your team";
                break;
            case ALLIES_PLACED:
                toPrint = "Enemies attack";
                break;
            case ENEMIES_ATTACKED:
                toPrint = "You attack";
                break;
            case ALLIES_ATTACKED:
                toPrint = "End of turn";
                break;
            default:
                toPrint = "Bite";
                break;
        }
        font.draw(spriteBatch, toPrint, halfWidth, HEIGHT -10);
    }

    public void dispose(){
        spriteBatch.dispose();
        shapeRenderer.dispose();
    }
}
