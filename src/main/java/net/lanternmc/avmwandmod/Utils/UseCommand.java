package net.lanternmc.avmwandmod.Utils;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;

public class UseCommand {


    public static void init(PlayerEntity p, String  s) {
        if (s.startsWith("/")) {
            ((ClientPlayerEntity) p).networkHandler.sendChatCommand(s.replace("/", ""));
        } else {
            ((ClientPlayerEntity) p).networkHandler.sendChatCommand(s);
        }
    }

}
