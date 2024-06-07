package net.semppi.semppis_mythical_legends_mod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.SatyrEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class SatyrEquipmentModel extends AnimatedGeoModel<SatyrEntity> {
    @Override
    public ResourceLocation getModelResource(SatyrEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "geo/satyr_equipment.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SatyrEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/armor/satyr_cloth_red.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SatyrEntity animatable) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "animations/satyr.animation.json");
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