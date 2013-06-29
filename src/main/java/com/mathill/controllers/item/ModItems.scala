package com.mathill.controllers.item

import com.mathill.controllers.lib.CreativeTabBigBlocks

import net.minecraft.item.Item

object ModItems {

  var BLOCK_SELECTOR = createBlockSelectItem(3050)

  def createBlockSelectItem(id: Int, item: Item = null): ItemData = {

    new ItemData(item = item, id = id, defaultId = 3050, unlocalizedName = "com.mathill.cc.items.ItemBlockSelector",
      localizedName = "Controller Block Selector", tab = CreativeTabBigBlocks)
  }
}