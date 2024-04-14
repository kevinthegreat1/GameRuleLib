package com.kevinthegreat.gamerulelib.mixin;

import com.kevinthegreat.gamerulelib.impl.GameRulesTypeAccessor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.function.BiConsumer;

@Mixin(GameRules.Type.class)
public interface GameRulesTypeAccessorMixin<T extends GameRules.Rule<T>> extends GameRulesTypeAccessor<T> {
    @Accessor
    @Override
    BiConsumer<MinecraftServer, T> getChangeCallback();

    @Mutable
    @Accessor
    @Override
    void setChangeCallback(BiConsumer<MinecraftServer, T> changeCallback);
}
