package todd
import org.scalatest._

class MaybeMonadTest extends FunSpec with ShouldMatchers {

  it("Allows you to declare an undefined String as optional") {
    val stringOrNot: Maybe[String] = Nope
    stringOrNot should be(Nope)
  }
  
  it("Allows you to declare a defined string as optional") {
    val stringOrNot: Maybe[String] = Gotta("hello")
    stringOrNot.get should be("hello")
  }
}