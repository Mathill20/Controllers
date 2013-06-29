package com.mathill.controllers.lib

object Reference {

  /* Debug Mode On-Off */
  final val DEBUG_MODE = true;

  /* General Mod related constants */
  final val MOD_ID = "Controllers";
  final val MOD_NAME = "Controllers";
  final val VERSION_NUMBER = "@VERSION@ (build @BUILD_NUMBER@)";
  final val CHANNEL_NAME = MOD_ID;
  final val DEPENDENCIES = "required-after:Forge@[7.7.1.650,)";
  final val FINGERPRINT = "@FINGERPRINT@";
  final val SECOND_IN_TICKS = 20;
  final val SHIFTED_ID_RANGE_CORRECTION = 256;
  final val VERSION_CHECK_ATTEMPTS = 3;
  final val SERVER_PROXY_CLASS = "com.mathill.controllers.proxy.CommonProxy";
  final val CLIENT_PROXY_CLASS = "com.mathill.controllers.proxy.ClientProxy";
}