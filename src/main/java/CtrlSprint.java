// No package declaration — default package so this class can reference vq (EntityClientPlayerMP)
// and call its inherited methods from yw (EntityPlayer) / nn (Entity).
//
// Runtime obfuscated method mapping (confirmed by javap on minecraft-1.2.5-client.jar):
//   vq.W()         = isSprinting()        (defined in nn/Entity, flag index 3)
//   vq.d(boolean)  = setSprinting(bool)   (defined in nn/Entity, flag index 3)
//   vq.V()         = isSneaking()         (defined in nn/Entity, flag index 1)
public final class CtrlSprint {

    private CtrlSprint() {}

    public static void tick(vq player, boolean sprintKeyDown, boolean movingForward) {
        if (sprintKeyDown && movingForward) {
            if (!player.W() && canSprint(player)) {
                player.d(true);
            }
        } else {
            if (player.W()) {
                player.d(false);
            }
        }
    }

    private static boolean canSprint(vq player) {
        return !player.V(); // isSneaking
    }
}
