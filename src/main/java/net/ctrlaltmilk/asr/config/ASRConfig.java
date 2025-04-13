/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.ctrlaltmilk.asr.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

public class ASRConfig {
    public final Supplier<Boolean> disableAccessibilityOnboarding;
    public final Supplier<Boolean> disableMultiplayerWarning;
    public final Supplier<Boolean> skipTutorial;
    public final Supplier<Boolean> disableRecipeBook;
    public final Supplier<Boolean> skipExperimentalWarning;

    public ASRConfig(ForgeConfigSpec.Builder builder) {
        builder.comment(" Whether to disable the initial accessibility onboarding screen");
        disableAccessibilityOnboarding = builder.define("disableAccessibilityOnboarding", true);

        builder.comment(" Whether to disable the warning before joining a multiplayer server");
        disableMultiplayerWarning = builder.define("disableMultiplayerWarning", true);

        builder.comment(" Whether to skip the ingame tutorial toasts");
        skipTutorial = builder.define("skipTutorial", true);

        builder.comment(" Whether to disable the recipe book in crafting GUIs");
        disableRecipeBook = builder.define("disableRecipeBook", true);

        builder.comment(" Whether to skip the experimental features warning when creating or joining a world");
        skipExperimentalWarning = builder.define("skipExperimentalWarning", true);
    }
}
