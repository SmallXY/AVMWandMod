package net.lanternmc.avmwandmod.Command;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.lanternmc.avmwandmod.NBT.NBTManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class CmdGUI extends LightweightGuiDescription {

    public CmdGUI(PlayerEntity player) {
        WPlainPanel panel = new WPlainPanel();
        panel.setInsets(Insets.ROOT_PANEL);

        WTextField inPut = new WTextField(Text.of("/say hello"));
        panel.add(inPut, 0 ,0);

        WButton button = new WButton(Text.of("确认键入"));

        button.setOnClick(new Runnable() {
            @Override
            public void run() {
                NBTManager.data.put(player,inPut.getText());
                NBTManager.GenNBT(player, player.getMainHandStack());
            }
        });

//        () -> {new CmdRunnable(player)
//            assert MinecraftClient.getInstance().player != null;
//            MinecraftClient.getInstance().player.sendMessage(Text.of("- " + inPut.getText()));
//            MinecraftClient.getInstance().player.sendMessage(Text.of("- " + inPut.getSelection()));
//            MinecraftClient.getInstance().player.sendMessage(Text.of("- " + inPut.getSuggestion()));
//            MinecraftClient.getInstance().player.sendMessage(Text.of("X- " + inPut.getX()));
//            MinecraftClient.getInstance().player.sendMessage(Text.of("Height- " + inPut.getHeight()));
//            MinecraftClient.getInstance().player.sendMessage(Text.of("Width- " + inPut.getWidth()));
//            MinecraftClient.getInstance().player.sendMessage(Text.of("Y- " + inPut.getY()));
//        }

        panel.add(button, 0,20);

        setFullscreen(true);
        setRootPanel(panel);
    }

}
