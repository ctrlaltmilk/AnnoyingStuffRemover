/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.ctrlaltmilk.asr.mixin;

import net.ctrlaltmilk.asr.AnnoyingStuffRemover;
import net.minecraft.client.Minecraft;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.client.tutorial.TutorialSteps;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Tutorial.class)
public abstract class TutorialMixin {
    @Shadow @Final private Minecraft minecraft;

    @Inject(method = "start", at = @At("HEAD"))
    void modifyTutorialStep(CallbackInfo ci) {
        if (AnnoyingStuffRemover.CONFIG.SKIP_TUTORIAL.get()) {
            minecraft.options.tutorialStep = TutorialSteps.NONE;
            minecraft.options.save();
        }
    }
}
