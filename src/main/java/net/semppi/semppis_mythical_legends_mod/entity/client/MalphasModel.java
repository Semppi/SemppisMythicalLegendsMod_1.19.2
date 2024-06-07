package net.semppi.semppis_mythical_legends_mod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.MalphasEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.WendigoEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class MalphasModel extends AnimatedGeoModel<MalphasEntity> {
    @Override
    public ResourceLocation getModelResource(MalphasEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "geo/malphas.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MalphasEntity object) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/malphas_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MalphasEntity animatable) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "animations/malphas.animation.json");
    }

    @Override
    public void setLivingAnimations(MalphasEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}