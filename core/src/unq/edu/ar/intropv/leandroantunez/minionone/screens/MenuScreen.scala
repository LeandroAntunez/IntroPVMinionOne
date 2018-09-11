package unq.edu.ar.intropv.leandroantunez.minionone.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{GL20, Texture}
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.{Image, Skin, TextButton}
import com.badlogic.gdx.utils.viewport.FitViewport
import unq.edu.ar.intropv.leandroantunez.minionone.MainGame

/*
  Esta es la pantalla que ves cuando entras al juego. Al pulsar el boton de "Jugar",
  ingresas a la pantalla del nivel (LevelScreen).
 */
class MenuScreen(game: MainGame) extends BaseScreen(game) {

  /** El Escenario, donde todos los botones son agregados. */
  // Crea un nuevo Stage con cierta Resolucion.
  private val stage: Stage = new Stage(new FitViewport(640, 360))

  /** La skin que utilizamos para los botones. */
  // Carga el archivo de la Skin. Este contiene informacion sobre las Skins.
  private val skin: Skin = new Skin(Gdx.files.internal("skin/uiskin.json"))

  /** La imagen de logo que vas a ver en la parte superior de la pantalla. */
  // Crea una imagen. Las imagenes son actores que solo proporcionan cierta textura.
  // Util cuando se quiere proporcionar una textura usando Scene2D para hacer Pantallas,
  // sin necesidad de reescribir codigo.
  private val logo: Image = new Image(game.assetManager.get("logo.png", classOf[Texture]))

  /** El boton de Play para ingresar a la Pantalla del nivel. */
  // Crea los nuevos botones de texto utilizando el archivo de Skin como imagen de fondo.
  private val play: TextButton = new TextButton("Play", skin)

  private val credits: TextButton = new TextButton("Credits", skin)

  addPositionsToActors()

  addAllActorsToStage()


  private def addAllActorsToStage(): Unit = {
    // Agregando los Actors al Stage, para que estos puedan verse.
    stage.addActor(play)
    stage.addActor(logo)
    stage.addActor(credits)
  }

  private def addPositionsToActors(): Unit = {
    // Se posicionan los Actors en la pantalla. Estan posicionadas de tal manera que se vean
    // en el centro, es por eso que los botones tienen la misma medida.
    logo.setPosition(340 - logo.getWidth / 2, 320 - logo.getHeight)
    play.setSize(100, 40)
    credits.setSize(100, 40)
    play.setPosition(40, 140)
    credits.setPosition(40, 40)
  }

  override def show(): Unit = {
    // Para permitir las interacciones con la pantalla,
    // se debe agregar que el sistema de Input pueda operar sobre este Stage.
    Gdx.input.setInputProcessor(stage)
  }

  override def hide(): Unit = {
    // Cuando la pantalla no esta siendo visible, se debe desacoplar el input del stage.
    // De lo contrario, el usuario va a seguir interactuando con la pantalla.
    Gdx.input.setInputProcessor(null)
  }

  override def dispose(): Unit = {
    // Realiza los metodos dispose sobre los recursos utilizados en esta pantalla.
    // Libera memoria de la tarjeta.
    stage.dispose()
    skin.dispose()
  }

  override def render(delta: Float): Unit = {
    Gdx.gl.glClearColor(0.2f, 0.3f, 0.5f, 1f)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    stage.act()
    stage.draw()
  }
}
