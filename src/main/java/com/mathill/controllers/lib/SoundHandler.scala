package com.mathill.controllers.lib

import net.minecraftforge.client.event.sound.SoundLoadEvent
import net.minecraftforge.event.ForgeSubscribe

class SoundHandler {

  @ForgeSubscribe
  def onSoundLoad(event: SoundLoadEvent) {

    for (soundFile <- Sounds.soundFiles) {

      try {

        event.manager.soundPoolSounds.addSound(soundFile, getClass().getResource("/" + soundFile))
      } catch {

        case e: Exception =>

      }
    }
  }
}