package org.me.games.card.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import lombok.Data;
import org.me.games.card.dto.player.Players;

import java.util.ArrayList;
import java.util.List;

@Data
public class AssetLoader {

    public TextureAtlas enemiesAtlas;
    public TextureAtlas boardAtlas;
    public List<Texture> alliesTextures = new ArrayList<>();

    public AssetLoader(){

        enemiesAtlas = new TextureAtlas(Gdx.files.internal("enemies/enemies.atlas"));
        boardAtlas = new TextureAtlas(Gdx.files.internal("board/class_encounters.atlas"));

        alliesTextures.add(new Texture(Gdx.files.internal("allies/"+Players.getASSASSIN().getTextureName())));
        alliesTextures.add(new Texture(Gdx.files.internal("allies/"+Players.getWIZARD().getTextureName())));
        alliesTextures.add(new Texture(Gdx.files.internal("allies/"+Players.getHERALD().getTextureName())));
        alliesTextures.add(new Texture(Gdx.files.internal("allies/"+Players.getKNIGHT().getTextureName())));
    }
}
