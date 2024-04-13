package com.kevinthegreat.gamerulelib.impl;

public interface GameRulesRuleAccessor {
    default void invokeDeserialize(String value) {}
}
