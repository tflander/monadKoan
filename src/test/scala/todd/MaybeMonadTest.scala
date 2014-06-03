package todd
import org.scalatest._

class MaybeMonadTest extends FunSpec with ShouldMatchers {

  it("Allows you to declare a String as optional") {
    val stringOrNot: Maybe[String] = Nope
    stringOrNot should be(Nope)
  }
  
}