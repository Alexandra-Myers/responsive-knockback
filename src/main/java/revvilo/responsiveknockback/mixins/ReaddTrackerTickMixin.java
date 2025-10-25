package revvilo.responsiveknockback.mixins;

import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import revvilo.responsiveknockback.ResponsiveKnockback;

import java.util.function.BooleanSupplier;

@Mixin(ServerLevel.class)
public abstract class ReaddTrackerTickMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    public void runSyncDelayed(BooleanSupplier hasTimeLeft, CallbackInfo ci) {
        ResponsiveKnockback.TRACKER_TICK.getAndSet(ResponsiveKnockback.DO_NOTHING).run();
    }
}
