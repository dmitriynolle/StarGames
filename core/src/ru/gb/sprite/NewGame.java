package ru.gb.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import ru.gb.base.ScaledButton;
import ru.gb.math.Rect;
import ru.gb.screen.GameScreen;

public class NewGame extends ScaledButton {

    private static final float HEIGHT = 0.07f;
    private GameScreen gameScreen;

    public NewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setTop(worldBounds.pos.y - 0.1f);
    }

    @Override
    protected void action() {
        gameScreen.mainShip.setHp(10);
        gameScreen.mainShip.alilve();
        gameScreen.mainShip.setLeft(0-gameScreen.mainShip.getHalfWidth());
        gameScreen.state = GameScreen.State.PLAYING;
        gameScreen.bulletPool.destroyActiveSprites();
        gameScreen.enemyPool.destroyActiveSprites();
    }
}
