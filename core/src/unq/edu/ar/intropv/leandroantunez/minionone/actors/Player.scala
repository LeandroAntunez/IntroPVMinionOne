package unq.edu.ar.intropv.leandroantunez.minionone.actors

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d._
import com.badlogic.gdx.scenes.scene2d.Actor

class Player(private val world: World, private val texture: Texture, private val position: Vector2) extends Actor {

  // Create the player body.
  private val bodyDef: BodyDef = new BodyDef         // (1) Crea la definicion del cuerpo
  bodyDef.position.set(position)                     // (2) Pone el cuerpo en posicion inicial.
  bodyDef.`type` = BodyDef.BodyType.DynamicBody      // (3) Hace el cuerpo dinamico.
  private val body: Body = world.createBody(bodyDef) // (4) Crea el cuerpo..

  // Give it some shape.
  private val box = new PolygonShape                                 // (1) Crea el poligono.
  box.setAsBox(0.5f, 0.5f)                                // (2) Lo setea como una caja 1x1m.
  private val fixture: Fixture = body.createFixture(box, 3) // (3) Crea el fixture.
  fixture.setUserData("player")                                      // (4) Setea el user data.
  box.dispose()                                                      // (5) Destruye el poligono.

  // Setea la medida del actor jugador en pantalla
  setSize(45f, 45f)

  override def draw(batch: Batch, parentAlpha: Float): Unit = {
    // Actualiza la posicion en pantalla del cuerpo.
    setPosition((body.getPosition.x - 0.5f) * 90f, (body.getPosition.y - 0.5f) * 90f)
    batch.draw(texture, getX, getY, getWidth, getHeight)
  }

  def detach(): Unit = {
    body.destroyFixture(fixture)
    world.destroyBody(body)
  }

}
