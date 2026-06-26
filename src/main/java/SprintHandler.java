// No package declaration — default package so this class can access runtime obfuscated
// default-package classes (vq, hu, afu, yw) directly. Named-package Java code cannot
// import or reference default-package classes.

import com.rorysmod.utilities.config.ModConfig;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

import java.util.EnumSet;

// Runtime obfuscated name mapping (confirmed by javap on minecraft-1.2.5-client.jar):
//   Minecraft.h  = thePlayer        (type vq = EntityClientPlayerMP)
//   Minecraft.f  = theWorld         (type xd = World)
//   Minecraft.s  = currentScreen    (type vp = GuiScreen, null when no screen open)
//   Minecraft.A  = gameSettings     (type hu = GameSettings)
//   hu.n         = keyBindForward   (type afu = KeyBinding)
//   afu.e        = pressed          (boolean)
public class SprintHandler implements ITickHandler {

    private final ModConfig config;

    public SprintHandler(ModConfig config) {
        this.config = config;
    }

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {
        if (!config.isCtrlSprintEnabled()) return;

        Minecraft mc = FMLClientHandler.instance().getClient();

        // Fields are Object in the stub; cast to actual runtime types here.
        if (mc == null || mc.h == null || mc.f == null) return;
        if (mc.s != null) return; // screen open — suppress sprint

        vq player = (vq) mc.h;
        hu gs     = (hu) mc.A;

        boolean sprintKeyDown = Keyboard.isKeyDown(config.getSprintKeyCode());
        boolean movingForward = gs.n.e;

        CtrlSprint.tick(player, sprintKeyDown, movingForward);
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {}

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.GAME);
    }

    @Override
    public String getLabel() {
        return "RorysUtilities_SprintHandler";
    }
}
