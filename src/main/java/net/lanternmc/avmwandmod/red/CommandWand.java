package net.lanternmc.avmwandmod.red;

import net.lanternmc.avmwandmod.NBT.NBTManager;
import net.lanternmc.avmwandmod.Utils.UseCommand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CommandWand extends Item {
    public CommandWand(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity p, Hand hand) {
        if(p.getStackInHand(hand).hasNbt()) {
            UseCommand.init(p, NBTManager.loadNBT(p.getStackInHand(hand)));
        }
        return TypedActionResult.success(p.getStackInHand(hand));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        if(stack.hasNbt()) {
            assert stack.getNbt() != null;
            return stack.getNbt().getString("command").isEmpty();
        }
        return false;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
//        context.getPlayer().open.setScreen(new CmdScreen(new CmdGUI()));
        return ActionResult.success(context.hitsInsideBlock());
    }
}
