package unq.edu.ar.intropv.leandroantunez.minionone

import com.badlogic.gdx.Game
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.maps.tiled.{TiledMap, TmxMapLoader}
import unq.edu.ar.intropv.leandroantunez.minionone.screens.{GameScreen, LoadingScreen, MenuScreen}

class MainGame extends Game {

  val assetManager: AssetManager = new AssetManager()

  var menuScreen: MenuScreen = _

  var loadingScreen: LoadingScreen = _

  var gameScreen: GameScreen = _

  override def create(): Unit = {
    assetManager.load("logo.png", classOf[Texture])
    assetManager.load("player.png", classOf[Texture])
    assetManager.setLoader(classOf[TiledMap], new TmxMapLoader(new InternalFileHandleResolver))
    assetManager.load("map/minion-one-tiled.tmx", classOf[TiledMap])
    loadingScreen = new LoadingScreen(this)
    setScreen(loadingScreen)
  }

  def finishLoading(): Unit = {
    menuScreen = new MenuScreen(this)
    gameScreen = new GameScreen(this)
    setScreen(menuScreen)
  }

}