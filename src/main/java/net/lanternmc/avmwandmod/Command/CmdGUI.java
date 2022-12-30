package net.lanternmc.avmwandmod.Command;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.lanternmc.avmwandmod.NBT.CmdRunnable;
import net.minecraft.entity.player.PlayerEntity;

public class CmdGUI extends LightweightGuiDescription {

    public CmdGUI(PlayerEntity player) {
        WPlainPanel panel = new WPlainPanel();
        panel.setInsets(Insets.ROOT_PANEL);

        WTextField inPut = new WTextField();
        inPut.setSize(500, 100);
        panel.add(inPut, 5,5);
        WButton button = new WButton();
        button.setOnClick(new CmdRunnable(player, inPut.getText()));
        button.setSize(100, 100);
        panel.add(button,0,10);

        setFullscreen(true);
        setRootPanel(panel);
    }

}
