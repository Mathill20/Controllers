package com.mathill.controllers.proxy

import scala.collection.mutable.ListBuffer

class LoadLater extends DelayedInit {

  var stuff = new ListBuffer[() => Unit]
  var fire = false

  def delayedInit(code: => Unit) {

    println(f"onInit: ${getClass.getName}")
    if (!fire) stuff += (() => code)
    else code
  }

  def init() {

    fire = true
    stuff.toList.foreach(_())
  }
}