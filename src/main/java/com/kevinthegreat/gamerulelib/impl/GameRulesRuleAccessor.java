package com.kevinthegreat.gamerulelib.impl;

import net.minecraft.world.GameRules;

public interface GameRulesRuleAccessor<T extends GameRules.Rule<T>> {
    default GameRules.Type<T> getType() {return null;}

    default void invokeDeserialize(String value) {}
}
