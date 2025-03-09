/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.ctrlaltmilk.asr.mixin;

import net.ctrlaltmilk.asr.AnnoyingStuffRemover;
import net.minecraft.client.gui.components.toasts.RecipeToast;
import net.minecraft.client.gui.components.toasts.ToastManager;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RecipeToast.class)
public abstract class RecipeToastMixin {
    @Inject(method = "addOrUpdate", at = @At("HEAD"), cancellable = true)
    private static void modifyAddOrUpdate(ToastManager manager, RecipeDisplay recipeDisplay, CallbackInfo ci) {
        if (AnnoyingStuffRemover.CONFIG.DISABLE_RECIPE_BOOK.get()) {
            ci.cancel();
        }
    }
}
