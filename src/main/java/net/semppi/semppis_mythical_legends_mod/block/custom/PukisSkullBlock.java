package net.semppi.semppis_mythical_legends_mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.semppi.semppis_mythical_legends_mod.item.ModItems;

public class PukisSkullBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACEING = BlockStateProperties.HORIZONTAL_FACING;

    public PukisSkullBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE =
            Block.box(4, 0, 4, 12, 7, 12);

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACEING);
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.getItem() instanceof PickaxeItem) {
            // Check if the item used is a pickaxe
            if (player.isCreative()) {
                // In Creative mode, no durability loss
                dropItems(worldIn, pos);
            } else {
                // Calculate Unbreaking chance
                int unbreakingLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, itemStack);
                boolean shouldDamage = true;

                if (unbreakingLevel > 0) {
                    int damageRandom = worldIn.random.nextInt(100);
                    if (damageRandom < (100 / (unbreakingLevel + 1))) {
                        shouldDamage = false;
                    }
                }

                // Damage the pickaxe if needed
                if (shouldDamage) {
                    itemStack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(hand));
                }

                // Drop the items regardless of Unbreaking
                dropItems(worldIn, pos);
            }

            worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3); // Destroy the block
            worldIn.playSound(null, pos, SoundEvents.BONE_BLOCK_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F); // Play the breaking sound
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    private void dropItems(Level worldIn, BlockPos pos) {
        if (worldIn instanceof ServerLevel) {
            ServerLevel serverWorld = (ServerLevel) worldIn;
            ItemStack boneMealStack = new ItemStack(Items.BONE_MEAL, 9);

            // Drop the items at the block's position
            Block.popResource(serverWorld, pos, boneMealStack);
        }
    }
}