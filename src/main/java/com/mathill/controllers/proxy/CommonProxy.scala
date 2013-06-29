package com.mathill.controllers.proxy

import com.mathill.controllers.block.BlockController
import com.mathill.controllers.block.BlockData
import com.mathill.controllers.block.ModBlocks
import com.mathill.controllers.item.ItemBlockSelector
import com.mathill.controllers.item.ItemData
import com.mathill.controllers.item.ModItems
import com.mathill.controllers.itemblock.ItemBlockController
import com.mathill.controllers.lib.Reference

import cpw.mods.fml.common.network.IGuiHandler
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World

class CommonProxy extends IGuiHandler {

  override def getServerGuiElement(id: Int,
    player: EntityPlayer,
    world: World,
    x: Int,
    y: Int,
    z: Int): Object = {

    return null
  }

  override def getClientGuiElement(id: Int,
    player: EntityPlayer,
    world: World,
    x: Int,
    y: Int,
    z: Int): Object = {

    return null
  }

  def initBlocks(): Unit = {

    var data: BlockData = null

    data = ModBlocks.CONTROLLER
    data.block = new BlockController(data)
    GameRegistry.registerBlock(data.block, classOf[ItemBlockController], data.blockName)
  }

  def initItems(): Unit = {

    var data: ItemData = null

    data = ModItems.BLOCK_SELECTOR;
    data.item = new ItemBlockSelector(data);
    GameRegistry.registerItem(data.item, data.unlocalizedName, Reference.MOD_ID);
  }

  def initTileEntities(): Unit = {

  }

  def initRenderingAndTextures(): Unit = {

  }

  def initRecipes(): Unit = {

    //    val cobble = new ItemStack(Block.cobblestone)
    //    val furnace = new ItemStack(Block.furnaceIdle)
    //    val sand = new ItemStack(Block.sand)
    //
    //    GameRegistry.addRecipe(new ItemStack(ModBlocks.PIPE_EXTRUDER.block), Array[Any]("cfc", "sfs", "cfc", 'c', cobble, 'f', furnace, 's', sand));

  }

  def registerSoundHandler(): Unit = {

  }

  def initController(): Unit = {

    //    var info = new MultiblockInfo()
    //    info.validBlocks = Array[Int](Block.furnaceIdle.blockID, Block.furnaceBurning.blockID)
    //    info.dummyId = ModBlocks.MULTI_FURNACE_DUMMY.blockId
    //    info.guiId = 0
    //
    //    ControllerManager.addMultiblockInfo(info);
  }
}