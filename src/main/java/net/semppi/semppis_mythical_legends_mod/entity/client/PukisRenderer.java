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
import net.semppi.semppis_mythical_legends_mod.entity.custom.PukisEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.SatyrEntity;
import net.semppi.semppis_mythical_legends_mod.entity.variant.PukisVariant;
import net.semppi.semppis_mythical_legends_mod.entity.variant.SatyrVariant;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;


public class PukisRenderer extends GeoEntityRenderer<PukisEntity> {
    public PukisRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PukisModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(PukisEntity animatable) {
        PukisVariant variant = animatable.getVariant();
        if (variant == PukisVariant.GREEN) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/pukis_dark.png");
        } else if (variant == PukisVariant.BLUE) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/pukis_dark.png");
        } else if (variant == PukisVariant.RED) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/pukis_dark.png");
        } else if (variant == PukisVariant.GOLD) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/pukis_dark.png");
        } else if (variant == PukisVariant.DARK) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/pukis_dark.png");
        } else if (variant == PukisVariant.SILVER) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/pukis_silver.png");
        }else {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/pukis_dark.png");
        }
    }

    @Override
    public RenderType getRenderType(PukisEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}