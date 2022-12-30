package net.lanternmc.avmwandmod.NBT;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.text.Text;

import java.util.HashMap;
import java.util.Objects;

public class NBTManager {

    public static HashMap<PlayerEntity, String> data = new HashMap<>();

    public static void GenNBT(PlayerEntity CommandUser, ItemStack is) {
        if (is.hasNbt()) {
            NbtCompound nbt = is.getNbt();
            if (nbt != null) {
                nbt.remove("Command");
                is.setNbt(nbt);
            }
        }

        NbtCompound nbt = new NbtCompound();
        nbt.putString("Command", data.get(CommandUser));
        is.setNbt(nbt);
    }


    public static String loadNBT(ItemStack is) {
        NbtCompound nbt = is.getNbt();
        return Objects.requireNonNull(nbt).getString("Command");
    }

}
