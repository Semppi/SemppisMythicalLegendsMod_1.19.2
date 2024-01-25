package net.semppi.semppis_mythical_legends_mod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.ColossalLobsterEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.PukisEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.SatyrEntity;
import net.semppi.semppis_mythical_legends_mod.entity.variant.SatyrVariant;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class PukisModel extends AnimatedGeoModel<PukisEntity> {
    @Override
    public ResourceLocation getModelResource(PukisEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID,"geo/pukis.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PukisEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/pukis_dark.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PukisEntity animatable) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID,"animations/pukis.animation.json");
    }
    /// ToDo: Fix the deprecated function

    @Override
    public void setLivingAnimations(PukisEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}