package com.mathill.controllers.lib

object Sounds {

  val SOUND_RESOURCE_LOCATION = "mods/cconduit/sound/";
  val SOUND_PREFIX = "mods.cconduit.sound.";

  val soundFiles = Array(SOUND_RESOURCE_LOCATION + "chargeDown.ogg", SOUND_RESOURCE_LOCATION + "chargeUp.ogg",
    SOUND_RESOURCE_LOCATION + "destruct.ogg", SOUND_RESOURCE_LOCATION + "fail.ogg", SOUND_RESOURCE_LOCATION + "gust.ogg",
    SOUND_RESOURCE_LOCATION + "heal.ogg", SOUND_RESOURCE_LOCATION + "kinesis.ogg", SOUND_RESOURCE_LOCATION + "launch.ogg",
    SOUND_RESOURCE_LOCATION + "nova.ogg", SOUND_RESOURCE_LOCATION + "philball.ogg", SOUND_RESOURCE_LOCATION + "tock.ogg",
    SOUND_RESOURCE_LOCATION + "transmute.ogg", SOUND_RESOURCE_LOCATION + "wall.ogg", SOUND_RESOURCE_LOCATION + "waterball.ogg",
    SOUND_RESOURCE_LOCATION + "wind.ogg");

  val CHARGE_DOWN = SOUND_PREFIX + "chargeDown";
  val CHARGE_UP = SOUND_PREFIX + "chargeUp";
  val DESTRUCTION = SOUND_PREFIX + "destruct";
  val FAIL = SOUND_PREFIX + "fail";
  val GUST = SOUND_PREFIX + "gust";
  val HEAL = SOUND_PREFIX + "heal";
  val KINESIS = SOUND_PREFIX + "kinesis";
  val LAUNCH = SOUND_PREFIX + "launch";
  val NOVA = SOUND_PREFIX + "nova";
  val PHILOSOPHERS_BALL = SOUND_PREFIX + "philball";
  val TOCK = SOUND_PREFIX + "tock";
  val TRANSMUTE = SOUND_PREFIX + "transmute";
  val WALL = SOUND_PREFIX + "wall";
  val WATER_BALL = SOUND_PREFIX + "waterball";
  val WIND = SOUND_PREFIX + "wind";

  val CHEST_OPEN = "random.chestopen";
  val CHEST_CLOSE = "random.chestclosed";
  val CHARGE_FAIL = FAIL;
}