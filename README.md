Todd's Monad Koan -- The Obligitory Monad Tutorial
==================================================

Step 1:
-------

OK -- We made our Maybe Monad covariant.  Good job.  It was as simple as typing a plus-sign for the parameterized type:

```scala
class Maybe[+A]
```
  Examine the changes in MaybeMonad.scala:
  
```scala
abstract class Maybe[+A] {
  def get:A
}

case object Nope extends Maybe[Nothing] {
  override def get:Nothing = throw new UnsupportedOperationException("You can't get a maybe that doesn't exist")   
}

In addition to making **Maybe** covariant, we added an abstract **get** method.  This will allow 
us to get the value of a populated **Maybe**.

Note the code smell -- **get** is not a valid operation for **Nope**, so we have an interface 
segregation problem.

```
  Examine the new broken test in MaybeMonadTest.scala:
  
```scala
  it("Allows you to declare a defined string as optional") {
    val stringOrNot: Maybe[String] = Gotta("hello")
    stringOrNot should be(Gotta("hello"))    
  }
```
Note the error:  
```
not found: value Gotta
``` 
Edit MaybeMonad.scala to define the type **Gotta** as a sub-class of **Maybe**

   