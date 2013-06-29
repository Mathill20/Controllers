package com.mathill.controllers.controller

import scala.collection.mutable.HashMap
import scala.collection.mutable.LinkedHashMap
import scala.collection.mutable.Map

object ControllerManager {

  final val controllerInfo: Map[Int, scala.collection.mutable.Map[Int, ControllerInfo]] = new LinkedHashMap[Int, Map[Int, ControllerInfo]]
  final val multiInfo = new LinkedHashMap[Integer, MultiblockInfo]
  final val PAGE_COUNT = "Page Count"

  def addController(info: ControllerInfo): Boolean = {

    val meta: scala.collection.mutable.Map[Int, ControllerInfo] = controllerInfo(info.blockId)

    if (meta != null) {

      val info2 = meta.get(info.metavalue)

      if (info2 != null) {

        false
      } else {

        meta(info.blockId) = info
        return true
      }
    } else {

      val map = new LinkedHashMap[Int, ControllerInfo]
      map(info.metavalue) = info
      controllerInfo.put(info.blockId, map)
      true
    }
  }

  def addMultiblockInfo(info: MultiblockInfo): Boolean = {

    var valid = true

    for (block <- info.validBlocks) {

      valid &= !multiInfo.contains(block)
    }

    if (!valid) false
    else {

      for (key <- info.validBlocks) {

        multiInfo(key) = info
      }

      true
    }

  }

  def getControllerInfo(controllerId: Int, meta: Int): ControllerInfo = {

    val info = controllerInfo.get(controllerId)
    if (info == null) null
    else info.get(meta)
  }

  def getMultiblockInfo(targetBlockId: Int): MultiblockInfo = {

    val option = multiInfo.get(targetBlockId)
    
    if (option.isDefined) option.get
    else null
  }
}