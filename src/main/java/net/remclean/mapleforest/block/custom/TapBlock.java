package net.remclean.mapleforest.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.remclean.mapleforest.block.ModBlocks;
import net.remclean.mapleforest.item.ModItems;


public class TapBlock extends TripwireHookBlock {

    public TapBlock(Settings settings) {
        super(settings);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack sap = new ItemStack(ModItems.MAPLE_SAP);

        if (player.isHolding(Items.GLASS_BOTTLE)) {
            player.getMainHandStack().decrement(1);
            player.giveItemStack(sap);
        }

        return ActionResult.SUCCESS;
    }

    private static final VoxelShape WEST_SHAPE = Block.createCuboidShape(0, 6, 6, 6, 10, 10);
    private static final VoxelShape EAST_SHAPE = Block.createCuboidShape(10, 6, 6, 16, 10, 10);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(6, 6, 0, 10, 10, 6);
    private static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(6, 6, 10, 10, 10, 16);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch ((Direction)state.get(FACING)) {
            case EAST:
            default:
                return WEST_SHAPE;
            case WEST:
                return EAST_SHAPE;
            case SOUTH:
                return NORTH_SHAPE;
            case NORTH:
                return SOUTH_SHAPE;
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = (Direction)state.get(FACING);
        BlockPos blockPos = pos.offset(direction.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        return direction.getAxis().isHorizontal() && blockState.isSideSolidFullSquare(world, blockPos, direction) && (blockState.getBlock() == ModBlocks.MAPLE_LOG);
    }
}
