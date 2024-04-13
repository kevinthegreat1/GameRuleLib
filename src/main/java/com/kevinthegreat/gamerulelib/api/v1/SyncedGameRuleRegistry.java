package com.kevinthegreat.gamerulelib.api.v1;

import com.kevinthegreat.gamerulelib.impl.GameRuleLib;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class SyncedGameRuleRegistry {
    private SyncedGameRuleRegistry() {}

    /**
     * Registers a synced {@link GameRules.Rule}.
     *
     * @param name   the name of the rule
     * @param category the category of this rule
     * @param type the rule type
     * @param <T>  the type of rule
     * @return a rule key which can be used to query the value of the rule
     * @throws IllegalStateException if a rule of the same name already exists
     */
    public static <T extends GameRules.Rule<T>> GameRules.Key<T> register(String name, GameRules.Category category, GameRules.Type<T> type) {
        type.setChangeCallback(type.getChangeCallback().andThen(GameRuleLib.getGameRuleUpdatePacketSender(name)));
        return GameRuleRegistry.register(name, category, type);
    }

    /**
     * Registers a synced {@link GameRules.Rule} with a custom category.
     *
     * @param name 	the name of the rule
     * @param category the category of this rule
     * @param type the rule type
     * @param <T>  the type of rule
     * @return a rule key which can be used to query the value of the rule
     * @throws IllegalStateException if a rule of the same name already exists
     */
    public static <T extends GameRules.Rule<T>> GameRules.Key<T> register(String name, CustomGameRuleCategory category, GameRules.Type<T> type) {
        type.setChangeCallback(type.getChangeCallback().andThen(GameRuleLib.getGameRuleUpdatePacketSender(name)));
        return GameRuleRegistry.register(name, category, type);
    }
}
