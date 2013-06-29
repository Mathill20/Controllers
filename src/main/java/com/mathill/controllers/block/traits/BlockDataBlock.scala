package com.mathill.controllers.block.traits

import java.util.List
import cpw.mods.fml.relauncher.SideOnly
import net.minecraft.client.renderer.texture.IconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.util.Icon
import cpw.mods.fml.relauncher.Side
import com.mathill.controllers.block.BlockData

trait BlockDataBlock {

  val data: BlockData

  @SideOnly(Side.CLIENT)
  private var icons: Array[Icon] = null

  @SideOnly(Side.CLIENT)
  def registerIcons(register: IconRegister): Unit = {

    val length = data.tileTextures.length
    icons = new Array[Icon](length)

    for (i <- 0 to length - 1) icons(i) = register.registerIcon(data.tileTextures(i))
  }

  @SideOnly(Side.CLIENT)
  def getIcon(side: Int, meta: Int): Icon = {

    if (side < icons.length) icons(side)
    else icons(0)
  }

  @SideOnly(Side.CLIENT)
  def getSubBlocks(par1: Int, creativeTab: CreativeTabs, par3List: List[_]): Unit = {

  }
}