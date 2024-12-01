package net.remclean.mapleforest.block.custom;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.TripwireHookBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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

//    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        switch ((Direction)state.get(FACING)) {
//            case EAST:
//            default:
//                return WEST_SHAPE;
//            case WEST:
//                return EAST_SHAPE;
//            case SOUTH:
//                return NORTH_SHAPE;
//            case NORTH:
//                return SOUTH_SHAPE;
//        }
//    }

//    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
//        Direction direction = (Direction)state.get(FACING);
//        BlockPos blockPos = pos.offset(direction.getOpposite());
//        BlockState blockState = world.getBlockState(blockPos);
//        return direction.getAxis().isHorizontal() && blockState.isSideSolidFullSquare(world, blockPos, direction);
//    }
}
