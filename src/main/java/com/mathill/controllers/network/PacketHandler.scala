package com.mathill.controllers.network

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

object PacketHandler extends IPacketHandler {

  def onPacketData(manager: INetworkManager,
    packet: Packet250CustomPayload,
    player: Player): Unit = {

  }
}