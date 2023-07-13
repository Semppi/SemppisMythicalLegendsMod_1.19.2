package net.semppi.semppis_mythical_legends_mod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.semppi.semppis_mythical_legends_mod.block.ModBlockEntities;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class SatyrSkullBlockEntity extends BlockEntity implements IAnimatable {
    /// ToDo: Fix the depcracated function
    private AnimationFactory factory = new AnimationFactory(this);

    public SatyrSkullBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SATYR_SKULL.get(), pos, state);
    }

    @Override
    public ModelData getModelData() {
        // TODO: Implement code to load the textures and json file for the block model
        return super.getModelData();
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        AnimationController controller = new AnimationController(this, "controller", 0, this::predicate);
        animationData.addAnimationController(controller);
    }

    private PlayState predicate(AnimationEvent<IAnimatable> event) {
        // Implement your animation logic here
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    // Additional methods and logic specific to the SatyrSkull block entity
}