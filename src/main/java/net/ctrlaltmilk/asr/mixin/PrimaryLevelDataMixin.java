/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.ctrlaltmilk.asr.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.ctrlaltmilk.asr.AnnoyingStuffRemover;
import net.minecraft.world.level.storage.PrimaryLevelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PrimaryLevelData.class)
public abstract class PrimaryLevelDataMixin {
    @ModifyReturnValue(method = "hasConfirmedExperimentalWarning", at = @At("RETURN"))
    boolean overrideExperimentalWarning(boolean original) {
        return AnnoyingStuffRemover.CONFIG.skipExperimentalWarning.get() ? true : original;
    }
}
