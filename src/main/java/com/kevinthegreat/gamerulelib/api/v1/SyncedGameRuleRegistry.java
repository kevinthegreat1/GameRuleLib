package com.kevinthegreat.gamerulelib.api.v1;

import com.kevinthegreat.gamerulelib.impl.GameRuleLib;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import it.unimi.dsi.fastutil.objects.ObjectSets;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

import java.util.Set;

/**
 * A utility class which allows for registration of synced game rules.
 * Note game rules with duplicate keys are not allowed.
 * Checking if a game rule key is already synced can be done using {@link SyncedGameRuleRegistry#isSynced(String)}.
 * Checking if a game rule key is already taken can be done using {@link GameRuleRegistry#hasRegistration(String)}.
 *
 * <p>Creation of rule types is done using {@link GameRuleFactory}.
 *
 * @apiNote The {@link GameRules.Type#changeCallback} of the rule type will be called with {@code server} as {@code null} on the client side.
 *
 * @see GameRuleFactory
 */
@SuppressWarnings("JavadocReference")
public class SyncedGameRuleRegistry {
    private static final ObjectSet<String> SYNCED_GAME_RULES = new ObjectOpenHashSet<>();

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
     *
     * @apiNote The {@link GameRules.Type#changeCallback} of the rule type will be called with {@code server} as {@code null} on the client side.
     */
    public static <T extends GameRules.Rule<T>> GameRules.Key<T> register(String name, GameRules.Category category, GameRules.Type<T> type) {
        SYNCED_GAME_RULES.add(name);
        type.setChangeCallback(type.getChangeCallback().andThen(GameRuleLib.getGameRuleUpdatePacketSender(name)));
        return GameRuleRegistry.register(name, category, type);
    }

    /**
     * Registers a synced {@link GameRules.Rule} with a custom category.
     *
     * @param name    the name of the rule
     * @param category the category of this rule
     * @param type the rule type
     * @param <T>  the type of rule
     * @return a rule key which can be used to query the value of the rule
     * @throws IllegalStateException if a rule of the same name already exists
     *
     * @apiNote The {@link GameRules.Type#changeCallback} of the rule type will be called with {@code server} as {@code null} on the client side.
     */
    public static <T extends GameRules.Rule<T>> GameRules.Key<T> register(String name, CustomGameRuleCategory category, GameRules.Type<T> type) {
        SYNCED_GAME_RULES.add(name);
        type.setChangeCallback(type.getChangeCallback().andThen(GameRuleLib.getGameRuleUpdatePacketSender(name)));
        return GameRuleRegistry.register(name, category, type);
    }

    /**
     * Gets all the synced game rules.
     * @return an unmodifiable set of the synced game rule names
     */
    public static Set<String> getSyncedGameRules() {
        return ObjectSets.unmodifiable(SYNCED_GAME_RULES);
    }

    /**
     * Checks if a name for a game rule is already synced.
     *
     * @param name the rule name to test
     * @return true if the name is synced.
     */
    public static boolean isSynced(String name) {
        return SYNCED_GAME_RULES.contains(name);
    }
}
