package net.semppi.semppis_mythical_legends_mod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.BehemothEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.MandrakeEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.WendigoEntity;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class WendigoModel extends AnimatedGeoModel<WendigoEntity> {
    @Override
    public ResourceLocation getModelResource(WendigoEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "geo/wendigo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WendigoEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/wendigo_brown.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WendigoEntity animatable) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "animations/wendigo.animation.json");
    }

    @Override
    public void setLivingAnimations(WendigoEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}