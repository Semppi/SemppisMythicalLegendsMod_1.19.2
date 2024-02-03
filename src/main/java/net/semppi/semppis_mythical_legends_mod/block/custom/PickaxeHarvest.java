package net.semppi.semppis_mythical_legends_mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class PickaxeHarvest {
    public static void handlePickaxeAction(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.getItem() instanceof PickaxeItem) {

            if (!player.isCreative()) {
                int unbreakingLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, itemStack);
                boolean shouldDamage = true;

                if (unbreakingLevel > 0) {
                    int damageRandom = worldIn.random.nextInt(100);
                    if (damageRandom < (100 / (unbreakingLevel + 1))) {
                        shouldDamage = false;
                    }
                }

                if (shouldDamage) {
                    itemStack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(hand));
                }
            }

            worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        }
    }
}