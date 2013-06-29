package com.mathill.controllers.lib

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

object CreativeTabBigBlocks extends CreativeTabs(CreativeTabs.getNextID(), Reference.MOD_ID) {

  @SideOnly(Side.CLIENT)
  override def getTabIconItemIndex(): Int = {

    Item.axeDiamond.itemID;
  }
}