package net.lanternmc.avmwandmod.red;

import net.lanternmc.avmwandmod.Utils.Delete;
import net.lanternmc.avmwandmod.Utils.FilePath;
import net.lanternmc.avmwandmod.Utils.OSinfo;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class RedWands extends Item {
    public RedWands(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity p, Hand hand) {

        //删除save
        if (OSinfo.isWindows()) {
            new Delete().DeleteBat();
        } else {
            new Delete().DeleteSh();
        }
        return TypedActionResult.success(p.getStackInHand(hand));
    }

    private void KillMineCraft(PlayerEntity p) {

    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        // 格式化为红色文本
        tooltip.add(Text.translatable("item.avmwandmod.creative.tooltip").formatted(Formatting.RED)
                .append("方块容器法杖"));
    }

}
