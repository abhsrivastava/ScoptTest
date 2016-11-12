package com.abhi


/**
  * Created by abhsrivastava on 11/12/16.
  */

import scopt._

case class Config(foo: Int = -1, bar: Seq[Int] = List())

object ScoptTest extends App {
   val parser = new OptionParser[Config]("ScoptTest") {
      head("ScoptTest", "1.0")
      opt[Int]('f', "foo")
         .action((x, config) => config.copy(foo = x))
         .text("foo is an integer")
         .required()
      opt[Seq[Int]]('b', "bar")
         .action((x, config) => config.copy(bar = x))
         .text("bar is a list")
         .required()
   }

   parser.parse(args, Config()) match {
      case Some(config) => println(s"you provided config foo ${config.foo} and bar ${config.bar}")
      case None => println("usage ScoptTest -b badgeId")
   }
}
