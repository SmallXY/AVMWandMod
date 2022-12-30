package net.lanternmc.avmwandmod.NBT;

import net.minecraft.entity.player.PlayerEntity;

public class CmdRunnable implements Runnable {

    private final PlayerEntity player;
    private final String command;

    public CmdRunnable(PlayerEntity p, String command) {
        this.player = p;
        this.command = command;
    }

    @Override
    public void run() {
        NBTManager.GenNBT(command, player.getMainHandStack());
    }

}
