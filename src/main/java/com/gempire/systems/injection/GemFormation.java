package com.gempire.systems.injection;

import com.gempire.entities.bases.EntityGem;
import com.gempire.entities.bases.EntityVaryingGem;
import com.gempire.entities.gems.EntityQuartz;
import com.gempire.entities.gems.starter.EntityPebble;
import com.gempire.events.DrainEvent;
import com.gempire.events.GemFormEvent;
import com.gempire.init.AddonHandler;
import com.gempire.init.ModBlocks;
import com.gempire.init.ModEntities;
import com.gempire.items.ItemChroma;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class GemFormation {
    private static final int EXIT_HOLE_LENGTH = 16;
    public World world;
    public BlockPos pos;
    public BlockPos volumeToCheck;
    public static ArrayList<String> POSSIBLE_GEMS = new ArrayList<>();
    public Block drained_sand, drained_soil, drained_stone, drained_stone_2, banded_drained_stone, drained_log, drained_log_cracked, drained_ice;
    public ItemChroma chroma;
    public Item primer;
    public String essences;
    public int facing = 0;

    HashMap<String, Float> WEIGHTS_OF_GEMS = new HashMap<>();

    //Create an object to store the total weight
    float totalWeight = 0;

    public GemFormation(World world, BlockPos pos, BlockPos volumeToCheck, ItemChroma chroma, Item primer, String essences, int facing, HashMap<String, Float> weights, float total){
        this.world = world;
        this.pos = pos;
        this.volumeToCheck = volumeToCheck;
        this.chroma = chroma;
        this.primer = primer;
        this.essences = essences;
        this.facing = facing;
        this.WEIGHTS_OF_GEMS = weights;
        this.totalWeight = total;
    }

    public void SpawnGem(){
        RegistryObject<EntityType<EntityPebble>> gemm = ModEntities.PEBBLE;
        EntityGem gem = gemm.get().create(this.world);
        float BIOME_TEMPERATURE = this.world.getBiome(this.pos).getTemperature();
        this.SetDrainedStoneColor(BIOME_TEMPERATURE);
        String gemtoform = this.EvaluateCruxes();
        if (gemtoform == "") {
            //this.Drain(GemFormation.getBlockPosInVolume(this.world, this.pos, this.volumeToCheck));
            return;
        }
        try {
            boolean isVanillaGem = false;
            for(String gemama : AddonHandler.VANILLA_GEMS){
                if(gemtoform == gemama) isVanillaGem = true;
            }
            if(isVanillaGem) {
                gemm = (RegistryObject<EntityType<EntityPebble>>) ModEntities.class.getField(gemtoform.toUpperCase()).get(null);
            }
            else{
                gemm = (RegistryObject<EntityType<EntityPebble>>) AddonHandler.ENTITY_ADDON_ENTITY_REGISTRIES.get(gemtoform).getField(gemtoform.toUpperCase()).get(null);
            }
            gem = gemm.get().create(this.world);
            if(gem instanceof EntityVaryingGem){
                EntityVaryingGem varyingGem = (EntityVaryingGem)gem;
                varyingGem.setSkinVariantOnInitialSpawn = false;
                int variant = this.getColorFromChroma();
                Random rand = new Random();
                if(gem instanceof EntityQuartz && variant == 16){
                    variant += rand.nextBoolean() ? 1 : 0;
                }
                if(varyingGem.isColorValid(variant)){
                    varyingGem.initalSkinVariant = variant;
                }
                else{
                    varyingGem.initalSkinVariant = varyingGem.generateRandomInitialSkin();
                }
            }
            gem.setUniqueId(MathHelper.getRandomUUID(this.world.rand));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            gem.onInitialSpawn((IServerWorld) this.world, this.world.getDifficultyForLocation(this.pos), SpawnReason.TRIGGERED, null, null);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        gem.setPosition(this.pos.getX() + .5f, this.pos.getY(), this.pos.getZ() + .5f);
        gem.setHealth(gem.getMaxHealth());
        GemFormEvent event1 = new GemFormEvent(gem, gem.getPosition());
        MinecraftForge.EVENT_BUS.post(event1);
        this.world.addEntity(gem);
        ArrayList<BlockPos> blocks = GemFormation.getBlockPosInVolume(this.world, this.pos, this.volumeToCheck);
        DrainEvent event2 = new DrainEvent(blocks);
        MinecraftForge.EVENT_BUS.post(event2);
        //this.Drain(blocks);
        this.GenerateFacingExitHole();
    }

    public static ArrayList<Block> getBlocksInVolume(World domhain, BlockPos position, BlockPos volume){
        ArrayList<Block> blocksInVolume = new ArrayList<>();
        float xo = GemFormation.getHalfMiddleOffsetRight(volume.getX());
        float yo = GemFormation.getHalfMiddleOffsetRight(volume.getY());
        float zo = GemFormation.getHalfMiddleOffsetRight(volume.getZ());
        for(int z = GemFormation.getHalfMiddleOffsetLeft(volume.getZ()); z < xo; z++){
            for(int y = GemFormation.getHalfMiddleOffsetLeft(volume.getY()); y < yo; y++){
                for(int x = GemFormation.getHalfMiddleOffsetLeft(volume.getX()); x < zo; x++){
                    Block block = domhain.getBlockState(position.add(new BlockPos(x, y, z))).getBlock();
                    if(block.getBlock() instanceof AirBlock){
                        continue;
                    }
                    else{
                        blocksInVolume.add(block);
                    }
                }
            }
        }
        return blocksInVolume;
    }
    public static ArrayList<BlockPos> getBlockPosInVolume(World domhain, BlockPos position, BlockPos volume){
        ArrayList<BlockPos> blocksInVolume = new ArrayList<>();
        float xo = GemFormation.getHalfMiddleOffsetRight(volume.getX());
        float yo = GemFormation.getHalfMiddleOffsetRight(volume.getY());
        float zo = GemFormation.getHalfMiddleOffsetRight(volume.getZ());
        for(int z = GemFormation.getHalfMiddleOffsetLeft(volume.getZ()); z < xo; z++){
            for(int y = GemFormation.getHalfMiddleOffsetLeft(volume.getY()); y < yo; y++){
                for(int x = GemFormation.getHalfMiddleOffsetLeft(volume.getX()); x < zo; x++){
                    BlockPos block = position.add(new BlockPos(x, y, z));
                    if(domhain.getBlockState(block).getBlock() instanceof AirBlock){
                        continue;
                    }
                    else{
                        blocksInVolume.add(block);
                    }
                }
            }
        }
        return blocksInVolume;
    }

    public static int getHalfMiddleOffsetLeft(float value){
        return -(int)Math.floor(value / 2);
    }

    public static int getHalfMiddleOffsetRight(float value){
        return (int)Math.ceil(value / 2);
    }

    public String EvaluateCruxes() {
        String returnGem = "";
        double lowestR = 100000000;
        String lowestRGem = "";
        for (String gem : this.POSSIBLE_GEMS) {
            double r = Math.random() * totalWeight;
            r -= WEIGHTS_OF_GEMS.get(gem);
            if (WEIGHTS_OF_GEMS.get(gem) < 12) {
                r = 1000000;
            }
            if (r < lowestR) {
                lowestR = r;
                lowestRGem = gem;
            }
            returnGem = gem;
            if (r > 0 && gem == this.POSSIBLE_GEMS.get(this.POSSIBLE_GEMS.size() - 1)){
                returnGem = lowestRGem;
                break;
            }
            if (r <= 0) {
                returnGem = gem;
                break;
            }
        }
        //OUTPUT: A gem
        return returnGem;
    }

    public static BlockPos DirectionFromFacing(int face){
        BlockPos pos = new BlockPos(1,0,0);
        switch(face){
            case 0: pos = new BlockPos(1,0, 0);
                break;
            case 1: pos = new BlockPos(0,0, -1);
                break;
            case 2: pos = new BlockPos(-1,0, 0);
                break;
            case 3: pos = new BlockPos(0,0, 1);
                break;
        }
        return pos;
    }

    public void GenerateFacingExitHole(){
        System.out.println("This block is facing: " + this.facing);
        BlockPos direction = GemFormation.DirectionFromFacing(this.facing);
        BlockPos currentPos = new BlockPos(this.pos);
        boolean flag = false;
        for(int i = 0; i < this.EXIT_HOLE_LENGTH; i++){
            if(!flag) {
                if(this.world.getBlockState(currentPos).getBlock() instanceof AirBlock
                        && this.world.getBlockState(currentPos.up()).getBlock() instanceof AirBlock){
                    flag = true;
                }
                this.world.destroyBlock(currentPos, false);
                this.world.destroyBlock(currentPos.up(), false);
                this.world.destroyBlock(currentPos.up().up(), false);
                currentPos = currentPos.add(direction);
            }
            else{
                break;
            }
        }
    }



    /*public void GenerateExitHole(){
        boolean found = false;
        if(!found) {
            ArrayList<BlockPos> blocks = new ArrayList<>();
            ArrayList<BlockPos> blocksToDrain = new ArrayList<>();
            for (int i = 0; i < 16; i++) {
                if (this.world.getBlockState(this.pos.add(i, 0, 0)).getBlock() != Blocks.AIR) {
                    blocks.add(this.pos.add(i, 0, 0));
                    blocks.add(this.pos.add(i, 1, 0));
                    blocks.add(this.pos.add(i, 2, 0));

                    blocksToDrain.add(this.pos.add(i, 0, 0).down());
                    blocksToDrain.add(this.pos.add(i, 0, 0).up().up().up());
                    blocksToDrain.add(this.pos.add(i, 0, 0).north());
                    blocksToDrain.add(this.pos.add(i, 0, 0).up().north());
                    blocksToDrain.add(this.pos.add(i, 0, 0).up().up().north());
                    blocksToDrain.add(this.pos.add(i, 0, 0).south());
                    blocksToDrain.add(this.pos.add(i, 0, 0).up().south());
                    blocksToDrain.add(this.pos.add(i, 0, 0).up().up().south());
                } else {
                    found = true;
                    break;
                }
            }
            if(found){
                for(BlockPos pos : blocks){
                    this.world.destroyBlock(pos, false);
                }
                this.Drain(blocksToDrain);
            }
        }
        if(!found) {
            ArrayList<BlockPos> blocks = new ArrayList<>();
            ArrayList<BlockPos> blocksToDrain = new ArrayList<>();
            for (int i = 0; i < 16; i++) {
                if (this.world.getBlockState(this.pos.add(-i, 0, 0)).getBlock() != Blocks.AIR) {
                    blocks.add(this.pos.add(-i, 0, 0));
                    blocks.add(this.pos.add(-i, 1, 0));
                    blocks.add(this.pos.add(-i, 2, 0));

                    blocksToDrain.add(this.pos.add(-i, 0, 0).down());
                    blocksToDrain.add(this.pos.add(-i, 0, 0).up().up().up());
                    blocksToDrain.add(this.pos.add(-i, 0, 0).north());
                    blocksToDrain.add(this.pos.add(-i, 0, 0).up().north());
                    blocksToDrain.add(this.pos.add(-i, 0, 0).up().up().north());
                    blocksToDrain.add(this.pos.add(-i, 0, 0).south());
                    blocksToDrain.add(this.pos.add(-i, 0, 0).up().south());
                    blocksToDrain.add(this.pos.add(-i, 0, 0).up().up().south());
                } else {
                    found = true;
                    break;
                }
            }
            if(found){
                for(BlockPos pos : blocks){
                    this.world.destroyBlock(pos, false);
                }
                this.Drain(blocksToDrain);
            }
        }
        if(!found) {
            ArrayList<BlockPos> blocks = new ArrayList<>();
            ArrayList<BlockPos> blocksToDrain = new ArrayList<>();
            for (int i = 0; i < 16; i++) {
                if (this.world.getBlockState(this.pos.add(0, 0, i)).getBlock() != Blocks.AIR) {
                    blocks.add(this.pos.add(0, 0, i));
                    blocks.add(this.pos.add(0, 1, i));
                    blocks.add(this.pos.add(0, 2, i));

                    blocksToDrain.add(this.pos.add(0, 0, i).down());
                    blocksToDrain.add(this.pos.add(0, 0, i).up().up().up());
                    blocksToDrain.add(this.pos.add(0, 0, i).west());
                    blocksToDrain.add(this.pos.add(0, 0, i).up().west());
                    blocksToDrain.add(this.pos.add(0, 0, i).up().up().west());
                    blocksToDrain.add(this.pos.add(0, 0, i).east());
                    blocksToDrain.add(this.pos.add(0, 0, i).up().east());
                    blocksToDrain.add(this.pos.add(0, 0, i).up().up().east());
                } else {
                    found = true;
                    break;
                }
            }
            if(found){
                for(BlockPos pos : blocks){
                    this.world.destroyBlock(pos, false);
                }
                this.Drain(blocksToDrain);
            }
        }
        if(!found) {
            ArrayList<BlockPos> blocksToDrain = new ArrayList<>();
            for (int i = 0; i < 16; i++) {
                this.world.destroyBlock(this.pos.add(0, 0, -i), false);
                this.world.destroyBlock(this.pos.add(0, 1, -i), false);
                this.world.destroyBlock(this.pos.add(0, 2, -i), false);

                if(this.world.getBlockState(this.pos.add(0, 0, -i)) != Blocks.AIR.getDefaultState()) {
                    blocksToDrain.add(this.pos.add(0, 0, -i).down());
                    blocksToDrain.add(this.pos.add(0, 0, -i).up().up().up());
                    blocksToDrain.add(this.pos.add(0, 0, -i).west());
                    blocksToDrain.add(this.pos.add(0, 0, -i).up().west());
                    blocksToDrain.add(this.pos.add(0, 0, -i).up().up().west());
                    blocksToDrain.add(this.pos.add(0, 0, -i).east());
                    blocksToDrain.add(this.pos.add(0, 0, -i).up().east());
                    blocksToDrain.add(this.pos.add(0, 0, -i).up().up().east());
                }
            }
            this.Drain(blocksToDrain);
        }
    }*/

    public int getColorFromChroma(){
        return this.chroma.color;
    }

    public void Drain(ArrayList<BlockPos> blockPosList){
        for (BlockPos pos : blockPosList){
            BlockState block = this.world.getBlockState(pos);
            if(block.getBlock() == ModBlocks.GEM_SEED_BLOCK.get() ||
                    block.getBlock() == ModBlocks.DRILL_BLOCK.get() || block.getBlock() == ModBlocks.TANK_BLOCK.get() ||
                    block.getBlock() == ModBlocks.POWER_CRYSTAL_BLOCK.get()){
                continue;
            }
            if(block == Blocks.DIRT.getDefaultState() || block == Blocks.GRASS_BLOCK.getDefaultState() || block == Blocks.GRASS_PATH.getDefaultState()
                    || block == Blocks.GRAVEL.getDefaultState()){
                this.world.setBlockState(pos, this.drained_soil.getDefaultState());
            }
            else if(block == Blocks.SAND.getDefaultState() || block == Blocks.RED_SAND.getDefaultState() || block == Blocks.SOUL_SAND.getDefaultState()){
                this.world.setBlockState(pos, this.drained_sand.getDefaultState());
            }
            else if(block == Blocks.OAK_LOG.getDefaultState() || block == Blocks.STRIPPED_OAK_LOG.getDefaultState() || block == Blocks.STRIPPED_OAK_WOOD.getDefaultState() || block == Blocks.OAK_WOOD
                    .getDefaultState() || block == Blocks.SPRUCE_LOG.getDefaultState() || block == Blocks.STRIPPED_SPRUCE_LOG.getDefaultState() || block == Blocks.STRIPPED_SPRUCE_WOOD.getDefaultState() || block == Blocks.SPRUCE_WOOD
                    .getDefaultState() || block == Blocks.BIRCH_LOG.getDefaultState() || block == Blocks.STRIPPED_BIRCH_LOG.getDefaultState() || block == Blocks.STRIPPED_BIRCH_WOOD.getDefaultState() || block == Blocks.BIRCH_WOOD
                    .getDefaultState() || block == Blocks.JUNGLE_LOG.getDefaultState() || block == Blocks.STRIPPED_JUNGLE_LOG.getDefaultState() || block == Blocks.STRIPPED_JUNGLE_WOOD.getDefaultState() || block == Blocks.JUNGLE_WOOD
                    .getDefaultState() || block == Blocks.ACACIA_LOG.getDefaultState() || block == Blocks.STRIPPED_ACACIA_LOG.getDefaultState() || block == Blocks.STRIPPED_ACACIA_WOOD.getDefaultState() || block == Blocks.ACACIA_WOOD
                    .getDefaultState() || block == Blocks.DARK_OAK_LOG.getDefaultState() || block == Blocks.STRIPPED_DARK_OAK_LOG.getDefaultState() || block == Blocks.STRIPPED_DARK_OAK_WOOD.getDefaultState() || block == Blocks.DARK_OAK_WOOD.getDefaultState()) {
                this.world.setBlockState(pos, this.drained_log.getDefaultState());
            }
            else if(block == Blocks.CRIMSON_STEM.getDefaultState() || block == Blocks.WARPED_STEM.getDefaultState() || block == Blocks.STRIPPED_CRIMSON_STEM.getDefaultState() || block == Blocks.STRIPPED_WARPED_STEM
                    .getDefaultState() || block == Blocks.CRIMSON_HYPHAE.getDefaultState() || block == Blocks.WARPED_HYPHAE.getDefaultState() || block == Blocks.STRIPPED_CRIMSON_HYPHAE.getDefaultState() || block == Blocks.STRIPPED_WARPED_HYPHAE.getDefaultState()) {
                this.world.setBlockState(pos, this.drained_log_cracked.getDefaultState());
            }
            else if(block == Blocks.BLUE_ICE.getDefaultState() || block == Blocks.PACKED_ICE.getDefaultState()) {
                this.world.setBlockState(pos, this.drained_ice.getDefaultState());
            }
            else{
                if(pos.getY() < 80) {
                    this.world.setBlockState(pos, this.drained_stone.getDefaultState());
                }
                else{
                    this.world.setBlockState(pos, this.drained_stone_2.getDefaultState());
                    if(pos.getY() % 6 == 0){
                        this.world.setBlockState(pos, this.banded_drained_stone.getDefaultState());
                    }
                }
                if(pos.getY() == 80){
                    this.world.setBlockState(pos, this.banded_drained_stone.getDefaultState());
                }
            }
        }
    }

    public void SetDrainedStoneColor(float temperature){
        if(temperature > .1f && temperature <= .5F){
            this.drained_sand = ModBlocks.DRAINED_SAND.get();
            this.drained_soil = ModBlocks.DRAINED_GREY_SOIL.get();
            this.drained_ice = ModBlocks.DRAINED_ICE.get();
            this.drained_stone = ModBlocks.DRAINED_GREY_STONE.get();
            this.drained_stone_2 = ModBlocks.DRAINED_GREY_STONE_2.get();
            this.banded_drained_stone = ModBlocks.DRAINED_BANDED_GREY_STONE.get();
            this.drained_log = ModBlocks.DRAINED_LOG.get();
            this.drained_log_cracked = ModBlocks.DRAINED_LOG_CRACKED.get();
        }
        else if(temperature > .5f && temperature <= .9f){
            this.drained_sand = ModBlocks.DRAINED_SAND.get();
            this.drained_soil = ModBlocks.DRAINED_PURPLE_SOIL.get();
            this.drained_ice = ModBlocks.DRAINED_ICE.get();
            this.drained_stone = ModBlocks.DRAINED_PURPLE_STONE.get();
            this.drained_stone_2 = ModBlocks.DRAINED_PURPLE_STONE_2.get();
            this.banded_drained_stone = ModBlocks.DRAINED_BANDED_PURPLE_STONE.get();
            this.drained_log = ModBlocks.DRAINED_LOG.get();
            this.drained_log_cracked = ModBlocks.DRAINED_LOG_CRACKED.get();
        }
        else if(temperature > .9f && temperature <= 1.2f){
            this.drained_sand = ModBlocks.DRAINED_SAND.get();
            this.drained_soil = ModBlocks.DRAINED_PURPLE_SOIL.get();
            this.drained_ice = ModBlocks.DRAINED_ICE.get();
            this.drained_stone = ModBlocks.DRAINED_YELLOW_STONE.get();
            this.drained_stone_2 = ModBlocks.DRAINED_YELLOW_STONE_2.get();
            this.banded_drained_stone = ModBlocks.DRAINED_BANDED_YELLOW_STONE.get();
            this.drained_log = ModBlocks.DRAINED_LOG.get();
            this.drained_log_cracked = ModBlocks.DRAINED_LOG_CRACKED.get();
        }
        else if(temperature > 1.2f && temperature <= 2f){
            this.drained_sand = ModBlocks.DRAINED_RED_SAND.get();
            this.drained_soil = ModBlocks.DRAINED_RED_SAND.get();
            this.drained_ice = ModBlocks.DRAINED_ICE.get();
            this.drained_stone = ModBlocks.DRAINED_RED_STONE.get();
            this.drained_stone_2 = ModBlocks.DRAINED_RED_STONE_2.get();
            this.banded_drained_stone = ModBlocks.DRAINED_BANDED_RED_STONE.get();
            this.drained_log = ModBlocks.DRAINED_LOG.get();
            this.drained_log_cracked = ModBlocks.DRAINED_LOG_CRACKED.get();
        }
        else{
            this.drained_sand = ModBlocks.DRAINED_SAND.get();
            this.drained_soil = ModBlocks.DRAINED_BLUE_SOIL.get();
            this.drained_ice = ModBlocks.DRAINED_ICE.get();
            this.drained_stone = ModBlocks.DRAINED_BLUE_STONE.get();
            this.drained_stone_2 = ModBlocks.DRAINED_BLUE_STONE_2.get();
            this.banded_drained_stone = ModBlocks.DRAINED_BANDED_BLUE_STONE.get();
            this.drained_log = ModBlocks.DRAINED_LOG.get();
            this.drained_log_cracked = ModBlocks.DRAINED_LOG_CRACKED.get();
        }
    }
}
