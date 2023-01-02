package net.lanternmc.avmwandmod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.lanternmc.avmwandmod.AVMWandMod;
import net.lanternmc.avmwandmod.Command.CmdGUI;
import net.lanternmc.avmwandmod.Command.CmdScreen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class AVMWandModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding("Show Debug Menu", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_B,"Debug Menu"));
//        HandledScreens.<BianXie, ExampleBlockScreen>register(MyMod.SCREEN_HANDLER_TYPE, (gui, inventory, title) -> new ExampleBlockScreen(gui, inventory.player, title));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                if (client.player != null) {
                    if (client.player.getMainHandStack().getItem() == AVMWandMod.AVM_WAND_CB
                            || client.player.getMainHandStack().getItem() == AVMWandMod.AVM_WAND_LCB) {
                        client.setScreen(new CmdScreen(new CmdGUI(client.player)));
                    }
                }
            }
        });
    }
}
