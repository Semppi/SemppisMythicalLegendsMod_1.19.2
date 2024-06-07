package net.semppi.semppis_mythical_legends_mod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.LovelandFrogmanEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.MandrakeEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class LovelandFrogmanModel extends AnimatedGeoModel<LovelandFrogmanEntity> {
    @Override
    public ResourceLocation getModelResource(LovelandFrogmanEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "geo/loveland_frogman.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LovelandFrogmanEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/frogman_green.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LovelandFrogmanEntity animatable) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "animations/loveland_frogman.animation.json");
    }
    /// ToDo: Fix the deprecated function

    @Override
    public void setLivingAnimations(LovelandFrogmanEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
