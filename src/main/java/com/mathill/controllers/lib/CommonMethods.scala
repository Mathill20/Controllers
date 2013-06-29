package com.mathill.controllers.lib

import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraft.entity.item.EntityItem

object CommonMethods {

  def dropItems(world: World, stack: ItemStack, x: Int, y: Int, z: Int) {

    if (stack.stackSize <= 0) return

    val f1: Float = 0.7f
    val d: Double = (world.rand.nextFloat() * f1) + (1.0F - f1) * 0.5D
    val d1: Double = (world.rand.nextFloat() * f1) + (1.0F - f1) * 0.5D
    val d2: Double = (world.rand.nextFloat() * f1) + (1.0F - f1) * 0.5D

    val entItem: EntityItem = new EntityItem(world, x + d, y + d1, z + d2, stack)
    entItem.delayBeforeCanPickup = 10

    world.spawnEntityInWorld(entItem)
  }

  def isRenderWorld(world: World) = world.isRemote
}