package net.semppi.semppis_mythical_legends_mod.block.entity;

import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.SatyrEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SatyrSkullBlockModel extends AnimatedGeoModel<SatyrSkullBlockEntity> {
    @Override
    public ResourceLocation getModelResource(SatyrSkullBlockEntity blockEntity){
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "resources/assets/semppis_mythical_legends_mod/blockstates/satyr_skull_generic.json");
    }
    @Override
    public ResourceLocation getTextureResource(SatyrSkullBlockEntity blockEntity){
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "resources/assets/semppis_mythical_legends_mod/textures/block/satyr_skull_black.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SatyrSkullBlockEntity animatable) {
        return null;
    }
}
