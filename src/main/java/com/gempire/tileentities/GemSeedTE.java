package com.gempire.tileentities;

import com.gempire.blocks.DrainedBlock;
import com.gempire.blocks.GemSeedBlock;
import com.gempire.entities.bases.EntityGem;
import com.gempire.entities.gems.EntityRuby;
import com.gempire.entities.gems.starter.EntityPebble;
import com.gempire.events.GemFormEvent;
import com.gempire.init.*;
import com.gempire.items.ItemChroma;
import com.gempire.systems.injection.Crux;
import com.gempire.systems.injection.GemConditions;
import com.gempire.systems.injection.GemFormation;
import com.mojang.datafixers.types.Type;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

public class GemSeedTE extends TileEntity implements ITickableTileEntity {
    Random random;
    boolean spawned = false;
    public int ticks = 0;
    public int stage = 0;
    public static final int STAGE_LIFETIME = 60;
    public static final int STAGES = 3;
    public static final int DRAIN_SIZE = 11;
    public ItemChroma chroma;
    public Item primer;
    public String essences = "pink-blue-yellow-white";
    public int facing;
    public boolean checked = false;
    public Block drained_sand, drained_soil, drained_stone, drained_stone_2, banded_drained_stone, drained_log, drained_log_cracked, drained_ice;

    public HashMap<Integer, BlockPos> POSITIONS = new HashMap<>();
    public ArrayList<Integer> IDS = new ArrayList<>();

    //INPUT: List of gems and their cruxes as well as crux temperatures and depth preferences, list of blocks to check
    HashMap<String, GemConditions> GEM_CONDITIONS = new HashMap<>();

    //Create an object to store the gems and their weights once the cruxes have been evaluated
    HashMap<String, Float> WEIGHTS_OF_GEMS = new HashMap<>();
    public ArrayList<ArrayList<Float>> TEMPORARY_WEIGHTS = new ArrayList<>();

    //Create an object to store the total weight
    float totalWeight = 0;

    public GemSeedTE() {
        super(ModTE.GEM_SEED_TE.get());
        this.random = new Random();
        for(int i = 0; i < GemFormation.POSSIBLE_GEMS.size(); i++){
            this.TEMPORARY_WEIGHTS.add(i, new ArrayList<Float>());
        }
    }

