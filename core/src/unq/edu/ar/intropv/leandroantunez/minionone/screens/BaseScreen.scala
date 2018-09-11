package unq.edu.ar.intropv.leandroantunez.minionone.screens

import com.badlogic.gdx.Screen
import unq.edu.ar.intropv.leandroantunez.minionone.MainGame

/**
  * Esta es la Pantalla por defecto. Todas las Pantallas definen su comportamiento a partir de esta.
  * Esta Pantalla tiene dos propositos:
  *       - Una es sobreescribir cada metodo que no sea requerido en las otras Pantallas.
  *       - La segunda es proveer recursos en comun para cada Pantalla.
  */

/**
  * var game: MainGame. Haciendola una variable que se puede obtener del constructor,
  * cada Pantalla puede estar conectada al Juego, para que estas puedan acceder a la
  * instancia del Juego.
  */
abstract class BaseScreen(var game: MainGame) extends Screen{

  override def show(): Unit = {
    // Este metodo es llamado cuando la Pantalla esta siendo utilizada.
  }

  override def render(delta: Float): Unit = {
    // Este metodo es llamado cuando una Pantalla tiene que renderizar un frame.
    // Delta es la cantidad de segundos (cercana a 0.01) entre este y el ultimo frame.
  }

  override def resize(width: Int, height: Int): Unit = {
    // Este metodo es llamado cuando el Juego tiene que cambiar su resolucion.
  }

  override def pause(): Unit = {
    // Metodo llamado cuando el juego esta en pausa.
  }

  override def resume(): Unit = {
    // Metodo llamado cuando el juego deja de estar pausado.
  }

  override def hide(): Unit = {
    // Metodo llamado cuando la pantalla ya no es utilizada.
  }

  override def dispose(): Unit = {
    // Metodo llamado cuando cierra el Juego.
  }

}
