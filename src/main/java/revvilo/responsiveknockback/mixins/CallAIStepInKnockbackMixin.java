package revvilo.responsiveknockback.mixins;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class CallAIStepInKnockbackMixin {
    @Shadow public abstract void aiStep();

    @Inject(method = "knockback", at = @At("TAIL"), cancellable = true)
    private void RamAIStepCallIntoKnockbackFunction(double strength, double x, double z, CallbackInfo ci) {
        if(!ci.isCancelled()) {
            this.aiStep();
        }
    }
}
