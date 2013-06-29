package com.mathill.controllers.item

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item

class ItemData(
  var item: Item,
  val id: Int,
  val defaultId: Int,
  val unlocalizedName: String,
  val localizedName: String,
  val tab: CreativeTabs) {
}