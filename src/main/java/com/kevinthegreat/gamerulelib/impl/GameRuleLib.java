package com.kevinthegreat.gamerulelib.impl;

import com.kevinthegreat.gamerulelib.api.v1.SyncedGameRuleRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiConsumer;

public class GameRuleLib implements ModInitializer {
    public static final String MOD_ID = "gamerulelib";
    public static final String MOD_NAME = "Game Rule Lib";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static <T extends GameRules.Rule<T>> BiConsumer<MinecraftServer, GameRules.Rule<T>> getGameRuleUpdatePacketSender(String name) {
        return (server, rule) -> {
            if (server != null) {
                for (ServerPlayerEntity serverPlayerEntity : server.getPlayerManager().getPlayerList()) {
                    ServerPlayNetworking.send(serverPlayerEntity, new GameRuleUpdateS2CPacket(name, rule));
                }
            }
        };
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void onInitialize() {
        PayloadTypeRegistry.playS2C().register(GameRuleUpdateS2CPacket.PACKET_ID, GameRuleUpdateS2CPacket.PACKET_CODEC);
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            for (String name : SyncedGameRuleRegistry.getSyncedGameRules()) {
                ServerPlayNetworking.send(handler.player, new GameRuleUpdateS2CPacket(name, server.getGameRules().get(new GameRules.Key(name, null))));
            }
        });
        LOGGER.info(MOD_NAME + " initialized");
    }
}
