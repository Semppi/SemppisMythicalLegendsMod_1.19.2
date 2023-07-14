package net.semppi.semppis_mythical_legends_mod.entity.client;

import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.BehemothEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BehemothModel extends AnimatedGeoModel<BehemothEntity> {
    @Override
    public ResourceLocation getModelResource(BehemothEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "geo/behemoth.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BehemothEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/behemoth_brown.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BehemothEntity animatable) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "animations/behemoth.animation.json");
    }
}