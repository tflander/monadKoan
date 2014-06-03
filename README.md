Todd's Monad Koan -- The Obligitory Monad Tutorial
==================================================

Step 0:
-------

  Examine the test MaybeMonadTest.scala:
  
```scala
class MaybeMonadTest extends FunSpec with ShouldMatchers {

  it("Allows you to declare a String as optional") {
    val stringOrNot: Maybe[String] = Nope
    stringOrNot should be(Nope)
  }
  
}
```
Note the error:  
```
type mismatch; found : todd.Nope.type required: todd.Maybe[String] Note: Nothing <: String (and todd.Nope.type <: todd.Maybe[Nothing]), but class Maybe 
 is invariant in type A. You may wish to define A as +A instead. (SLS 4.5)
``` 
Examine the code under test in MaybeMonad.scala:

```scala
class Maybe[A]

case object Nope extends Maybe[Nothing]
```

Note that the type Maybe is invariant, so an object of type **Maybe[Nothing]** cannot be assigned to a value of type **Maybe[String]**.

Fix the broken test by making the parameterized type **Maybe[A]** covariant.  This will allow **Maybe[Nothing]** to be considered a sub-type
of any **Maybe** type, including **Maybe[String]**.
   