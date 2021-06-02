package ru.gb.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import ru.gb.base.Sprite;
import ru.gb.math.Rect;

public class MyShip extends Sprite {
    private static final float HEIGHT = 0.15f;
    private static final float PADDING = 0.015f;
    private static final float V_LEN = 0.01f;
    private Vector2 touch;
    private Rect worldBounds;

    public MyShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
        touch = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        regions[0] = new TextureRegion(regions[0],0,0,195,287);
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + PADDING);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (touch.x < pos.x) pos.x = pos.x - V_LEN;
        if (touch.x > pos.x) pos.x = pos.x + V_LEN;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch = touch;
        return false;
    }

    public void keyDown(int keycode) {
        if (keycode == 21)  touch.x = worldBounds.getLeft();
        if (keycode == 22)  touch.x = worldBounds.getRight();
        System.out.println(pos.x);
    }

    public void keyUp(int keycode) {
        touch.x = pos.x;
    }
}
