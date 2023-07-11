package net.semppi.semppis_mythical_legends_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.ColossalLobsterEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ColossalLobsterRenderer extends GeoEntityRenderer<ColossalLobsterEntity> {
    public ColossalLobsterRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ColossalLobsterModel());
        this.shadowRadius = 1.0f;
    }

    @Override
    public ResourceLocation getTextureLocation(ColossalLobsterEntity instance) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/lobster_orange_black.png");
    }

    @Override
    public RenderType getRenderType(ColossalLobsterEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}