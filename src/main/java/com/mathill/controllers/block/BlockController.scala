package com.mathill.controllers.block

import com.mathill.controllers.ControllersMod
import com.mathill.controllers.block.traits.BlockDataBlock
import com.mathill.controllers.lib.CommonMethods
import com.mathill.controllers.tile.TileController
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.network.NetworkMod
import cpw.mods.fml.relauncher.SideOnly
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.EntityLiving
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.Icon
import net.minecraft.world.World
import cpw.mods.fml.relauncher.Side

class BlockController(tempData: BlockData) extends { val data = tempData } with BlockContainer(tempData.blockId, Material.wood) with BlockDataBlock {

  @SideOnly(Side.CLIENT)
  private val icons: Array[Icon] = Array[Icon](null, null, null, null, null, null)

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, par6: Int, par7: Float, par8: Float, par9: Float): Boolean = {

    if (player.isSneaking()) return false;

    val tile: TileEntity = world.getBlockTileEntity(x, y, z);

    if (tile.isInstanceOf[TileController]) {

      val controller: TileController = tile.asInstanceOf[TileController];

      if (controller.revalidate()) {

        if (CommonMethods.isRenderWorld(world)) {

          player.openGui(ControllersMod, ModBlocks.CONTROLLER.guiId, world, x, y, z);
        }
      }
    }

    return true;
  }

  override def getIcon(side: Int, meta: Int): Icon = {

    super.getIcon(side, meta)
  }

  override def registerIcons(register: IconRegister): Unit = {

    super.registerIcons(register)
  }

  override def createNewTileEntity(world: World) = {

    null
  }

  override def onBlockPlacedBy(world: World, x: Int, y: Int, z: Int, entityLiving: EntityLiving, stack: ItemStack) {

  }

  override def getSubBlocks(par1: Int, tab: CreativeTabs, par3: java.util.List[_]): Unit = {

    super.getSubBlocks(par1, tab, par3);
  }
}