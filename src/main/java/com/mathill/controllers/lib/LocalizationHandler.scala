package com.mathill.controllers.lib

import com.mathill.controllers.block.ModBlocks
import com.mathill.controllers.item.ModItems

import cpw.mods.fml.common.registry.LanguageRegistry

object LocalizationHandler {

  def registerLocalizations(): Unit = {

    //    LanguageRegistry.addName(ModBlocks.PIPE_ROLLER.block, ModBlocks.PIPE_ROLLER.blockLocalizedName);
    //    LanguageRegistry.addName(ModBlocks.PIPE_EXTRUDER.block, ModBlocks.PIPE_EXTRUDER.blockLocalizedName);
    LanguageRegistry.addName(ModBlocks.CONTROLLER.block, ModBlocks.CONTROLLER.blockLocalizedName);

    LanguageRegistry.addName(ModItems.BLOCK_SELECTOR.item, ModItems.BLOCK_SELECTOR.localizedName);
  }
}