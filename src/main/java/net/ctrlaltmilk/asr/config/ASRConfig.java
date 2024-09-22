/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.ctrlaltmilk.asr.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

public class ASRConfig {
    public final Supplier<Boolean> DISABLE_ACCESSIBILITY_ONBOARDING;
    public final Supplier<Boolean> DISABLE_MULTIPLAYER_WARNING;
    public final Supplier<Boolean> SKIP_TUTORIAL;
    public final Supplier<Boolean> DISABLE_RECIPE_BOOK;

    public ASRConfig(ForgeConfigSpec.Builder builder) {
        builder.comment(" Whether to disable the initial accessibility onboarding screen");
        DISABLE_ACCESSIBILITY_ONBOARDING = builder.define("disableAccessibilityOnboarding", true);

        builder.comment(" Whether to disable the warning before joining a multiplayer server");
        DISABLE_MULTIPLAYER_WARNING = builder.define("disableMultiplayerWarning", true);

        builder.comment(" Whether to skip the ingame tutorial toasts");
        SKIP_TUTORIAL = builder.define("skipTutorial", true);

        builder.comment(" Whether to disable the recipe book in crafting GUIs");
        DISABLE_RECIPE_BOOK = builder.define("disableRecipeBook", true);
    }
}
