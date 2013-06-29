package com.mathill.controllers.block

import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs

class BlockData(var block: Block,
                val blockId: Int,
                val blockIdDefault: Int,
                val metadata: Int,
                val blockName: String,
                val blockUnlocalizedName: String,
                val blockLocalizedName: String,
                val tileName: String,
                val tileRenderId: Int,
                val tileTextures: List[String],
                val model: String,
                val modelTexture: String,
                val guiId: Int,
                val guiTexture: String,
                val tab: CreativeTabs) extends Cloneable {

}