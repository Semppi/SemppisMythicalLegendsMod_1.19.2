package net.semppi.semppis_mythical_legends_mod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.semppi.semppis_mythical_legends_mod.block.ModBlockEntities;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class SatyrSkullBlockEntity extends BlockEntity implements IAnimatable {
    public SatyrSkullBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SATYR_SKULL.get(), pos, state);
    }

    @Override
    public @NotNull ModelData getModelData() {
        /// TODO: We need to implement here the code to load the textures and json file with the mod
        return new SatyrSkullBlockModel();
    }

    @Override
    public void registerControllers(AnimationData data) {

    }

    @Override
    public AnimationFactory getFactory() {
        return null;
    }

    // Additional methods and logic specific to the SatyrSkull block entity
}