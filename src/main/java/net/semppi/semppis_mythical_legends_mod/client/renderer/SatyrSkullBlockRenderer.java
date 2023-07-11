package net.semppi.semppis_mythical_legends_mod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LecternBlock;
import net.minecraft.world.level.block.PlayerHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.block.custom.SatyrSkullBlock;
import net.semppi.semppis_mythical_legends_mod.block.entity.SatyrSkullBlockEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.ColossalLobsterEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.SatyrEntity;
import org.jetbrains.annotations.Nullable;

public class SatyrSkullBlockRenderer implements BlockEntityRenderer<SatyrSkullBlockEntity> {

    public SatyrSkullBlockRenderer(BlockEntityRendererProvider.Context renderManager) {
        super();
    }


    @Override
    public void render(SatyrSkullBlockEntity be, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay) {
        BlockRenderDispatcher dispatcher = Minecraft.getInstance().getBlockRenderer();

        poseStack.pushPose();
        float f1 = 45.0F;
        poseStack.mulPose(new Vector3f().rotationDegrees(f1));

        dispatcher.renderSingleBlock(Blocks.GLASS.defaultBlockState(), poseStack, bufferSource, combinedLight, OverlayTexture.NO_OVERLAY,be.getModelData(), RenderType.cutout());

        poseStack.popPose();

    }

    public ResourceLocation getTexture() {
        return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/block/satyr_skull_black.png");


    }


}