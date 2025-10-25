package revvilo.responsiveknockback.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.ServerChunkCache;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import revvilo.responsiveknockback.ResponsiveKnockback;

@Mixin(ServerChunkCache.class)
public class RemoveTrackerTickMixin {
	@WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ChunkMap;tick()V"))
	public void removeCall(ChunkMap instance, Operation<Void> original) {
		ResponsiveKnockback.TRACKER_TICK.set(() -> original.call(instance));
	}
}