package unq.edu.ar.intropv.leandroantunez.minionone.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.{Label, Skin}
import com.badlogic.gdx.utils.viewport.FitViewport
import unq.edu.ar.intropv.leandroantunez.minionone.MainGame

/**
  *   Esta Pantalla es ejecutada al principio, y es usada para cargar recursos de manera
  * sincronizada con el asset manager.
  *   En ejecucion, muestra una pantalla de fondo negro que dice "Loading", mientras
  * indica un porcentaje de los recursos que son cargados.
  */
class LoadingScreen(game: MainGame) extends BaseScreen(game) {

  /** El Escenario, donde todos los botones son agregados. */
  // Crea un nuevo Stage con cierta Resolucion.
  private val stage: Stage = new Stage(new FitViewport(640, 360))

  /** La skin que utilizamos para los botones. */
  // Carga el archivo de la Skin. Este contiene informacion sobre las Skins.
  private val skin: Skin = new Skin(Gdx.files.internal("skin/uiskin.json"))

  // Create some loading text using this skin file and position it on screen.
  private val loading: Label = new Label("Loading...", skin)

  override def show(): Unit = {
    loading.setPosition(320 - loading.getWidth / 2, 180 - loading.getHeight / 2)
    stage.addActor(loading)
  }

  override def render(delta: Float): Unit = {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    // Para cargar un recurso con el Asset Manager, se llama al metodo update().
    // Este metodo va a retornar true si finalizo la carga.
    // Cuando haya finalizado, va a cambiar a la pantalla de menu principal del juego.
    // Util para evitar excepsiones de pantallas cuyos recursos no fueron cargados.
    if (game.assetManager.update) {
      game.finishLoading()
    }
    else {
      val progress = (game.assetManager.getProgress * 100).toInt
      loading.setText("Loading... " + progress + "%")
    }
    stage.act()
    stage.draw()
  }

  override def dispose(): Unit = {
    stage.dispose()
    skin.dispose()
  }
}

