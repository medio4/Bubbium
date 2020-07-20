package jedio.bubbium.blocks;

import jedio.bubbium.Bubbium;
import jedio.bubbium.entities.BubbiumGolemEntity;
import jedio.bubbium.init.ModBlocks;
import jedio.bubbium.init.ModEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class CarvedPumpkinOverride extends HorizontalBlock {

    @SuppressWarnings("unused")
    protected CarvedPumpkinOverride(Properties builder) {
        super(Block.Properties.from(Blocks.CARVED_PUMPKIN));
        this.setDefaultState(this.getStateContainer().getBaseState().with(HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }

    @Override
    @SuppressWarnings("all")
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        trySpawnGolem(worldIn, pos);
    }
    
    
    //@SuppressWarnings("all")
    public static boolean trySpawnGolem(final World world, final BlockPos headPos) {
        if (world.isRemote) {
            return false;
        }

        // get all the block and state values that we will be using in the following
        // code
        final BlockState stateBelow1 = world.getBlockState(headPos.down(1));
        final BlockState stateBelow2 = world.getBlockState(headPos.down(2));
        final BlockState stateArmNorth = world.getBlockState(headPos.down(1).north(1));
        final BlockState stateArmSouth = world.getBlockState(headPos.down(1).south(1));
        final BlockState stateArmEast = world.getBlockState(headPos.down(1).east(1));
        final BlockState stateArmWest = world.getBlockState(headPos.down(1).west(1));
        final Block blockBelow1 = stateBelow1.getBlock();
        final Block blockBelow2 = stateBelow2.getBlock();
        final Block blockArmNorth = stateArmNorth.getBlock();
        final Block blockArmSouth = stateArmSouth.getBlock();
        final Block blockArmEast = stateArmEast.getBlock();
        final Block blockArmWest = stateArmWest.getBlock();
        // this is where the golem will spawn at the end
        final double spawnX = headPos.getX() + 0.5D;
        final double spawnY = headPos.getY() - 1.95D;
        final double spawnZ = headPos.getZ() + 0.5D;
        // true if the golem is East-West aligned
        boolean flagX;
        // true if the golem is completely Iron Blocks
        boolean isIron;

        boolean isBubbium;

        ////// Hard-coded support for Snow Golem //////
        if (doBlocksMatch(Blocks.SNOW_BLOCK, blockBelow1, blockBelow2)) {
            removeGolemBody(world, headPos);
            final SnowGolemEntity entitysnowman = EntityType.SNOW_GOLEM.create(world);
            Bubbium.LOGGER.info("[Bubbium]: Building regular boring Snow Golem");
            assert entitysnowman != null;
            entitysnowman.setLocationAndAngles(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
            world.addEntity(entitysnowman);
            return true;
        }

        isBubbium = doBlocksMatch(ModBlocks.BUBBIUM_BLOCK.get(), blockBelow1, blockBelow2, blockArmNorth, blockArmSouth);
        if (isBubbium) {
            flagX = false;
        } else {
            isBubbium = doBlocksMatch(ModBlocks.BUBBIUM_BLOCK.get(), blockBelow1, blockBelow2, blockArmEast, blockArmWest);
            flagX = true;
        }
        if (isBubbium) {
            removeAllGolemBlocks(world, headPos, flagX);
            // build Bubbium Golem
            final BubbiumGolemEntity bubbiumGolem = ModEntityTypes.BUBBIUM_GOLEM.get().create(world);
            Bubbium.LOGGER.info("[Bubbium]: Building Bubbium Golem!");
            assert bubbiumGolem != null;
            bubbiumGolem.setPlayerCreated(true);
            bubbiumGolem.setLocationAndAngles(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
            world.addEntity(bubbiumGolem);
            return true;
        }

        ////// Hard-coded support for Iron Golem //////
        isIron = doBlocksMatch(Blocks.IRON_BLOCK, blockBelow1, blockBelow2, blockArmNorth, blockArmSouth);
        if (isIron) {
            flagX = false;
        } else {
            // try to find an Iron Golem east-west aligned
            isIron = doBlocksMatch(Blocks.IRON_BLOCK, blockBelow1, blockBelow2, blockArmEast, blockArmWest);
            flagX = true;
        }
        if (isIron) {
            removeAllGolemBlocks(world, headPos, flagX);
            // build Iron Golem
            final IronGolemEntity ironGolem = EntityType.IRON_GOLEM.create(world);
            Bubbium.LOGGER.info("[Bubbium]: Building regular boring Iron Golem");
            assert ironGolem != null;
            ironGolem.setPlayerCreated(true);
            ironGolem.setLocationAndAngles(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
            world.addEntity(ironGolem);
            return true;
        }


        if (isInvalidBlock(blockBelow1) || isInvalidBlock(blockBelow2)) {
            return false;
        }

        ////// Attempt to spawn a Golem from this mod //////
        BubbiumGolemEntity golem = ModEntityTypes.BUBBIUM_GOLEM.get().create(world);
        //flagX = false;

        if (golem != null) {
            // spawn the golem!
            removeAllGolemBlocks(world, headPos, flagX);
            golem.setPlayerCreated(true);
            golem.setLocationAndAngles(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
            Bubbium.LOGGER.info("[Bubbium]: Detected golem!");
            world.addEntity(golem);
            return true;
        }
        // No Golems of any kind were spawned :(
        return false;
    }

    /**
     * @param master  the Block to check against
     * @param toCheck other Block values that you want to ensure are equal
     * @return true if [every Block in {@code toCheck}] == master
     **/
    public static boolean doBlocksMatch(Block master, Block... toCheck) {
        boolean success = toCheck != null && toCheck.length > 0;
        assert toCheck != null;
        for (Block b : toCheck) {
            success &= b == master;
        }
        return success;
    }

    /**
     * Replaces this block and the four construction blocks with air.
     **/
    public static void removeAllGolemBlocks(final World world, final BlockPos pos, final boolean isXAligned) {
        removeGolemBody(world, pos);
        removeGolemArms(world, pos, isXAligned);
    }

    /**
     * Replaces this block and the two below it with air.
     **/
    public static void removeGolemBody(final World world, final BlockPos head) {
        world.destroyBlock(head, false);
        world.destroyBlock(head.down(1), false);
        world.destroyBlock(head.down(2), false);
    }

    /**
     * Replaces blocks at arm positions with air.
     **/
    public static void removeGolemArms(final World world, final BlockPos pos, final boolean isXAligned) {
        if (isXAligned) {
            world.destroyBlock(pos.down(1).west(1), false);
            world.destroyBlock(pos.down(1).east(1), false);
        } else {
            world.destroyBlock(pos.down(1).north(1), false);
            world.destroyBlock(pos.down(1).south(1), false);
        }
    }

    /**
     * @return true if the block should not be considered a golem building block
     **/
    private static boolean isInvalidBlock(final Block b) {
        return b == null || b == Blocks.AIR || b == Blocks.WATER;
    }
}
