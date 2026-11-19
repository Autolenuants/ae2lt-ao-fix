package com.moakiee.ae2ltaofix.mixin;

import net.minecraft.client.renderer.block.model.BakedQuad;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "com.moakiee.ae2lt.client.ctm.CtmFaceGeometry", remap = false)
public final class CtmFaceGeometryMixin {

    @Inject(method = "quad", at = @At("RETURN"), cancellable = true, remap = false)
    private static void ae2ltAoFix$enableAmbientOcclusion(CallbackInfoReturnable<BakedQuad> cir) {
        BakedQuad quad = cir.getReturnValue();
        if (quad != null && !quad.hasAmbientOcclusion()) {
            cir.setReturnValue(new BakedQuad(
                    quad.getVertices(),
                    quad.getTintIndex(),
                    quad.getDirection(),
                    quad.getSprite(),
                    quad.isShade(),
                    true));
        }
    }
}
