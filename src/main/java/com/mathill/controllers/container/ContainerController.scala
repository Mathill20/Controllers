package com.mathill.controllers.container

import com.mathill.controllers.controller.ControllerManager
import com.mathill.controllers.tile.TileController

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.Container
import net.minecraft.inventory.IInventory
import net.minecraft.inventory.Slot
import net.minecraft.nbt.NBTTagCompound

class ContainerController(val controller: TileController, val playerInventory: IInventory)
  extends Container {

  {
    val tags = new NBTTagCompound()
    controller.writeToNBT(tags);

    val blockId = controller.worldObj.getBlockId(controller.xCoord, controller.yCoord, controller.zCoord)

    val pageCount = tags.getInteger(ControllerManager.PAGE_COUNT)

    for (i <- 0 to pageCount - 1) {

      if (tags.hasKey("Page" + i)) {

        val page = tags.getCompoundTag("Page" + i)
      }
    }

    var startx = 56
    var starty = 178

    for (y <- 0 to 2) {

      for (x <- 0 to 8) {

        addSlotToContainer(new Slot(playerInventory, x + y * 9 + 9, startx + (x * 18), starty + (y * 18)))
      }
    }

    startx = 56
    starty = 236

    for (x <- 0 to 8)
      addSlotToContainer(new Slot(playerInventory, x, startx + (x * 18), starty))
  }

  override def canInteractWith(player: EntityPlayer) = true
}