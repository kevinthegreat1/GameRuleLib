package com.kevinthegreat.gamerulelib.impl;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;

import java.util.function.BiConsumer;

public interface GameRulesTypeAccessor<T extends GameRules.Rule<T>> {
    default BiConsumer<MinecraftServer, T> getChangeCallback() {return null;}

    default void setChangeCallback(BiConsumer<MinecraftServer, T> changeCallback) {}
}
