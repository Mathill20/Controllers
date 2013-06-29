package com.mathill.controllers.block

import net.minecraft.block.Block
import com.mathill.controllers.lib.CreativeTabBigBlocks
import com.mathill.controllers.lib.Locations
import com.mathill.controllers.lib.Reference

object ModBlocks {

  var CONTROLLER = createController(3001)

  private def assignTileTexture(texture: String, textures: Array[String]) = for (i <- 0 to 5) textures(i) = texture

  private def createTileTextureArray(texture: String): Array[String] = {

    val textures = new Array[String](6)

    assignTileTexture(texture, textures)

    textures
  }

  def createController(blockId: Int = 3001, block: Block = null): BlockData = {

    new BlockData(block = block,
      blockId = blockId,
      blockIdDefault = 3001,
      metadata = 0,
      blockName = "com.mathill.bigblocks.blocks.BlockController",
      blockUnlocalizedName = "controllerBlock",
      blockLocalizedName = "Controller",
      tileName = "tileController",
      tileRenderId = 0,
      tileTextures = createTileTextureArray(Reference.MOD_ID + ":controller/stone").toList,
      guiId = 0,
      guiTexture = Locations.GUI_LOCATION + "fakeGui.png",
      tab = CreativeTabBigBlocks,
      model = null,
      modelTexture = "")
  }
}