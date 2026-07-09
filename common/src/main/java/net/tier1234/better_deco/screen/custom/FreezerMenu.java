package net.tier1234.better_deco.screen.custom;


import com.mrcrayfish.framework.api.menu.IMenuData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.tier1234.better_deco.block.entity.custom.FreezerBlockEntity;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModMenuTypes;
import net.tier1234.better_deco.screen.slot.FreezerFuelSlot;
import net.tier1234.better_deco.screen.slot.FreezerOutputSlot;

public class FreezerMenu extends AbstractContainerMenu {
    public final FreezerBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public FreezerMenu(int containerId, Inventory inv, FreezerMenu.FreezerData data) {
       this(containerId, inv, inv.player.level().getBlockEntity(data.pos()), new SimpleContainerData(4));
    }


    public FreezerMenu(int containerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.FREEZER_MENU.get(), containerId);
        this.blockEntity = (FreezerBlockEntity) entity;
        this.level = inv.player.level();
        this.data = data;

        this.addSlot(new Slot(blockEntity.itemHandler, 0, 56, 17));//input
        this.addSlot(new FreezerOutputSlot(blockEntity.itemHandler, 1, 116, 35));//output
        this.addSlot(new FreezerFuelSlot(blockEntity.itemHandler, 2, 56, 53));//fuel

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        addDataSlots(data);
    }


    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledArrowProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int arrowPixelSize = 24;
        return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
    }

    public float getFreezProgress() {
        int litTime = this.data.get(2);
        int litDuration = this.data.get(3);
        if (litDuration == 0) litDuration = 200;
        return Mth.clamp((float) litTime / (float) litDuration, 0.0F, 1.0F);
    }


    public boolean isFreezing() {
        return this.data.get(2) > 0;
    }


    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    private static final int TE_INVENTORY_SLOT_COUNT = 3;

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        }
        else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slot index: " + index);
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(player, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player,
                ModBlocks.FRIDGE_DARK.get())
                ||
                stillValid(ContainerLevelAccess.create(level,blockEntity.getBlockPos()),player,
                        ModBlocks.FRIDGE_LIGHT.get());


    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

        public record FreezerData(BlockPos pos) implements IMenuData<FreezerMenu.FreezerData> {

            public static final StreamCodec<RegistryFriendlyByteBuf, FreezerMenu.FreezerData> CODEC =
                    StreamCodec.composite(
                            BlockPos.STREAM_CODEC,
                            FreezerMenu.FreezerData::pos,
                            FreezerMenu.FreezerData::new
                    );


            public FreezerMenu.FreezerData self() {
                return this;
            }

            @Override
            public StreamCodec<RegistryFriendlyByteBuf, FreezerMenu.FreezerData> codec() {
                return CODEC;
            }
        }

    }