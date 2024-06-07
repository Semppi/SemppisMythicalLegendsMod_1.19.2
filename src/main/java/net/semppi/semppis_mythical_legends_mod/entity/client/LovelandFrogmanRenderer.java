package net.semppi.semppis_mythical_legends_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.LovelandFrogmanEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.MandrakeEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class LovelandFrogmanRenderer extends GeoEntityRenderer<LovelandFrogmanEntity> {
    public LovelandFrogmanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LovelandFrogmanModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(LovelandFrogmanEntity instance) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/frogman_green.png");
    }

    @Override
    public RenderType getRenderType(LovelandFrogmanEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
