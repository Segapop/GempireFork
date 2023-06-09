package com.gempire.container;

import com.gempire.gui.ChromaSlot;
import com.gempire.init.ModBlocks;
import com.gempire.init.ModContainers;
import com.gempire.tileentities.InjectorTE;
import com.gempire.tileentities.TankTE;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

public class InjectorContainer extends Container {
    public static final int HOTBAR_SLOT_COUNT = 9;
    public static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    public static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    public static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    public static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;

    public static final int VANILLA_FIRST_SLOT_INDEX = 0;
    public static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    public static final int TE_INVENTORY_SLOT_COUNT = TankTE.NUMBER_OF_SLOTS;

    public static final int TILE_INVENTORY_YPOS = 20;
    public static final int PLAYER_INVENTORY_YPOS = 51;

    public final IWorldPosCallable canInteract;

    public final InjectorTE injector;

    public InjectorContainer(int windowID, PlayerInventory playerInventory, InjectorTE injector) {
        super(ModContainers.INJECTOR_CONTAINER.get(), windowID);
        this.injector = injector;
        this.canInteract = IWorldPosCallable.of(this.injector.getWorld(), this.injector.getPos());

        //TILE ENTITY
        this.addSlot(new Slot((IInventory)this.injector, InjectorTE.WHITE_INPUT_SLOT_INDEX, 61, 14));
        this.addSlot(new Slot((IInventory)this.injector, InjectorTE.YELLOW_INPUT_SLOT_INDEX, 43, 32));
        this.addSlot(new ChromaSlot((IInventory)this.injector, InjectorTE.CHROMA_INPUT_SLOT_INDEX, 61, 32));
        this.addSlot(new Slot((IInventory)this.injector, InjectorTE.BLUE_INPUT_SLOT_INDEX, 79, 32));
        this.addSlot(new Slot((IInventory)this.injector, InjectorTE.PRIME_INPUT_SLOT_INDEX, 43, 50));
        this.addSlot(new Slot((IInventory)this.injector, InjectorTE.PINK_INPUT_SLOT_INDEX, 61, 50));

        //PLAYER INVENTORY
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 9; col++){
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 165 - (4 - row) * 18 - 10));
            }
        }

        //PLAYER HOTBAR
        for(int col = 0; col < 9; col++){
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 141));
        }
    }

    public InjectorContainer(int windowID, PlayerInventory playerInventory, PacketBuffer extraData){
        this(windowID, playerInventory, InjectorContainer.getTileEntity(playerInventory, extraData));
    }

    public static InjectorTE getTileEntity(PlayerInventory playerInventory, PacketBuffer extraData){
        Objects.requireNonNull(playerInventory, "Player Inventory can not be null");
        Objects.requireNonNull(extraData, "Data Packet can not be null");
        TileEntity te = playerInventory.player.world.getTileEntity(extraData.readBlockPos());
        if(te instanceof InjectorTE){
            return (InjectorTE)te;
        }
        throw new IllegalStateException("Tile entity is not correct");
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return this.isWithinUsableDistance(this.canInteract, playerIn, ModBlocks.DRILL_BLOCK.get());
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if(slot != null && slot.getHasStack()){
            ItemStack slotStack = slot.getStack();
            stack = slotStack.copy();
            if(index < InjectorTE.NUMBER_OF_SLOTS && !this.mergeItemStack(slotStack, InjectorTE.NUMBER_OF_SLOTS, this.inventorySlots.size(), true)){
                return ItemStack.EMPTY;
            }
            if(!this.mergeItemStack(slotStack, 0, InjectorTE.NUMBER_OF_SLOTS, false)){
                return ItemStack.EMPTY;
            }
            if(slotStack.isEmpty()){
                slot.putStack(ItemStack.EMPTY);
            }
            else{
                slot.onSlotChanged();
            }
        }
        return stack;
    }
}