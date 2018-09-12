package unq.edu.ar.intropv.leandroantunez.minionone.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera, Texture}
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.math.{Vector2, Vector3}
import com.badlogic.gdx.physics.box2d.World
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.FitViewport
import unq.edu.ar.intropv.leandroantunez.minionone.MainGame
import unq.edu.ar.intropv.leandroantunez.minionone.actors.Player

/**
  * Esta es la pantalla del nivel del juego.
  */
class GameScreen(game: MainGame) extends BaseScreen(game) {

  private val stage: Stage = new Stage(new FitViewport(640, 360))

  private val world = new World(new Vector2(0, -10), true)

  private val playerTexture: Texture = game.assetManager.get("player.png")

  private val player: Player = new Player(world, playerTexture, new Vector2(1.5f, 1.5f))

  private val position: Vector3 = new Vector3(stage.getCamera.position)

  private var map: TiledMap = game.assetManager.get("map/minion-one-tiled.tmx")

  private var renderer: OrthogonalTiledMapRenderer = new OrthogonalTiledMapRenderer(map)

  private var camera: OrthographicCamera = new OrthographicCamera()

  override def show(): Unit = {
    stage.addActor(player)
    stage.getCamera.position.set(position)
    stage.getCamera.update()
  }

  override def render(delta: Float): Unit = {
    Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    renderer.setView(camera)
    renderer.render()
    world.step(delta, 6, 2)
    stage.draw()
  }

  override def resize(width: Int, height: Int): Unit = {
    camera.viewportHeight = height
    camera.viewportWidth = width
    camera.update()
  }

  override def dispose(): Unit = {
    stage.dispose()
    world.dispose()
  }


}