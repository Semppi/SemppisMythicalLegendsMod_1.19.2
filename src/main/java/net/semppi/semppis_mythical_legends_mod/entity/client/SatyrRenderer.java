package net.semppi.semppis_mythical_legends_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.SatyrEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SatyrRenderer extends GeoEntityRenderer<SatyrEntity> {
    public SatyrRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SatyrModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(SatyrEntity animatable) {
        if (animatable.isBrown()) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/satyr_brown.png");
        } else {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/satyr_black.png");
        }
    }

    @Override
    public RenderType getRenderType(SatyrEntity animatable, float partialTick, PoseStack poseStack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer, int packedLight,
                                    ResourceLocation texture) {

        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
