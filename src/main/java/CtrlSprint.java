// No package declaration — default package so this class can reference vq (EntityClientPlayerMP)
// and call its inherited methods from yw (EntityPlayer) / nn (Entity).
//
// Runtime obfuscated method mapping (confirmed by javap on minecraft-1.2.5-client.jar):
//   vq.W()         = isSprinting()        (defined in nn/Entity, flag index 3)
//   vq.d(boolean)  = setSprinting(bool)   (defined in nn/Entity, flag index 3)
//   vq.V()         = isSneaking()         (defined in nn/Entity, flag index 1)
public final class CtrlSprint {

    private CtrlSprint() {}

    /**
     * Called each game tick. Returns the updated ctrlSprintActive flag.
     *
     * Only forces sprint ON when ctrlSprintActive becomes true.
     * Only forces sprint OFF when ctrlSprintActive transitions from true to false,
     * so vanilla double-W sprint is never interrupted.
     */
    public static boolean tick(vq player,
                               boolean sprintKeyPressedThisTick,
                               boolean ctrlSprintActive,
                               boolean movingForward,
                               boolean screenOpen) {
        boolean wasActive = ctrlSprintActive;

        // Activate on a fresh key-press edge while the conditions are met
        if (sprintKeyPressedThisTick && movingForward && !screenOpen && !player.V()) {
            ctrlSprintActive = true;
        }

        // Cancel our sprint when any stop condition is met
        if (!movingForward || screenOpen || player.V()) {
            ctrlSprintActive = false;
        }

        if (ctrlSprintActive && !player.W()) {
            player.d(true);
        } else if (wasActive && !ctrlSprintActive && player.W()) {
            // We activated sprint and now our condition cleared — stop it.
            // If the player is sprinting for vanilla reasons (double-W) and
            // ctrlSprintActive was already false, we never reach this branch.
            player.d(false);
        }

        return ctrlSprintActive;
    }
}
