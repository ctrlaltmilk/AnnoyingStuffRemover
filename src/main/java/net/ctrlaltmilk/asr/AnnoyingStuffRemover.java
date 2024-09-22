/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.ctrlaltmilk.asr;

import net.ctrlaltmilk.asr.config.ASRConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.util.function.Function;

@Mod(AnnoyingStuffRemover.MOD_ID)
public class AnnoyingStuffRemover {
    public static final String MOD_ID = "asr";

    public static final ASRConfig CONFIG = registerConfig(ModConfig.Type.CLIENT, ASRConfig::new);

    private static <C> C registerConfig(ModConfig.Type type, Function<ForgeConfigSpec.Builder, C> configConstructor) {
        var configPair = new ForgeConfigSpec.Builder().configure(configConstructor);
        ModLoadingContext.get().registerConfig(type, configPair.getRight());
        return configPair.getLeft();
    }
}
