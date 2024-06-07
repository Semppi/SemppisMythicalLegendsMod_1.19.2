package net.semppi.semppis_mythical_legends_mod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class MandrakeBerriesItem extends Item {

    public MandrakeBerriesItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        ItemStack itemstack = super.finishUsingItem(stack, world, entity);

        if (!world.isClientSide && entity instanceof Player) {
            Random random = new Random();
            if (random.nextFloat() < 0.15) { // 15% chance
                entity.addEffect(new MobEffectInstance(MobEffects.POISON, 18 * 20, 0)); // 18 seconds, amplifier 0
            }
        }

        return itemstack;
    }
}