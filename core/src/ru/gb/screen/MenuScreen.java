package ru.gb.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.gb.base.BaseScreen;
import ru.gb.math.Rect;
import ru.gb.sprite.Background;
import ru.gb.sprite.BadLogic;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Background background;

    private Texture bl;
    private BadLogic badlogic;

    @Override
    public void show() {
        super.show();
        bg = new Texture("fon.jpg");
        background = new Background(bg);
        bl = new Texture("badlogic.jpg");
        badlogic = new BadLogic(bl);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        badlogic.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        badlogic.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        super.touchDown(touch, pointer, button);
        badlogic.touchDown(touch, pointer, button);
        return false;
    }
}
