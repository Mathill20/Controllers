package com.mathill.controllers

import java.io.File

import com.mathill.controllers.lib.ConfigurationHandler
import com.mathill.controllers.lib.LocalizationHandler
import com.mathill.controllers.lib.Reference
import com.mathill.controllers.proxy.CommonProxy

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.FingerprintWarning
import cpw.mods.fml.common.Mod.Init
import cpw.mods.fml.common.Mod.PostInit
import cpw.mods.fml.common.Mod.PreInit
import cpw.mods.fml.common.Mod.ServerStarting
import cpw.mods.fml.common.SidedProxy
import cpw.mods.fml.common.event.FMLFingerprintViolationEvent
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent
import cpw.mods.fml.common.network.NetworkMod
import cpw.mods.fml.common.network.NetworkRegistry

@Mod(modLanguage = "scala",
  modid = Reference.MOD_ID,
  name = Reference.MOD_NAME,
  version = Reference.VERSION_NUMBER,
  dependencies = Reference.DEPENDENCIES,
  certificateFingerprint = Reference.FINGERPRINT)
@NetworkMod(
  //  channels = Array[String](Reference.CHANNEL_NAME),
  clientSideRequired = true,
  serverSideRequired = false)
object ControllersMod {

  @SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
  var proxy: CommonProxy = null

  @FingerprintWarning
  def invalidFingerprint(evt: FMLFingerprintViolationEvent) = {}

  @ServerStarting
  def serverStarting(evt: FMLServerStartingEvent) = {}

  @PreInit
  def preInit(evt: FMLPreInitializationEvent) = {

    ConfigurationHandler.load(getModConfig(evt.getModConfigurationDirectory().getAbsolutePath()))

    proxy.registerSoundHandler()
    proxy.initBlocks()
    proxy.initItems()
    proxy.initRecipes()
    proxy.initController()

    LocalizationHandler.registerLocalizations()
  }

  @Init
  def load(evt: FMLInitializationEvent) = {

    NetworkRegistry.instance.registerGuiHandler(this, proxy)
    proxy.initTileEntities()
  }

  @PostInit
  def modsLoaded(evt: FMLPostInitializationEvent) = {}

  def getModConfig(path: String) =
    new File(path + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg")
}