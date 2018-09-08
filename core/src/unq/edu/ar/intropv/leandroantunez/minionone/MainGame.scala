package unq.edu.ar.intropv.leandroantunez.minionone

import com.badlogic.gdx.{ApplicationAdapter, Gdx}
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class MainGame extends ApplicationAdapter {
  private var batch: SpriteBatch = _

  override def create(): Unit = {
    batch = new SpriteBatch
  }

  override def render(): Unit = {
    Gdx.gl.glClearColor(1, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    batch.begin()
    batch.end()
  }

  override def dispose(): Unit = {
    batch.dispose()
  }
}