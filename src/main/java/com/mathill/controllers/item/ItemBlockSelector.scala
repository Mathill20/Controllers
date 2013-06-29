package com.mathill.controllers.item

import java.util.regex.Pattern

import scala.collection.JavaConversions.mapAsScalaMap

import com.mathill.controllers.controller.ControllerManager

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World

class ItemBlockSelector(val data: ItemData) extends Item(data.id) {

  final val CONTROLLER_LOCATION: String = "controllerLoc"
  final val BLOCK_LOCATIONS = "blockLocations"
  setCreativeTab(data.tab)

  override def onItemRightClick(stack: ItemStack, world: World, player: EntityPlayer): ItemStack = {

    if (player.isSneaking()) {

      clearBlockLocations(player, stack)
    }

    stack
  }

  override def onItemUse(stack: ItemStack, player: EntityPlayer, world: World, par4: Int, par5: Int, par6: Int, par7: Int, par8: Float, par9: Float, par10: Float): Boolean = {

    true
  }

  override def onItemUseFirst(stack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, size: Int, hitx: Float, hity: Float, hitz: Float): Boolean = {

    val tags = getTags(stack)

    if (player.isSneaking()) {

      clearBlockLocations(player, stack)
      true
    } else {

      val blockLocs = getBlockLocations(tags)
      val blockCount = blockLocs.tagMap.size
      val blockName = getBlockName(x, y, z)
      val isNewTag = !blockLocs.hasKey(blockName)
      val blockId = world.getBlockId(x, y, z)

      if (ControllerManager.getMultiblockInfo(blockId) != null) {

        if (isNewTag) {

          if (blockCount < 4) {

            player.addChatMessage("Block at <" + blockName + "> added.")
            blockLocs.setIntArray(blockName, Array(x, y, z))
          } else {

            player.addChatMessage("Block at <" + blockName + "> already added.")
          }
        } else {

          player.addChatMessage("Block at <" + blockName + "> already added.")
        }

        true
      } else {

        false
      }
    }
  }

  override def getUnlocalizedName() = {

    super.getUnlocalizedName
  }

  override def addInformation(stack: ItemStack, player: EntityPlayer, list: java.util.List[_], bool: Boolean) {

    val values: java.util.List[AnyRef] = list.asInstanceOf[java.util.List[AnyRef]]
    val tags = getTags(stack)
    val blockLocs = getBlockLocations(tags)

    blockLocs.tagMap.values()
    if (blockLocs != null)
      blockLocs.tagMap.foreach(coord => values.add(coord._2 + "," + coord._2 + "," + coord._2))
  }

  private def getBlockLocations(tags: NBTTagCompound): NBTTagCompound = {

    if (tags == null) return null

    if (!tags.hasKey(BLOCK_LOCATIONS)) {

      val blockLocs = new NBTTagCompound(BLOCK_LOCATIONS)
      tags.setTag(BLOCK_LOCATIONS, blockLocs)
      blockLocs
    } else {

      tags.getCompoundTag(BLOCK_LOCATIONS)
    }
  }

  private def getTags(stack: ItemStack): NBTTagCompound = {

    val tags = stack.getTagCompound()

    if (tags == null) {

      val tag = new NBTTagCompound("tags")
      stack.setTagInfo("tags", tag)
      tag
    } else {

      tags.getCompoundTag("tags")
    }
  }

  private def clearBlockLocations(player: EntityPlayer, stack: ItemStack): Unit = {

    val tags = getTags(stack)
    val blockLocs = getBlockLocations(tags)

    if (blockLocs != null && blockLocs.tagMap.size() != 0) {

      tags.setTag(BLOCK_LOCATIONS, new NBTTagCompound(BLOCK_LOCATIONS))

      if (player != null) {

        player.addChatMessage("Cleared Block List")
      }
    }
  }

  private def getBlockName(x: Int, y: Int, z: Int): String = {

    x + "," + y + "," + z
  }
}

object ItemBlockSelector {

  final val blockPattern: Pattern = Pattern.compile("[{][0-9]*,[0-9]*,[0-9]*[}](,[{][0-9]*,[0-9]*,[0-9]*[}])*")
}