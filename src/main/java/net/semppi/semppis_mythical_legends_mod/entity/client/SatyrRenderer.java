package net.semppi.semppis_mythical_legends_mod.entity.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.SatyrEntity;
import net.semppi.semppis_mythical_legends_mod.entity.variant.SatyrVariant;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class SatyrRenderer extends GeoEntityRenderer<SatyrEntity> {
    private final SatyrModel baseModel = new SatyrModel();
    private final SatyrEquipmentModel equipmentModel = new SatyrEquipmentModel();

    public SatyrRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SatyrModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(SatyrEntity animatable) {
        SatyrVariant variant = animatable.getVariant();
        if (variant == SatyrVariant.BLACK) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/satyr_black.png");
        } else if (variant == SatyrVariant.BROWN) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/satyr_brown.png");
        } else if (variant == SatyrVariant.CARAMEL) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/satyr_caramel.png");
        } else if (variant == SatyrVariant.BLONDE) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/satyr_blonde.png");
        } else if (variant == SatyrVariant.COPPER_RED) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/satyr_copper_red.png");
        }else {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/satyr_albino.png");
        }
    }

//    @Override
//    public void render(SatyrEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
//        super.render(entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight); // Renders the base model
//
//        if (entity.hasArmor()) {
//            // Render the equipment model. Adapt as necessary for your mod.
//            poseStack.pushPose();
//            // Adjust the poseStack as necessary for the equipment model
//
//            // Bind the armor texture
//            Minecraft.getInstance().getTextureManager().bind(equipmentModel.getTextureResource(entity));
//
//            // You will need to properly implement this part according to how GeoLib expects you to render models.
//            // This might involve getting the GeoModel instance for the equipment and then rendering it with the current poseStack and other parameters.
//            GeoModel equipmentGeoModel = equipmentModel.getModel(equipmentModel.getModelResource(entity));
//            equipmentModel.render(equipmentGeoModel, entity, partialTicks, RenderType.entityCutoutNoCull(equipmentModel.getTextureResource(entity)), poseStack, bufferSource, packedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
//
//            poseStack.popPose();
//        }
//    }

    @Override
    public RenderType getRenderType(SatyrEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {if(animatable.isBaby()) {
        stack.scale(0.5F, 0.5F, 0.5F);
    } else {
        stack.scale(1.0F, 1.0F, 1.0F);
    }

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}