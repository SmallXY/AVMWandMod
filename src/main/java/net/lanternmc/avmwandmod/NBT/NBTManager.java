package net.lanternmc.avmwandmod.NBT;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

import java.util.Objects;

public class NBTManager {

    public static void GenNBT(String CommandInfo, ItemStack is) {
        NbtCompound nbt = new NbtCompound();
        nbt.putString("Command", CommandInfo);
        is.setNbt(nbt);
    }


    public static String loadNBT(ItemStack is) {
        NbtCompound nbt = is.getNbt();
        return Objects.requireNonNull(nbt).getString("Command");
    }

}
