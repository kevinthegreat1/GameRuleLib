package com.kevinthegreat.gamerulelib.impl;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;

import java.util.function.BiConsumer;

public interface GameRulesTypeAccessor {
    default <T extends GameRules.Rule<T>> BiConsumer<MinecraftServer, T> getChangeCallback() {return null;}

    default <T extends GameRules.Rule<T>> void setChangeCallback(BiConsumer<MinecraftServer, T> changeCallback) {}
}
