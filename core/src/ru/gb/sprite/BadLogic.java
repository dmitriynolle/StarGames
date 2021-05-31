package ru.gb.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.Sprite;
import ru.gb.math.Rect;

public class BadLogic extends Sprite {
    private Vector2 v = new Vector2();
    private Vector2 tmp = new Vector2();
    private Vector2 touch = new Vector2();
    private static final float V_LEN = 0.01f;

    public BadLogic(Texture texture) {
        super(new TextureRegion(texture));
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.2f);
        this.pos.set(worldBounds.pos);
    }

    @Override
    public void draw(SpriteBatch batch) {
        tmp.set(touch);
        if(tmp.sub(pos).len() <= v.len()){
            pos.set(touch);
            v.setZero();
        } else {
            pos.add(v);
        }
        super.draw(batch);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch = touch;
        v = (touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }
}