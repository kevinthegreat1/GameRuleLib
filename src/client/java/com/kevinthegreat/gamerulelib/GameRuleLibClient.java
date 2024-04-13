package com.kevinthegreat.gamerulelib;

import com.kevinthegreat.gamerulelib.impl.GameRuleLib;
import com.kevinthegreat.gamerulelib.impl.GameRuleUpdateS2CPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.GameRules;

public class GameRuleLibClient implements ClientModInitializer {
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(GameRuleUpdateS2CPacket.TYPE, (packet, player, responseSender) ->
                MinecraftClient.getInstance().execute(() -> player.clientWorld.getGameRules().get(new GameRules.Key(packet.name(), null)).invokeDeserialize(packet.value()))
        );
        GameRuleLib.LOGGER.info(GameRuleLib.MOD_NAME + "initialized");
    }
}
