package com.kevinthegreat.gamerulelib.impl;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;

public record GameRuleUpdateS2CPacket(String name, String value) implements CustomPayload {
    public static final CustomPayload.Id<GameRuleUpdateS2CPacket> PACKET_ID = new CustomPayload.Id<>(new Identifier(GameRuleLib.MOD_ID, "game_rule_update"));
    public static final PacketCodec<RegistryByteBuf, GameRuleUpdateS2CPacket> PACKET_CODEC = PacketCodec.tuple(PacketCodecs.STRING, GameRuleUpdateS2CPacket::name, PacketCodecs.STRING, GameRuleUpdateS2CPacket::value, GameRuleUpdateS2CPacket::new);

    public GameRuleUpdateS2CPacket(String name, GameRules.Rule<?> rule) {
        this(name, rule.serialize());
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return PACKET_ID;
    }
}
