package com.kevinthegreat.gamerulelib;

import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.rule.DoubleRule;
import net.fabricmc.fabric.api.gamerule.v1.rule.EnumRule;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;

import java.util.function.BiConsumer;

/**
 * A utility class containing factory methods to create synced game rule types.
 * A game rule is a persisted, per server data value which may control gameplay aspects.
 *
 * <p>Some factory methods allow specification of a callback that is invoked when the value of a game rule has changed.
 * Typically, the callback is used for game rules which may influence game logic, such as {@link GameRules#DISABLE_RAIDS disabling raids}.
 *
 * <p>To register a game rule, you can use {@link GameRuleRegistry#register(String, GameRules.Category, GameRules.Type)}.
 * For example, to register a game rule that is an integer where the acceptable values are between 0 and 10, one would use the following:
 * <blockquote><pre>
 * public static final GameRules.Key&lt;GameRules.IntRule&gt; EXAMPLE_INT_RULE = GameRuleRegistry.register("exampleIntRule", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(1, 10));
 * </pre></blockquote>
 *
 * <p>To register a game rule in a custom category, {@link GameRuleRegistry#register(String, CustomGameRuleCategory, GameRules.Type)} should be used.
 *
 * @see GameRuleRegistry
 */
public final class SyncedGameRuleFactory {
    /**
     * Creates a boolean rule type.
     *
     * @param defaultValue the default value of the game rule
     * @return a boolean rule type
     */
    public static GameRules.Type<GameRules.BooleanRule> createBooleanRule(boolean defaultValue) {
        return createBooleanRule(defaultValue, (server, rule) -> {});
    }

    /**
     * Creates a boolean rule type.
     *
     * @param defaultValue the default value of the game rule
     * @param changedCallback a callback that is invoked when the value of a game rule has changed
     * @return a boolean rule type
     */
    public static GameRules.Type<GameRules.BooleanRule> createBooleanRule(boolean defaultValue, BiConsumer<MinecraftServer, GameRules.BooleanRule> changedCallback) {
        return GameRuleFactory.createBooleanRule(defaultValue, changedCallback);
    }

    /**
     * Creates an integer rule type.
     *
     * @param defaultValue the default value of the game rule
     * @return an integer rule type
     */
    public static GameRules.Type<GameRules.IntRule> createIntRule(int defaultValue) {
        return createIntRule(defaultValue, (server, rule) -> {});
    }

    /**
     * Creates an integer rule type.
     *
     * @param defaultValue the default value of the game rule
     * @param minimumValue the minimum value the game rule may accept
     * @return an integer rule type
     */
    public static GameRules.Type<GameRules.IntRule> createIntRule(int defaultValue, int minimumValue) {
        return createIntRule(defaultValue, minimumValue, Integer.MAX_VALUE, (server, rule) -> {});
    }

    /**
     * Creates an integer rule type.
     *
     * @param defaultValue the default value of the game rule
     * @param minimumValue the minimum value the game rule may accept
     * @param changedCallback a callback that is invoked when the value of a game rule has changed
     * @return an integer rule type
     */
    public static GameRules.Type<GameRules.IntRule> createIntRule(int defaultValue, int minimumValue, BiConsumer<MinecraftServer, GameRules.IntRule> changedCallback) {
        return createIntRule(defaultValue, minimumValue, Integer.MAX_VALUE, changedCallback);
    }

    /**
     * Creates an integer rule type.
     *
     * @param defaultValue the default value of the game rule
     * @param minimumValue the minimum value the game rule may accept
     * @param maximumValue the maximum value the game rule may accept
     * @return an integer rule type
     */
    public static GameRules.Type<GameRules.IntRule> createIntRule(int defaultValue, int minimumValue, int maximumValue) {
        return createIntRule(defaultValue, minimumValue, maximumValue, (server, rule) -> {});
    }

    /**
     * Creates an integer rule type.
     *
     * @param defaultValue the default value of the game rule
     * @param changedCallback a callback that is invoked when the value of a game rule has changed
     * @return an integer rule type
     */
    public static GameRules.Type<GameRules.IntRule> createIntRule(int defaultValue, BiConsumer<MinecraftServer, GameRules.IntRule> changedCallback) {
        return createIntRule(defaultValue, Integer.MIN_VALUE, Integer.MAX_VALUE, changedCallback);
    }

    /**
     * Creates an integer rule type.
     *
     * @param defaultValue the default value of the game rule
     * @param minimumValue the minimum value the game rule may accept
     * @param maximumValue the maximum value the game rule may accept
     * @param changedCallback a callback that is invoked when the value of a game rule has changed
     * @return an integer rule type
     */
    public static GameRules.Type<GameRules.IntRule> createIntRule(int defaultValue, int minimumValue, int maximumValue, BiConsumer<MinecraftServer, GameRules.IntRule> changedCallback) {
        return GameRuleFactory.createIntRule(defaultValue, minimumValue, maximumValue, changedCallback);
    }

