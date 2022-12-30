package net.lanternmc.avmwandmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lanternmc.avmwandmod.NBT.CopyItem;
import net.lanternmc.avmwandmod.red.CommandWand;
import net.lanternmc.avmwandmod.red.RedWands;
import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

import java.io.File;

public class AVMWandMod implements ModInitializer {

    public static final Item AVM_WAND_EMPTY =
            Registry.register(Registries.ITEM, new Identifier("avmwandmod", "red"),
                    new Item(new FabricItemSettings().maxCount(1)));
    public static final Item AVM_WAND_MC =
            Registry.register(Registries.ITEM, new Identifier("avmwandmod", "creative"),
                    new RedWands(new FabricItemSettings().maxCount(1)));
    public static final Item AVM_WAND_CB =
            Registry.register(Registries.ITEM, new Identifier("avmwandmod", "commandblock"),
                    new CommandWand(new FabricItemSettings().maxCount(1)));


    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.add(AVM_WAND_EMPTY);
            content.add(AVM_WAND_MC);
            content.add(AVM_WAND_CB);
        });
        File xe = new File("");
        System.out.println(xe.getAbsolutePath());
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            BlockState state = world.getBlockState(pos);
            /* 手动的旁观者检查是必要的，因为 AttackBlockCallbacks 会在旁观者检查之前应用 */
            if (state.isToolRequired() && !player.isSpectator() &&
                    player.getMainHandStack().isEmpty()) {
                player.damage(DamageSource.GENERIC, 1.0F);
            }
            return ActionResult.PASS;
        });

    }

}
