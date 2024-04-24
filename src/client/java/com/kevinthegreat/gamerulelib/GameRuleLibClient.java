package com.kevinthegreat.gamerulelib;

import com.kevinthegreat.gamerulelib.impl.GameRuleLib;
import com.kevinthegreat.gamerulelib.impl.GameRuleUpdateS2CPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.GameRules;

public class GameRuleLibClient implements ClientModInitializer {
    @SuppressWarnings("unchecked")
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(GameRuleUpdateS2CPacket.PACKET_ID, (payload, context) ->
                MinecraftClient.getInstance().execute(() -> {
                    @SuppressWarnings({"DataFlowIssue", "rawtypes", "resource"})
                    GameRules.Rule rule = context.client().world.getGameRules().get(new GameRules.Key(payload.name(), null));
                    rule.invokeDeserialize(payload.value());
                    rule.getType().getChangeCallback().accept(null, rule);
                })
        );
        GameRuleLib.LOGGER.info(GameRuleLib.MOD_NAME + " client initialized");
    }
}
