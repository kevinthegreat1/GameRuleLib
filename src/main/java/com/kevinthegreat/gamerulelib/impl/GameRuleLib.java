package com.kevinthegreat.gamerulelib.impl;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiConsumer;

public class GameRuleLib {
    public static final String MOD_ID = "gamerulelib";
    public static final String MOD_NAME = "Game Rule Lib";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static <T extends GameRules.Rule<T>> BiConsumer<MinecraftServer, GameRules.Rule<T>> getGameRuleUpdatePacketSender(String name) {
        return (server, rule) -> {
            for (ServerPlayerEntity serverPlayerEntity : server.getPlayerManager().getPlayerList()) {
                ServerPlayNetworking.send(serverPlayerEntity, new GameRuleUpdateS2CPacket(name, rule));
            }
        };
    }
}
