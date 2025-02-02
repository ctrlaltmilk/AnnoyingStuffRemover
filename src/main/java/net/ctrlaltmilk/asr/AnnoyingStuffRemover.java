/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.ctrlaltmilk.asr;

import net.ctrlaltmilk.asr.config.ASRConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.ModConfigSpec;

@Mod(value = AnnoyingStuffRemover.MOD_ID, dist = Dist.CLIENT)
public class AnnoyingStuffRemover {
    public static final String MOD_ID = "asr";

    public static final ASRConfig CONFIG;
    public static final IConfigSpec CONFIG_SPEC;

    static {
        var configPair = new ModConfigSpec.Builder().configure(ASRConfig::new);
        CONFIG = configPair.getLeft();
        CONFIG_SPEC = configPair.getRight();
    }

    public AnnoyingStuffRemover(ModContainer container) {
        container.registerConfig(ModConfig.Type.CLIENT, CONFIG_SPEC);

        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
