package ru.gb.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private static final float V_LEN = 1.5f;
    private Texture img;
    private Vector2 pos;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 tmp;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        touch = new Vector2();
        v = new Vector2();
        tmp = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        tmp.set(touch);
        if(tmp.sub(pos).len() <= v.len()){
            pos.set(touch);
            v.setZero();
        } else {
            pos.add(v);
        }
        batch.begin();
        batch.draw(img, pos.x, pos.y, 100f, 100f);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v = (touch.cpy().sub(pos)).setLength(V_LEN);
        System.out.println(v);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
