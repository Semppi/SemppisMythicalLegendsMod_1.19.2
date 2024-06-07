package net.semppi.semppis_mythical_legends_mod.item.client;

import net.minecraft.resources.ResourceLocation;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.item.custom.WrappedPukis;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WrappedPukisModel extends AnimatedGeoModel<WrappedPukis> {
    @Override
    public ResourceLocation getModelResource(WrappedPukis object) {
        return new ResourceLocation("semppis_mythical_legends_mod", "geo/wrapped_pukis.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WrappedPukis object) {
        return new ResourceLocation("semppis_mythical_legends_mod", "textures/item/pukis_dark_wrapped.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WrappedPukis object) {
        return new ResourceLocation("semppis_mythical_legends_mod", "animations/wrapped_pukis.animation.json");
    }
}
