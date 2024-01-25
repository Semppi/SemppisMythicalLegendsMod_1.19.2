package net.semppi.semppis_mythical_legends_mod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.SatyrEntity;
import net.semppi.semppis_mythical_legends_mod.entity.variant.SatyrVariant;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class SatyrModel extends AnimatedGeoModel<SatyrEntity> {
    @Override
    public ResourceLocation getModelResource(SatyrEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID,"geo/satyr.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SatyrEntity entity) {
        SatyrVariant variant = entity.getSatyrVariant();
        String variantName = variant.name().toLowerCase();
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/satyr_" + variantName + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(SatyrEntity animatable) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID,"animations/satyr.animation.json");
    }
    /// ToDo: Fix the deprecated function

    @Override
    public void setLivingAnimations(SatyrEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}