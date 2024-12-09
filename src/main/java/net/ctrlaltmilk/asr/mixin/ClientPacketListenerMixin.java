/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.ctrlaltmilk.asr.mixin;

import net.ctrlaltmilk.asr.AnnoyingStuffRemover;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.world.item.crafting.Recipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientPacketListener.class)
public abstract class ClientPacketListenerMixin {
    @Redirect(method = "lambda$handleAddOrRemoveRecipes$9", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/crafting/Recipe;showNotification()Z"))
    boolean modifyShowNotification(Recipe<?> self) {
        if (AnnoyingStuffRemover.CONFIG.DISABLE_RECIPE_BOOK.get()) {
            return false;
        } else {
            return self.showNotification();
        }
    }
}
