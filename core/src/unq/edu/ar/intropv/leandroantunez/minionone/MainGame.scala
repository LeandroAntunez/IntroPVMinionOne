package unq.edu.ar.intropv.leandroantunez.minionone

import com.badlogic.gdx.Game
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import unq.edu.ar.intropv.leandroantunez.minionone.screens.{GameScreen, LoadingScreen, MenuScreen}

class MainGame extends Game {

  val assetManager: AssetManager = new AssetManager()

  var menuScreen: MenuScreen = _

  var loadingScreen: LoadingScreen = _

  var gameScreen: GameScreen = _

  override def create(): Unit = {
    assetManager.load("logo.png", classOf[Texture])
    assetManager.load("player.png", classOf[Texture])
    loadingScreen = new LoadingScreen(this)
    setScreen(loadingScreen)
  }

  /**
    * This method is invoked by LoadingScreen when all the assets are loaded. Use this method
    * as a second-step loader. You can load the rest of the screens here and jump to the main
    * screen now that everything is loaded.
    */
  def finishLoading(): Unit = {
    menuScreen = new MenuScreen(this)
    gameScreen = new GameScreen(this)
    setScreen(menuScreen)
  }

}