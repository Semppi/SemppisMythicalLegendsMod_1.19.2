package net.semppi.semppis_mythical_legends_mod.entity.client;

import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.BehemothEntity;
import net.minecraft.resources.ResourceLocation;
import net.semppi.semppis_mythical_legends_mod.entity.custom.PukisEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

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

    @Override
    public void setLivingAnimations(BehemothEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}