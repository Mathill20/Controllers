package com.mathill.controllers.gui

import org.lwjgl.opengl.GL11

import com.mathill.controllers.container.ContainerController
import com.mathill.controllers.lib.Locations
import com.mathill.controllers.tile.TileController

import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.client.renderer.Tessellator
import net.minecraft.inventory.IInventory

class GuiController(playerInventory: IInventory, controller: TileController)
  extends GuiContainer(new ContainerController(controller, playerInventory)) {

  val overlaycolor: Int = 0xffffff

  override def drawGuiContainerBackgroundLayer(f: Float, i: Int, j: Int) {

    GL11.glPushMatrix()
    mc.renderEngine.bindTexture(Locations.GUI_LOCATION + "/Page slots.png")

    val xScale = 0.3f
    val yScale = 0.3f
    val zScale = 0.3f

    GL11.glScaled(xScale, yScale, zScale)

    val xSize = 256
    val ySize = 256

    val xStart = ((width) / 2) / xScale
    val yStart = ((height) / 2) / yScale

    val par3 = 0
    val par4 = 0

    val f2 = 0.00390625f
    val f1 = 0.00390625f
    val tessellator = Tessellator.instance

    tessellator.startDrawingQuads();
    tessellator.addVertexWithUV(xStart,
      yStart + ySize,
      this.zLevel,
      (par3 + 0) * f2,
      (par4 + ySize) * f1)
    tessellator.addVertexWithUV((xStart + xSize),
      (yStart + ySize),
      this.zLevel,
      (par3 + xSize) * f2,
      (par4 + ySize) * f1)
    tessellator.addVertexWithUV((xStart + xSize),
      (yStart + 0),
      this.zLevel,
      (par3 + xSize) * f2,
      (par4 + 0) * f1)
    tessellator.addVertexWithUV((xStart + 0),
      (yStart + 0),
      this.zLevel,
      (par3 + 0) * f2,
      (par4 + 0) * f1)
    tessellator.draw();

    GL11.glPopMatrix();
  }
}