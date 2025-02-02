/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.ctrlaltmilk.asr.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.function.Supplier;

public class ASRConfig {
    public final Supplier<Boolean> DISABLE_ACCESSIBILITY_ONBOARDING;
    public final Supplier<Boolean> DISABLE_MULTIPLAYER_WARNING;
    public final Supplier<Boolean> SKIP_TUTORIAL;
    public final Supplier<Boolean> DISABLE_RECIPE_BOOK;

    public ASRConfig(ModConfigSpec.Builder builder) {
        DISABLE_ACCESSIBILITY_ONBOARDING = builder
                .comment(" Whether to disable the initial accessibility onboarding screen")
                .translation("config.asr.disable_accessibility_onboarding")
                .define("disableAccessibilityOnboarding", true);

        DISABLE_MULTIPLAYER_WARNING = builder
                .comment(" Whether to disable the warning before joining a multiplayer server")
                .translation("config.asr.disable_multiplayer_warning")
                .define("disableMultiplayerWarning", true);

        SKIP_TUTORIAL = builder
                .comment(" Whether to skip the ingame tutorial toasts")
                .translation("config.asr.skip_tutorial")
                .define("skipTutorial", true);

        DISABLE_RECIPE_BOOK = builder
                .comment(" Whether to disable the recipe book in crafting GUIs")
                .translation("config.asr.disable_recipe_book")
                .define("disableRecipeBook", true);
    }
}
