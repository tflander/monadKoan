package todd

// TODO:  sealed? trait?
class Maybe[A]

case object Nope extends Maybe[Nothing]