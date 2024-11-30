package net.remclean.mapleforest.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.Registry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.remclean.mapleforest.block.ModBlocks;
import net.remclean.mapleforest.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HatchetItem extends Item {
    public HatchetItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();

            BlockState state = context.getWorld().getBlockState(positionClicked);

            if(isLog(state)) {
                spawnBark((ServerPlayerEntity) player, positionClicked);
            }
        }



        return ActionResult.SUCCESS;
    }

    private void spawnBark(ServerPlayerEntity player, BlockPos posClicked) {
          ItemStack bark = new ItemStack(ModItems.BARK);

          Block.dropStack( , posClicked.toCenterPos(), bark);

          ItemEntity barkItem = new ItemEntity(, posClicked.getX(), posClicked.getY(), posClicked.getZ(), bark);
    }


    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " at (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), true);
    }

    private boolean isLog(BlockState state) {
        return state.isOf(ModBlocks.MAPLE_LOG) || state.isOf(Blocks.OAK_LOG) || state.isOf(Blocks.SPRUCE_LOG) || state.isOf(Blocks.BIRCH_LOG) || state.isOf(Blocks.JUNGLE_LOG) || state.isOf(Blocks.ACACIA_LOG) || state.isOf(Blocks.DARK_OAK_LOG) || state.isOf(Blocks.MANGROVE_LOG) || state.isOf(Blocks.CHERRY_LOG);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.maple-forest.hatchet"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}