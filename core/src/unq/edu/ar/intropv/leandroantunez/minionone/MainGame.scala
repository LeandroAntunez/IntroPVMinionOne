package unq.edu.ar.intropv.leandroantunez.minionone

import com.badlogic.gdx.Game
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import unq.edu.ar.intropv.leandroantunez.minionone.screens.MenuScreen

class MainGame extends Game {

  val assetManager: AssetManager = new AssetManager()

  var menuScreen: MenuScreen = _

  // Getter del administrador de recursos (musica, imagenes, etc).
  def manager: AssetManager = this.assetManager

  override def create(): Unit = {
    assetManager.load("logo.png", classOf[Texture])
    assetManager.finishLoading()

    menuScreen = new MenuScreen(this)
    setScreen(menuScreen)
  }

}