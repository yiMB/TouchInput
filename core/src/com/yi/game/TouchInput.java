package com.yi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*
touch input this version not using InputProcessor nor GestureListener, see my another note for them

Gdx.input.justTouched()
Gdx.input.isTouched()
 */
public class TouchInput extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Sprite(img);
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2,
				Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
	}

	@Override
	public void render () {

		/*
		like listen to single touch
		 */
		if(Gdx.input.justTouched()){
			sprite.setPosition(Gdx.input.getX() - sprite.getWidth()/2,Gdx.graphics.getHeight() - Gdx.input.getY() - sprite.getHeight()/2);
		}
		/*
		like listen to drag
		 */
		if(Gdx.input.isTouched()){
			sprite.rotate(1f);
			sprite.setPosition(Gdx.input.getX() - sprite.getWidth() / 2, Gdx.graphics.getHeight() - Gdx.input.getY() - sprite.getHeight()/2);

		}

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
