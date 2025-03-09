/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.ctrlaltmilk.asr.mixin;

import net.ctrlaltmilk.asr.AnnoyingStuffRemover;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractRecipeBookScreen.class)
public abstract class AbstractRecipeBookScreenMixin extends Screen {
    protected AbstractRecipeBookScreenMixin(Component title) {
        super(title);
    }

    @Redirect(method = "initButton", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/inventory/AbstractRecipeBookScreen;addRenderableWidget(Lnet/minecraft/client/gui/components/events/GuiEventListener;)Lnet/minecraft/client/gui/components/events/GuiEventListener;"))
    protected <T extends GuiEventListener & Renderable & NarratableEntry> T modifyAddRenderableWidget(AbstractRecipeBookScreen<?> instance, T widget) {
        if (AnnoyingStuffRemover.CONFIG.DISABLE_RECIPE_BOOK.get()) {
            return null;
        } else {
            return addRenderableWidget(widget);
        }
    }
}
