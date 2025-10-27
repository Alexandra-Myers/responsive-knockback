package revvilo.responsiveknockback;

import net.neoforged.fml.common.Mod;

import java.util.concurrent.atomic.AtomicReference;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ResponsiveKnockback.MODID)
public class ResponsiveKnockback
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "responsiveknockback";
    public static final Runnable DO_NOTHING = () -> {};
    public static final AtomicReference<Runnable> TRACKER_TICK = new AtomicReference<>(DO_NOTHING);
}