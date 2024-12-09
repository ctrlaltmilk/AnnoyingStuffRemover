package net.ctrlaltmilk.asr.mixin;

import net.ctrlaltmilk.asr.AnnoyingStuffRemover;
import net.minecraft.client.gui.components.toasts.RecipeToast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.world.item.crafting.Recipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RecipeToast.class)
public abstract class RecipeToastMixin {
    @Inject(method = "addOrUpdate", at = @At("HEAD"), cancellable = true)
    private static void modifyAddOrUpdate(ToastComponent component, Recipe<?> recipe, CallbackInfo ci) {
        if (AnnoyingStuffRemover.CONFIG.DISABLE_RECIPE_BOOK.get()) {
            ci.cancel();
        }
    }
}
