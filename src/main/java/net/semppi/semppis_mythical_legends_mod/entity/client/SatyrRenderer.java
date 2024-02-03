package net.semppi.semppis_mythical_legends_mod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.BehemothEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.SatyrEntity;
import net.semppi.semppis_mythical_legends_mod.entity.variant.SatyrVariant;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class SatyrRenderer extends GeoEntityRenderer<SatyrEntity> {
    public SatyrRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SatyrModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(SatyrEntity animatable) {
        SatyrVariant variant = animatable.getSatyrVariant();
        if (variant == SatyrVariant.BLACK) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/satyr_black.png");
        } else if (variant == SatyrVariant.BROWN) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/satyr_brown.png");
        } else {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/satyr_caramel.png");
        }
    }

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