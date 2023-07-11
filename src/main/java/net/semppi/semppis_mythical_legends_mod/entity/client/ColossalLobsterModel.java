package net.semppi.semppis_mythical_legends_mod.entity.client;

import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.ColossalLobsterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ColossalLobsterModel extends AnimatedGeoModel<ColossalLobsterEntity> {
    @Override
    public ResourceLocation getModelResource(ColossalLobsterEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "geo/colossal_lobster.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ColossalLobsterEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/lobster_orange_black.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ColossalLobsterEntity animatable) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "animations/colossal_lobster.animation.json");
    }
}