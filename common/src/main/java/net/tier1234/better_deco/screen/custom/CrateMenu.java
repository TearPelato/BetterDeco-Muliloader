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
import net.tier1234.better_deco.block.entity.custom.CrateBlockEntity;
import net.tier1234.better_deco.init.ModBlocks;
import net.tier1234.better_deco.init.ModMenuTypes;

public class CrateMenu extends AbstractContainerMenu {
    public final CrateBlockEntity blockEntity;
    public final Level level;


   public CrateMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId,inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public CrateMenu(int containerId, Inventory inv, CrateMenu.CustomData data) {
        this(containerId, inv, inv.player.level().getBlockEntity(data.pos()));
    }

    public CrateMenu(int containerId, Inventory inv, BlockEntity blockEntity) {
       super(ModMenuTypes.CRATE_MENU.get(), containerId);
       this.blockEntity= ((CrateBlockEntity) blockEntity);
       this.level = inv.player.level();
       addPlayerInventory(inv);
        addPlayerHotbar(inv);

        //First Row
        this.addSlot(new Slot(this.blockEntity.inventory,0,8,18));
        this.addSlot(new Slot(this.blockEntity.inventory,1,26,18));
        this.addSlot(new Slot(this.blockEntity.inventory,2,44,18));
        this.addSlot(new Slot(this.blockEntity.inventory,3,62,18));
        this.addSlot(new Slot(this.blockEntity.inventory,4,80,18));
        this.addSlot(new Slot(this.blockEntity.inventory,5,98,18));
        this.addSlot(new Slot(this.blockEntity.inventory,6,116,18));
        this.addSlot(new Slot(this.blockEntity.inventory,7,134,18));
        this.addSlot(new Slot(this.blockEntity.inventory,8,152,18));
        this.addSlot(new Slot(this.blockEntity.inventory,9,170,18));
        this.addSlot(new Slot(this.blockEntity.inventory,10,188,18));
        //Second Row
        this.addSlot(new Slot(this.blockEntity.inventory,11,8,36));
        this.addSlot(new Slot(this.blockEntity.inventory,12,26,36));
        this.addSlot(new Slot(this.blockEntity.inventory,13,44,36));
        this.addSlot(new Slot(this.blockEntity.inventory,14,62,36));
        this.addSlot(new Slot(this.blockEntity.inventory,15,80,36));
        this.addSlot(new Slot(this.blockEntity.inventory,16,98,36));
        this.addSlot(new Slot(this.blockEntity.inventory,17,116,36));
        this.addSlot(new Slot(this.blockEntity.inventory,18,134,36));
        this.addSlot(new Slot(this.blockEntity.inventory,19,152,36));
        this.addSlot(new Slot(this.blockEntity.inventory,20,170,36));
        this.addSlot(new Slot(this.blockEntity.inventory,21,188,36));
        //Third Row
        this.addSlot(new Slot(this.blockEntity.inventory,22,8,54));
        this.addSlot(new Slot(this.blockEntity.inventory,23,26,54));
        this.addSlot(new Slot(this.blockEntity.inventory,24,44,54));
        this.addSlot(new Slot(this.blockEntity.inventory,25,62,54));
        this.addSlot(new Slot(this.blockEntity.inventory,26,80,54));
        this.addSlot(new Slot(this.blockEntity.inventory,27,98,54));
        this.addSlot(new Slot(this.blockEntity.inventory,28,116,54));
        this.addSlot(new Slot(this.blockEntity.inventory,29,134,54));
        this.addSlot(new Slot(this.blockEntity.inventory,30,152,54));
        this.addSlot(new Slot(this.blockEntity.inventory,31,170,54));
        this.addSlot(new Slot(this.blockEntity.inventory,32,188,54));
        //Fourth Row
        this.addSlot(new Slot(this.blockEntity.inventory,33,8,72));
        this.addSlot(new Slot(this.blockEntity.inventory,34,26,72));
        this.addSlot(new Slot(this.blockEntity.inventory,35,44,72));
        this.addSlot(new Slot(this.blockEntity.inventory,36,62,72));
        this.addSlot(new Slot(this.blockEntity.inventory,37,80,72));
        this.addSlot(new Slot(this.blockEntity.inventory,38,98,72));
        this.addSlot(new Slot(this.blockEntity.inventory,39,116,72));
        this.addSlot(new Slot(this.blockEntity.inventory,40,134,72));
        this.addSlot(new Slot(this.blockEntity.inventory,41,152,72));
        this.addSlot(new Slot(this.blockEntity.inventory,42,170,72));
        this.addSlot(new Slot(this.blockEntity.inventory,43,188,72));
        //Fifth Row
        this.addSlot(new Slot(this.blockEntity.inventory,44,8,90));
        this.addSlot(new Slot(this.blockEntity.inventory,45,26,90));
        this.addSlot(new Slot(this.blockEntity.inventory,46,44,90));
        this.addSlot(new Slot(this.blockEntity.inventory,47,62,90));
        this.addSlot(new Slot(this.blockEntity.inventory,48,80,90));
        this.addSlot(new Slot(this.blockEntity.inventory,49,98,90));
        this.addSlot(new Slot(this.blockEntity.inventory,50,116,90));
        this.addSlot(new Slot(this.blockEntity.inventory,51,134,90));
        this.addSlot(new Slot(this.blockEntity.inventory,52,152,90));
        this.addSlot(new Slot(this.blockEntity.inventory,53,170,90));
        this.addSlot(new Slot(this.blockEntity.inventory,54,188,90));
        //Sixth Row
        this.addSlot(new Slot(this.blockEntity.inventory,55,8,108));
        this.addSlot(new Slot(this.blockEntity.inventory,56,26,108));
        this.addSlot(new Slot(this.blockEntity.inventory,57,44,108));
        this.addSlot(new Slot(this.blockEntity.inventory,58,62,108));
        this.addSlot(new Slot(this.blockEntity.inventory,59,80,108));
        this.addSlot(new Slot(this.blockEntity.inventory,60,98,108));
        this.addSlot(new Slot(this.blockEntity.inventory,61,116,108));
        this.addSlot(new Slot(this.blockEntity.inventory,62,134,108));
        this.addSlot(new Slot(this.blockEntity.inventory,63,152,108));
        this.addSlot(new Slot(this.blockEntity.inventory,64,170,108));
        this.addSlot(new Slot(this.blockEntity.inventory,65,188,108));

    }

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 66;  // must be the number of slots you have!
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
                player, ModBlocks.OAK_CRATE.get())
                ||
        stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.WARPED_CRATE.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.SPRUCE_CRATE.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.BIRCH_CRATE.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.JUNGLE_CRATE.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.ACACIA_CRATE.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.DARK_OAK_CRATE.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.MANGROVE_CRATE.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.CHERRY_CRATE.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.BAMBOO_CRATE.get())
                ||
                stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, ModBlocks.CRIMSON_CRATE.get());

    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 26 + l * 18, 152 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 26 + i * 18, 210));
        }
    }

    public record CustomData(BlockPos pos) implements IMenuData {

        public static final StreamCodec<RegistryFriendlyByteBuf, CrateMenu.CustomData> CODEC =
                StreamCodec.composite(
                        BlockPos.STREAM_CODEC,
                        CrateMenu.CustomData::pos,
                        CrateMenu.CustomData::new
                );

        @Override
        public StreamCodec codec() {
            return CODEC;
        }
    }
}
