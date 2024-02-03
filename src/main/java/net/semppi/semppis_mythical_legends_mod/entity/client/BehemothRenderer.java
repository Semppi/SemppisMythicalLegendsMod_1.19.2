package net.semppi.semppis_mythical_legends_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.BehemothEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BehemothRenderer extends GeoEntityRenderer<BehemothEntity> {
    public BehemothRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BehemothModel());
        this.shadowRadius = 7.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(BehemothEntity instance) {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/behemoth_brown.png");
    }

    @Override
    public RenderType getRenderType(BehemothEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(2.5f, 2.5f, 2.5f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}