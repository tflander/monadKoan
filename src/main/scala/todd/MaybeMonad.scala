package todd

abstract class Maybe[+A] {
  def get:A
}

case object Nope extends Maybe[Nothing] {
  override def get:Nothing = throw new UnsupportedOperationException("You can't get a maybe that doesn't exist")   
}
