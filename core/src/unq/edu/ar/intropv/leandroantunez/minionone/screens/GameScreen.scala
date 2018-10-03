package unq.edu.ar.intropv.leandroantunez.minionone.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera, Texture}
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.maps.tiled.{TiledMap, TiledMapRenderer}
import com.badlogic.gdx.math.{Vector2, Vector3}
import com.badlogic.gdx.physics.box2d.World
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.FitViewport
import unq.edu.ar.intropv.leandroantunez.minionone.MainGame
import unq.edu.ar.intropv.leandroantunez.minionone.actors.Player

class GameScreen(game: MainGame) extends BaseScreen(game) {

  private val w: Float = Gdx.graphics.getWidth
  private val h: Float = Gdx.graphics.getHeight
  private val camera: OrthographicCamera = new OrthographicCamera(w, h)
  camera.setToOrtho(false, w, h)

  private val fitViewport: FitViewport = new FitViewport(640, 360, camera)

  private val stage = new Stage(fitViewport)

  private val world: World = new World(new Vector2(0, -10), true)

  private val playerPosition: Vector2 = new Vector2(7f, 2.2f)

  private val playerTexture: Texture = game.assetManager.get("player.png")

  private val player: Player = new Player(world, playerTexture, playerPosition)

  private val tiledMap: TiledMap = game.assetManager.get("map/minion-one-tiled.tmx")

  private val tiledMapRenderer: TiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap)

  override def show(): Unit = {
    stage.addActor(player)
    stage.getCamera.translate(55f, 20f, 0)
  }

  override def render(delta: Float): Unit = {
    Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    tiledMapRenderer.setView(camera)
    tiledMapRenderer.render()

    stage.act()
    stage.getCamera.update()

    world.step(delta, 6, 2)

    stage.draw()
  }

  override def hide(): Unit = {
    stage.clear()
    player.detach()
  }

  override def dispose(): Unit = {
    stage.dispose()

    world.dispose()
  }

}