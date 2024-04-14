package com.kevinthegreat.gamerulelib.mixin.client;

import com.kevinthegreat.gamerulelib.impl.GameRulesRuleAccessor;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRules.Rule.class)
public interface GameRulesRuleAccessorMixin<T extends GameRules.Rule<T>> extends GameRulesRuleAccessor<T> {
    @Accessor
    @Override
    GameRules.Type<T> getType();

    @Invoker
    @Override
    void invokeDeserialize(String value);
}
