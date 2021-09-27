package popl

object hw02_orig extends js.util.JsApp {

  import js._
  import js.ast._

  /*
   * CSCI-UA.0480-055: Homework 2
   */

  /*
   * Replace the '???' expression with your code in each function.
   *
   * Do not make other modifications to this template, such as
   * - adding "extends App" or "extends Application" to your Lab object,
   * - adding a "main" method, and
   * - leaving any failing asserts.
   *
   * Your solution will _not_ be graded if it does not compile!!
   *
   * This template compiles without error. Before you submit comment out any
   * code that does not compile or causes a failing assert.  Simply put in a
   * '???' as needed to get something that compiles without error.
   *
   */

  /* Binary Search Tree */

  sealed abstract class Tree

  case object Empty extends Tree

  case class Node(left: Tree, data: Int, right: Tree) extends Tree

  def repOk(t: Tree): Boolean = {
    def check(t: Tree, min: Int, max: Int): Boolean = t match {
      case Empty => true
      case Node(left, data, right) => ???
    }

    check(t, Int.MinValue, Int.MaxValue)
  }

  def insert(t: Tree, n: Int): Tree = ???

  def deleteMin(t: Tree): (Tree, Int) = {
    require(t != Empty)
    (t: @unchecked) match {
      case Node(Empty, data, right) => (right, data)
      case Node(left, data, right) =>
        val (left1, min) = deleteMin(left)
        ???
    }
  }

  def delete(t: Tree, n: Int): Tree = ???

  /* JakartaScript */

  def eval(e: Expr): Double = e match {
    case Num(n) => ???
    case _ => ???
  }

  // Interface to run your interpreter from a string.  This is convenient
  // for unit testing.
  def eval(s: String): Double = eval(parse.fromString(s))


  /* Interface to run your interpreter from the command line.  You can ignore the code below. */

  def processFile(file: java.io.File) = {
    if (debug) {
      println("============================================================")
      println("File: " + file.getName)
      println("Parsing ...")
    }

    val expr = handle(fail()) {
      parse.fromFile(file)
    }

    if (debug) {
      println("Parsed expression:")
      println(expr)
    }

    handle(()) {
      val v = eval(expr)
      println(v)
    }
  }
}
