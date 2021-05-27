package ru.gb.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.gb.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 pos;
    private Vector2 posNew;
    private Vector2 v;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        posNew = new Vector2();
        v = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if(posNew.cpy().sub(pos).len() < 5){
            v.x = 0;
            v.y = 0;
        }
        if (pos != posNew) pos.add(v);
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
        posNew.set(screenX, Gdx.graphics.getHeight() - screenY);
        v = (posNew.cpy().sub(pos)).nor().scl(3f);
        System.out.println(v);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
