/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.ctrlaltmilk.asr.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.function.Supplier;

public class ASRConfig {
    public final Supplier<Boolean> disableAccessibilityOnboarding;
    public final Supplier<Boolean> disableMultiplayerWarning;
    public final Supplier<Boolean> skipTutorial;
    public final Supplier<Boolean> disableRecipeBook;
    public final Supplier<Boolean> skipExperimentalWarning;

    public ASRConfig(ModConfigSpec.Builder builder) {
        disableAccessibilityOnboarding = builder
                .comment(" Whether to disable the initial accessibility onboarding screen")
                .translation("config.asr.disable_accessibility_onboarding")
                .define("disableAccessibilityOnboarding", true);

        disableMultiplayerWarning = builder
                .comment(" Whether to disable the warning before joining a multiplayer server")
                .translation("config.asr.disable_multiplayer_warning")
                .define("disableMultiplayerWarning", true);

        skipTutorial = builder
                .comment(" Whether to skip the ingame tutorial toasts")
                .translation("config.asr.skip_tutorial")
                .define("skipTutorial", true);

        disableRecipeBook = builder
                .comment(" Whether to disable the recipe book in crafting GUIs")
                .translation("config.asr.disable_recipe_book")
                .define("disableRecipeBook", true);

        skipExperimentalWarning = builder
                .comment(" Whether to skip the experimental features warning when creating or joining a world")
                .translation("config.asr.skip_experimental_warning")
                .define("skipExperimentalWarning", true);
    }
}
