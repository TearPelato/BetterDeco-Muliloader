package net.tier1234.better_deco.screen.custom;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.tier1234.better_deco.init.ModBlocks;
import net.tier1234.better_deco.block.entity.custom.KitchenSinkBlockEntity;
import net.tier1234.better_deco.init.ModMenuTypes;

public class SinkMenu extends AbstractContainerMenu {
    public final KitchenSinkBlockEntity blockEntity;
    private final Level level;

    public SinkMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public SinkMenu(int containerId, Inventory inv, BlockEntity blockEntity) {
        super(ModMenuTypes.SINK_MENU.get(), containerId);
        this.blockEntity = ((KitchenSinkBlockEntity) blockEntity);
        this.level = inv.player.level();

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

    }


    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 4;  // must be the number of slots you have!
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.OAK_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.SPRUCE_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.BIRCH_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.JUNGLE_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.ACACIA_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.DARK_OAK_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.MANGROVE_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.CHERRY_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.BAMBOO_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.CRIMSON_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.WARPED_SINK.get())
                //Dark
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.OAK_SINK_DARK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.SPRUCE_SINK_DARK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.BIRCH_SINK_DARK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.JUNGLE_SINK_DARK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.ACACIA_SINK_DARK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.DARK_OAK_SINK_DARK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.MANGROVE_SINK_DARK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.CHERRY_SINK_DARK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.BAMBOO_SINK_DARK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.CRIMSON_SINK_DARK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.WARPED_SINK_DARK.get())

                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.RED_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.ORANGE_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.YELLOW_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.MAGENTA_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.PINK_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.PURPLE_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.BLUE_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.LIGHT_BLUE_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.CYAN_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.GREEN_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.LIME_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.GRAY_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.LIGHT_GRAY_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.BLACK_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.BROWN_SINK.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.WHITE_SINK.get());



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
}

