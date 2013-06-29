package com.mathill.controllers.lib

import cpw.mods.fml.common.FMLLog
import java.util.logging.Level
import java.io.File
import net.minecraftforge.common.Configuration
import net.minecraftforge.common.Property

object ConfigurationHandler {

  var config: Configuration = null

  def load(file: File) = {

    config = new Configuration(file)

    try {

      config.load()
    } catch {
      case e: Exception =>
        FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " had a problem loading its configuration.")
    } finally {

      config.save()
    }
  }

  def save() = {

    config.save()
  }

  /**
   * Gets the specified property. The property and/or category is created if they do not exist.
   */
  def getPropertyAndCreate(categoryName: String, propertyName: String) = {

    val category = config.getCategory(categoryName)

    if (!category.containsKey(propertyName)) {

      category.put(propertyName, new Property());
    }

    category.get(propertyName)
  }

  def getProperty(categoryName: String, propertyName: String) = {

    if (config != null && config.hasCategory(categoryName)) {

      config.getCategory(categoryName).get(propertyName)
    }
  }
}