    /**
     * Creates a double rule type.
     *
     * @param defaultValue the default value of the game rule
     * @return a double rule type
     */
    public static GameRules.Type<DoubleRule> createDoubleRule(double defaultValue) {
        return createDoubleRule(defaultValue, (server, rule) -> {});
    }

    /**
     * Creates a double rule type.
     *
     * @param defaultValue the default value of the game rule
     * @param minimumValue the minimum value the game rule may accept
     * @return a double rule type
     */
    public static GameRules.Type<DoubleRule> createDoubleRule(double defaultValue, double minimumValue) {
        return createDoubleRule(defaultValue, minimumValue, Double.MAX_VALUE, (server, rule) -> {});
    }

    /**
     * Creates a double rule type.
     *
     * @param defaultValue the default value of the game rule
     * @param minimumValue the minimum value the game rule may accept
     * @param changedCallback a callback that is invoked when the value of a game rule has changed
     * @return a double rule type
     */
    public static GameRules.Type<DoubleRule> createDoubleRule(double defaultValue, double minimumValue, BiConsumer<MinecraftServer, DoubleRule> changedCallback) {
        return createDoubleRule(defaultValue, minimumValue, Double.MAX_VALUE, changedCallback);
    }

    /**
     * Creates a double rule type.
     *
     * @param defaultValue the default value of the game rule
     * @param minimumValue the minimum value the game rule may accept
     * @param maximumValue the maximum value the game rule may accept
     * @return a double rule type
     */
    public static GameRules.Type<DoubleRule> createDoubleRule(double defaultValue, double minimumValue, double maximumValue) {
        return createDoubleRule(defaultValue, minimumValue, maximumValue, (server, rule) -> {});
    }

    /**
     * Creates a double rule type.
     *
     * @param defaultValue the default value of the game rule
     * @param changedCallback a callback that is invoked when the value of a game rule has changed
     * @return a double rule type
     */
    public static GameRules.Type<DoubleRule> createDoubleRule(double defaultValue, BiConsumer<MinecraftServer, DoubleRule> changedCallback) {
        return createDoubleRule(defaultValue, Double.MIN_VALUE, Double.MAX_VALUE, changedCallback);
    }

    /**
     * Creates a double rule type.
     *
     * @param defaultValue the default value of the game rule
     * @param minimumValue the minimum value the game rule may accept
     * @param maximumValue the maximum value the game rule may accept
     * @param changedCallback a callback that is invoked when the value of a game rule has changed
     * @return a double rule type
     */
    public static GameRules.Type<DoubleRule> createDoubleRule(double defaultValue, double minimumValue, double maximumValue, BiConsumer<MinecraftServer, DoubleRule> changedCallback) {
        return GameRuleFactory.createDoubleRule(defaultValue, minimumValue, maximumValue, changedCallback);
    }

    /**
     * Creates an enum rule type.
     *
     * <p>All enum values are supported.
     *
     * @param defaultValue the default value of the game rule
     * @param <E> the type of enum this game rule stores
     * @return an enum rule type
     */
    public static <E extends Enum<E>> GameRules.Type<EnumRule<E>> createEnumRule(E defaultValue) {
        return createEnumRule(defaultValue, (server, rule) -> {});
    }

    /**
     * Creates an enum rule type.
     *
     * <p>All enum values are supported.
     *
     * @param defaultValue the default value of the game rule
     * @param changedCallback a callback that is invoked when the value of a game rule has changed
     * @param <E> the type of enum this game rule stores
     * @return an enum rule type
     */
    public static <E extends Enum<E>> GameRules.Type<EnumRule<E>> createEnumRule(E defaultValue, BiConsumer<MinecraftServer, EnumRule<E>> changedCallback) {
        return createEnumRule(defaultValue, defaultValue.getDeclaringClass().getEnumConstants(), changedCallback);
    }

    /**
     * Creates an enum rule type.
     *
     * @param defaultValue the default value of the game rule
     * @param supportedValues the values the game rule may support
     * @param <E> the type of enum this game rule stores
     * @return an enum rule type
     */
    public static <E extends Enum<E>> GameRules.Type<EnumRule<E>> createEnumRule(E defaultValue, E[] supportedValues) {
        return createEnumRule(defaultValue, supportedValues, (server, rule) -> {});
    }

    /**
     * Creates an enum rule type.
     *
     * @param defaultValue the default value of the game rule
     * @param supportedValues the values the game rule may support
     * @param changedCallback a callback that is invoked when the value of a game rule has changed.
     * @param <E> the type of enum this game rule stores
     * @return an enum rule type
     */
    public static <E extends Enum<E>> GameRules.Type<EnumRule<E>> createEnumRule(E defaultValue, E[] supportedValues, BiConsumer<MinecraftServer, EnumRule<E>> changedCallback) {
        return GameRuleFactory.createEnumRule(defaultValue, supportedValues, changedCallback);
    }

    private SyncedGameRuleFactory() {}
}
