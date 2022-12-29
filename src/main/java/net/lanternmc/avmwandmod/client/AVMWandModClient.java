package net.lanternmc.avmwandmod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lanternmc.avmwandmod.Command.BianXie;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registry;

@Environment(EnvType.CLIENT)
public class AVMWandModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
//        HandledScreens.<BianXie, ExampleBlockScreen>register(MyMod.SCREEN_HANDLER_TYPE, (gui, inventory, title) -> new ExampleBlockScreen(gui, inventory.player, title));
    }
}