    @Override
    public void tick() {
        //System.out.println("Gem List is of size: " + GemFormation.POSSIBLE_GEMS.size());
        if(!this.checked){
           this.ScanPositions(this.world, this.pos, new BlockPos(DRAIN_SIZE, DRAIN_SIZE, DRAIN_SIZE));
           this.checked = true;
        }
        if(this.ticks % 1 == 0) {
            if (!this.spawned && this.checked) {
                if (this.IDS.size() > 0) {
                    int rando = this.random.nextInt(this.IDS.size());
                    this.DrainBlock(this.POSITIONS.get(this.IDS.get(rando)));
                    this.IDS.remove(rando);
                    this.markDirty();
                } else {
                    this.spawned = true;
                    for (int i = 0; i < GemFormation.POSSIBLE_GEMS.size(); i++) {
                        float weight = 0;
                        for (int n = 0; n < this.TEMPORARY_WEIGHTS.get(i).size(); n++) {
                            weight += this.TEMPORARY_WEIGHTS.get(i).get(n);
                        }
                        WEIGHTS_OF_GEMS.put(GemFormation.POSSIBLE_GEMS.get(i), weight);
                    }
                    GemFormation form = new GemFormation(this.world, this.pos, new BlockPos(GemSeedTE.DRAIN_SIZE, GemSeedTE.DRAIN_SIZE, GemSeedTE.DRAIN_SIZE), this.chroma, this.primer, this.essences, this.facing, this.WEIGHTS_OF_GEMS, this.totalWeight);
                    form.SpawnGem();
                    this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 2);
                    this.markDirty();
                }
            }
        }
        this.ticks++;
    }

    public void ScanPositions(World domhain, BlockPos position, BlockPos volume) {
        int id = 0;
        float xo = GemFormation.getHalfMiddleOffsetRight(volume.getX());
        float yo = GemFormation.getHalfMiddleOffsetRight(volume.getY());
        float zo = GemFormation.getHalfMiddleOffsetRight(volume.getZ());
        for (int z = GemFormation.getHalfMiddleOffsetLeft(volume.getZ()); z < zo; z++) {
            for (int y = GemFormation.getHalfMiddleOffsetLeft(volume.getY()); y < yo; y++) {
                for (int x = GemFormation.getHalfMiddleOffsetLeft(volume.getX()); x < xo; x++) {
                    BlockPos block = position.add(new BlockPos(x, y, z));
                    if (domhain.getBlockState(block).getBlock() instanceof FlowingFluidBlock || domhain.getBlockState(block).getBlock() instanceof AirBlock || World.isOutsideBuildHeight(block)) {
                        continue;
                    } else {
                        if(this.random.nextInt(10) > 3) {
                            this.POSITIONS.put(id, block);
                            this.IDS.add(id);
                            id++;
                        }
                    }
                }
            }
        }
    }

    public void DrainBlock(BlockPos blockPos) {
        this.GEM_CONDITIONS = ModEntities.CRUXTOGEM;
        float BLOCK_TEMPERATURE = this.world.getBiome(this.pos).getTemperature(this.pos);
        this.SetDrainedStoneColor(BLOCK_TEMPERATURE);
        Block block = this.world.getBlockState(blockPos).getBlock();
        if(block instanceof DrainedBlock) return;
        for (int i = 0; i < GemFormation.POSSIBLE_GEMS.size(); i++) {
            String gem = GemFormation.POSSIBLE_GEMS.get(i);
            float gemWeight = 0;
            if (GEM_CONDITIONS.get(gem) != null) {
                GemConditions conditions = GEM_CONDITIONS.get(gem);
                boolean weighThisGem = false;
                //Do some math to multiply the gem weight by the inverse of the difference in biome temperature to preferred temperature
                float temperatureDifference = 0;
                if (BLOCK_TEMPERATURE >= conditions.temperatureMin) {
                    if (BLOCK_TEMPERATURE <= conditions.temperatureMax) {
                        temperatureDifference = 0;
                    } else {
                        temperatureDifference = conditions.temperatureMax - BLOCK_TEMPERATURE == 0 ? 1 : Math.abs(conditions.temperatureMax - BLOCK_TEMPERATURE);
                    }
                } else {
                    temperatureDifference = conditions.temperatureMin - BLOCK_TEMPERATURE == 0 ? 1 : Math.abs(conditions.temperatureMin - BLOCK_TEMPERATURE);
                }
                int essenceCount = 0;
                String[] indEssencesInj = this.essences.split("-");
                String[] indEssencesCond = conditions.essences.split("-");
                for(int n = 0; n < indEssencesInj.length; n++){
                    String essJ = indEssencesInj[n];
                    for(int j = 0; j < indEssencesCond.length; j++){
                        String essC = indEssencesCond[j];
                        if(essJ.equalsIgnoreCase(essC)){
                            essenceCount++;
                        }
                    }
                }
                if(essenceCount == indEssencesCond.length){
                    weighThisGem = true;
                }
                if(weighThisGem) {
                    for (Crux crux : GEM_CONDITIONS.get(gem).cruxes) {
                        //Then for every crux, calculate the total weight of crux that matches every block in the volume for every gem
                        //Example: if there are three stone in the volume, the total weight will be 3 stone times however many gems there are that have stone as a crux, and so forth
                        if (block != crux.block) {
                            continue;
                        } else {
                            totalWeight += 1;
                            totalWeight += crux.weight * GEM_CONDITIONS.get(gem).rarity;
                            gemWeight += 1 * (1 - temperatureDifference);
                            gemWeight += crux.weight * (1 - temperatureDifference);
                            gemWeight *= GEM_CONDITIONS.get(gem).rarity;
                        }
                    }
                }
                if(this.primer == conditions.primer && conditions.primer != Items.AIR && this.primer != Items.AIR){
                    gemWeight *= 3;
                }
                //Once the total weight has been obtained, store the individual weights of every gem in a hashmap.
                if(weighThisGem) {
                    TEMPORARY_WEIGHTS.get(i).add(gemWeight);
                }
                else {
                    TEMPORARY_WEIGHTS.get(i).add(0f);
                }
            }
            else{
                TEMPORARY_WEIGHTS.get(i).add(0f);
            }
        }
        if(!(block instanceof AirBlock) &&
                !(block.isTransparent(block.getDefaultState())) &&
                !(block instanceof SlabBlock) &&
                !(block instanceof BushBlock) &&
                !(block instanceof SnowBlock)){
            if(block.getBlock() == ModBlocks.GEM_SEED_BLOCK.get() ||
                    block.getBlock() == ModBlocks.DRILL_BLOCK.get() || block.getBlock() == ModBlocks.TANK_BLOCK.get() ||
                    block.getBlock() == ModBlocks.POWER_CRYSTAL_BLOCK.get()){

            }
            else if(block == Blocks.DIRT || block == Blocks.GRASS_BLOCK || block == Blocks.GRASS_PATH
                    || block == Blocks.GRAVEL){
                this.world.setBlockState(blockPos, this.drained_soil.getDefaultState());
            }
            else if(block == Blocks.SAND || block == Blocks.RED_SAND || block == Blocks.SOUL_SAND){
                this.world.setBlockState(blockPos, this.drained_sand.getDefaultState());
            }
            else if(block instanceof BushBlock){
                this.world.setBlockState(blockPos, Blocks.DEAD_BUSH.getDefaultState());
            }
            else if(block == Blocks.OAK_LOG || block == Blocks.STRIPPED_OAK_LOG || block == Blocks.STRIPPED_OAK_WOOD || block == Blocks.OAK_WOOD
                    || block == Blocks.SPRUCE_LOG || block == Blocks.STRIPPED_SPRUCE_LOG || block == Blocks.STRIPPED_SPRUCE_WOOD|| block == Blocks.SPRUCE_WOOD
                    || block == Blocks.BIRCH_LOG|| block == Blocks.STRIPPED_BIRCH_LOG || block == Blocks.STRIPPED_BIRCH_WOOD || block == Blocks.BIRCH_WOOD
                    || block == Blocks.JUNGLE_LOG || block == Blocks.STRIPPED_JUNGLE_LOG || block == Blocks.STRIPPED_JUNGLE_WOOD || block == Blocks.JUNGLE_WOOD
                    || block == Blocks.ACACIA_LOG || block == Blocks.STRIPPED_ACACIA_LOG || block == Blocks.STRIPPED_ACACIA_WOOD || block == Blocks.ACACIA_WOOD
                    || block == Blocks.DARK_OAK_LOG || block == Blocks.STRIPPED_DARK_OAK_LOG || block == Blocks.STRIPPED_DARK_OAK_WOOD || block == Blocks.DARK_OAK_WOOD) {
                this.world.setBlockState(blockPos, this.drained_log.getDefaultState());
            }
            else if(block == Blocks.CRIMSON_STEM || block == Blocks.WARPED_STEM || block == Blocks.STRIPPED_CRIMSON_STEM || block == Blocks.STRIPPED_WARPED_STEM
                    || block == Blocks.CRIMSON_HYPHAE || block == Blocks.WARPED_HYPHAE || block == Blocks.STRIPPED_CRIMSON_HYPHAE || block == Blocks.STRIPPED_WARPED_HYPHAE) {
                this.world.setBlockState(blockPos, this.drained_log_cracked.getDefaultState());
            }
            else if(block == Blocks.BLUE_ICE || block == Blocks.PACKED_ICE) {
                this.world.setBlockState(blockPos, this.drained_ice.getDefaultState());
            }
            else{
                if(blockPos.getY() < 80) {
                    this.world.setBlockState(blockPos, this.drained_stone.getDefaultState());
                }
                else{
                    this.world.setBlockState(blockPos, this.drained_stone_2.getDefaultState());
                    if(blockPos.getY() % 6 == 0){
                        this.world.setBlockState(blockPos, this.banded_drained_stone.getDefaultState());
                    }
                }
                if(blockPos.getY() == 80){
                    this.world.setBlockState(blockPos, this.banded_drained_stone.getDefaultState());
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


    public void SetChroma(ItemChroma chroma){
        this.chroma = chroma;
        this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 2);
        this.markDirty();
    }

    public ItemChroma getChroma(){
        return this.chroma;
    }

    public void SetPrimer(Item primer){
        this.primer = primer;
        this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 2);
        this.markDirty();
    }

    public Item getPrimer(){
        return this.primer;
    }

    public void setEssences(String essec){
        this.essences = essec;
        this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 2);
        this.markDirty();
    }

    public String getEssences(){
        return this.essences;
    }

    public void setFacing(int facing){
        this.facing = facing;
        this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 2);
        this.markDirty();
    }

    public int getFacing(){
        return this.facing;
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.putInt("stage", this.stage);
        compound.putBoolean("spawned", this.spawned);
        compound.put("chroma", new ItemStack(this.chroma).write(new CompoundNBT()));
        compound.put("primer", new ItemStack(this.primer).write(new CompoundNBT()));
        compound.putString("essences", this.essences);
        compound.putInt("facing", this.facing);
        compound.putBoolean("checked", this.checked);

        //SAVING CRUX STUFF
        compound.putFloat("totalWeight", this.totalWeight);

        //IDS
        compound.putIntArray("IDS", this.IDS);

        //TEMPORARY_WEIGHTS
        if(this.TEMPORARY_WEIGHTS.size() > 0)for(int i = 0; i < GemFormation.POSSIBLE_GEMS.size(); i++){
            float weight = 0;
            System.out.println("Gem List Cycle: " + i);
            for(int n = 0; n < this.TEMPORARY_WEIGHTS.get(i).size(); n++){
                weight += this.TEMPORARY_WEIGHTS.get(i).get(n);
            }
            compound.putFloat(GemFormation.POSSIBLE_GEMS.get(i) + "_weight", weight);
        }

        //POSITIONS
        ArrayList<Integer> xs = new ArrayList<>();
        ArrayList<Integer> ys = new ArrayList<>();
        ArrayList<Integer> zs = new ArrayList<>();
        ArrayList<BlockPos> positions = new ArrayList<>();
        for (int i : this.POSITIONS.keySet()){
            BlockPos pos = this.POSITIONS.get(i);
            positions.add(pos);
        }
        for(BlockPos pos : positions){
            xs.add(pos.getX());ys.add(pos.getY());zs.add(pos.getZ());
        }
        compound.putIntArray("xs", xs);
        compound.putIntArray("ys", ys);
        compound.putIntArray("zs", zs);

        return compound;
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.GEM_CONDITIONS = ModEntities.CRUXTOGEM;
        this.stage = nbt.getInt("stage");
        this.spawned = nbt.getBoolean("spawned");
        ItemStack chroma = ItemStack.read(nbt.getCompound("chroma"));
        this.chroma = (ItemChroma)chroma.getItem();
        ItemStack primer = ItemStack.read(nbt.getCompound("primer"));
        this.primer = primer.getItem();
        String fluids = nbt.getString("essences");
        this.essences = fluids;
        this.facing = nbt.getInt("facing");
        this.checked = nbt.getBoolean("checked");

        //LOADING CRUX STUFF
        this.totalWeight = nbt.getFloat("totalWeight");
        this.setIDS(nbt);
        this.setTEMPORARY_WEIGHTS(nbt);
        this.setPOSITIONS(nbt);
    }

    public void setIDS(CompoundNBT nbt){
        int[] TEMPIDS = nbt.getIntArray("IDS");
        for(int i = 0; i < TEMPIDS.length; i++){
            this.IDS.add(i, TEMPIDS[i]);
        }
    }

    public void setTEMPORARY_WEIGHTS(CompoundNBT nbt){
        if(this.TEMPORARY_WEIGHTS.size() == GemFormation.POSSIBLE_GEMS.size())for(int i = 0; i < GemFormation.POSSIBLE_GEMS.size(); i++){
            float weight = nbt.getFloat(GemFormation.POSSIBLE_GEMS.get(i) + "_weight");
            this.TEMPORARY_WEIGHTS.get(i).add(weight);
        }
    }

    public void setPOSITIONS(CompoundNBT nbt){
        for(int i = 0; i < nbt.getIntArray("xs").length; i++){
            int[] xs = nbt.getIntArray("xs");
            int[] ys = nbt.getIntArray("ys");
            int[] zs = nbt.getIntArray("zs");
            this.POSITIONS.put(i, new BlockPos(xs[i], ys[i], zs[i]));
        }
    }

    public static String StringFromFluid(Fluid fluid){
        if(fluid == ModFluids.PINK_ESSENCE.get()){
            return "pink";
        }
        else if(fluid == ModFluids.BLUE_ESSENCE.get()){
            return "blue";
        }
        else if(fluid == ModFluids.YELLOW_ESSENCE.get()){
            return "yellow";
        }
        else if(fluid == ModFluids.WHITE_ESSENCE.get()){
            return "white";
        }
        else{
            return "";
        }
    }

    public static Fluid FluidFromString(String fluid){
        if(fluid == "pink"){
            return ModFluids.PINK_ESSENCE.get();
        }
        else if(fluid == "blue"){
            return ModFluids.BLUE_ESSENCE.get();
        }
        else if(fluid == "yellow"){
            return ModFluids.YELLOW_ESSENCE.get();
        }
        else if(fluid == "white"){
            return ModFluids.WHITE_ESSENCE.get();
        }
        else {
            return Fluids.EMPTY;
        }
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        //Debug
        System.out.println("[DEBUG]:Client recived tile sync packet");
        this.read(this.world.getBlockState(pkt.getPos()), pkt.getNbtCompound());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        return this.write(new CompoundNBT());
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        //Debug
        System.out.println("[DEBUG]:Server sent tile sync packet");
        return new SUpdateTileEntityPacket(this.pos, -1, this.getUpdateTag());
    }

    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        System.out.println("[DEBUG]:Handling tag on chunk load");
        this.read(state, tag);
    }
}
