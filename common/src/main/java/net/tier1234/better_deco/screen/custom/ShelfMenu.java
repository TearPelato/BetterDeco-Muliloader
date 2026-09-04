package net.tier1234.better_deco.screen.custom;

import com.mrcrayfish.framework.api.menu.IMenuData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.blockentity.ShelfBlockEntity;
import net.tier1234.better_deco.registries.ModMenuTypes;

public class ShelfMenu extends AbstractContainerMenu {
    public final ShelfBlockEntity blockEntity;
    private final Level level;


    public ShelfMenu(int containerId, Inventory inv, ShelfMenu.CustomData data) {
        this(containerId, inv, inv.player.level().getBlockEntity(data.pos()));
    }

    public ShelfMenu(int containerId, Inventory inv, BlockEntity blockEntity) {
        super(ModMenuTypes.SHELF_MENU.get(), containerId);
        this.blockEntity = ((ShelfBlockEntity) blockEntity);
        this.level = inv.player.level();

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.addSlot(new Slot(this.blockEntity.handler, 0, 71, 17));
        this.addSlot(new Slot(this.blockEntity.handler, 1, 89, 17));
        this.addSlot(new Slot(this.blockEntity.handler, 2, 71, 35));
        this.addSlot(new Slot(this.blockEntity.handler, 3, 89, 35));
    }


    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT; // 36
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT; // 36
    private static final int TE_INVENTORY_SLOT_COUNT = 4; // <-- FIX: erano davvero 6, ma gli slot aggiunti sono 4

    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX,
                    TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX,
                    VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            return ItemStack.EMPTY;
        }

        if (sourceStack.isEmpty()) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }

        sourceSlot.onTake(playerIn, sourceStack);
        blockEntity.setChanged();

        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.ACACIA_SHELF.get())
        ||
        stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.OAK_SHELF.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.BIRCH_SHELF.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.JUNGLE_SHELF.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.SPRUCE_SHELF.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.CHERRY_SHELF.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.BAMBOO_SHELF.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.DARK_OAK_SHELF.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.MANGROVE_SHELF.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.CRIMSON_SHELF.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.WARPED_SHELF.get());



    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    public record CustomData(BlockPos pos) implements IMenuData {

        public static final StreamCodec<RegistryFriendlyByteBuf, ShelfMenu.CustomData> CODEC =
                StreamCodec.composite(
                        BlockPos.STREAM_CODEC,
                        ShelfMenu.CustomData::pos,
                        ShelfMenu.CustomData::new
                );

        @Override
        public StreamCodec codec() {
            return CODEC;
        }
    }
}
