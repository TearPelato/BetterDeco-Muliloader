package net.tier1234.better_deco.screen.custom;


import com.mrcrayfish.framework.api.menu.IMenuData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.tier1234.better_deco.block.entity.custom.OvenBlockEntity;
import net.tier1234.better_deco.init.ModBlocks;
import net.tier1234.better_deco.init.ModMenuTypes;

public class OvenMenu extends AbstractContainerMenu {
    public final OvenBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public OvenMenu(int pContainerId, Inventory inv, CustomData data) {
        this(pContainerId, inv,
                inv.player.level().getBlockEntity(data.pos()),
                new SimpleContainerData(3));
    }

    public OvenMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(3));
    }

    public OvenMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.OVEN_MENU.get(), pContainerId);
        this.blockEntity = ((OvenBlockEntity) entity);
        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        // Input
        this.addSlot(new Slot(blockEntity.itemHandler, 0, 60, 17));
        this.addSlot(new Slot(blockEntity.itemHandler, 1, 78, 17));
        this.addSlot(new Slot(blockEntity.itemHandler, 2, 96, 17));

        // Output
        this.addSlot(new Slot(blockEntity.itemHandler, 3, 60, 53));
        this.addSlot(new Slot(blockEntity.itemHandler, 4, 78, 53));
        this.addSlot(new Slot(blockEntity.itemHandler, 5, 96, 53));

        addDataSlots(data);
    }

    public boolean isCrafting() {
        for(int i = 0; i < 3; i++){
            if(data.get(i) > 0) return true;
        }
        return false;
    }

    public int getScaledArrowProgress(int i) {
        int progress = this.data.get(i);
        int arrowPixelSize = 16;
        int maxProgress = 72;
        return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
    }

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    private static final int TE_INVENTORY_SLOT_COUNT = 6;

    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.OAK_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.SPRUCE_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.BIRCH_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.JUNGLE_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.ACACIA_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.DARK_OAK_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.MANGROVE_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.CHERRY_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.BAMBOO_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.CRIMSON_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.WARPED_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.SPRUCE_DIORITE_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.DARK_OAK_CALCITE_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.OAK_ANDESITE_OVEN.get())

                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.RED_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.ORANGE_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.YELLOW_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.MAGENTA_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.PINK_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.PURPLE_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.BLUE_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.LIGHT_BLUE_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.GREEN_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.LIME_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.CYAN_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.WHITE_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.BLACK_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.BROWN_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.LIGHT_GRAY_OVEN.get())
                || stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.GRAY_OVEN.get());



    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 102 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 160));
        }
    }


    public record CustomData(BlockPos pos, int progress1, int progress2, int progress3) implements IMenuData<CustomData> {

        public static final StreamCodec<RegistryFriendlyByteBuf, CustomData> CODEC =
                StreamCodec.composite(
                        BlockPos.STREAM_CODEC,
                        CustomData::pos,
                        ByteBufCodecs.VAR_INT,
                        CustomData::progress1,
                        ByteBufCodecs.VAR_INT,
                        CustomData::progress2,
                        ByteBufCodecs.VAR_INT,
                        CustomData::progress3,
                        CustomData::new
                );

        @Override
        public StreamCodec codec() {
            return CODEC;
        }
    }
}