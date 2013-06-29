package com.mathill.controllers.proxy

import com.mathill.controllers.gui.GuiController
import com.mathill.controllers.lib.SoundHandler
import com.mathill.controllers.tile.TileController

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import net.minecraftforge.common.MinecraftForge

class ClientProxy extends CommonProxy {

  override def getServerGuiElement(id: Int,
    player: EntityPlayer,
    world: World,
    x: Int,
    y: Int,
    z: Int): AnyRef = {

    if (!world.blockExists(x, y, z)) null
    else {

      val tile: TileEntity = world.getBlockTileEntity(x, y, z)

      null
    }
  }

  override def getClientGuiElement(id: Int,
    player: EntityPlayer,
    world: World,
    x: Int,
    y: Int,
    z: Int): AnyRef = {

    if (!world.blockExists(x, y, z)) null
    else {

      val tile: TileEntity = world.getBlockTileEntity(x, y, z)

      if (tile.isInstanceOf[TileController]) {

        new GuiController(player.inventory, tile.asInstanceOf[TileController])
      } else {

        null
      }
    }
  }

  override def registerSoundHandler() {

    MinecraftForge.EVENT_BUS.register(new SoundHandler())
  }
}