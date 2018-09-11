package unq.edu.ar.intropv.leandroantunez.minionone.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{GL20, Texture}
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

  // Create a new Box2D world for managing things.
  private val world = new World(new Vector2(0, -10), true)

  private val playerTexture: Texture = game.assetManager.get("player.png")

  private val player: Player = new Player(world, playerTexture, new Vector2(1.5f, 1.5f))

  private val position: Vector3 = new Vector3(stage.getCamera.position)

  override def show(): Unit = {
    // Add the player to the stage too.
    stage.addActor(player)

    // Reset the camera to the left. This is required because we have translated the camera
    // during the game. We need to put the camera on the initial position so that you can
    // use it again if you replay the game.
    stage.getCamera.position.set(position)
    stage.getCamera.update()
  }

  override def render(delta: Float): Unit = { // Do not forget to clean the screen.
    Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    world.step(delta, 6, 2)
    // Render the screen. Remember, this is the last step!
    stage.draw()
  }


  override def dispose(): Unit = {
    stage.dispose()
    world.dispose()
  }


}