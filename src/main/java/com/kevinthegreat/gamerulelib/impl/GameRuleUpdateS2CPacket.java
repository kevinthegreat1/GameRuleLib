package com.kevinthegreat.gamerulelib.impl;

import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketType;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;

public record GameRuleUpdateS2CPacket(String name, String value) implements FabricPacket {
    public static final PacketType<GameRuleUpdateS2CPacket> TYPE = PacketType.create(Identifier.of(GameRuleLib.MOD_ID, "game_rule_update"), GameRuleUpdateS2CPacket::new);

    public GameRuleUpdateS2CPacket(String name, GameRules.Rule<?> rule) {
        this(name, rule.serialize());
    }

    public GameRuleUpdateS2CPacket(PacketByteBuf buf) {
        this(buf.readString(), buf.readString());
    }

    @Override
    public void write(PacketByteBuf buf) {
        buf.writeString(name);
        buf.writeString(value);
    }

    @Override
    public PacketType<?> getType() {
        return TYPE;
    }
}
