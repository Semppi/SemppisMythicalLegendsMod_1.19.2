package net.semppi.semppis_mythical_legends_mod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.block.entity.SatyrSkullBlockEntity;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SemppisMythicalLegendsMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<SatyrSkullBlockEntity>> SATYR_SKULL =
            BLOCK_ENTITIES.register("satyr_skull", () ->
                    BlockEntityType.Builder.of(SatyrSkullBlockEntity::new, ModBlocks.SATYR_SKULL.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}