package net.lanternmc.avmwandmod.Resourcepack;

import net.minecraft.client.resource.DefaultClientResourcePackProvider;

import java.nio.file.Path;

public class Test {

    public void init() {
        DefaultClientResourcePackProvider rp = new DefaultClientResourcePackProvider(Path.of("resourcepacks","resourcepacks"));

    }

}
