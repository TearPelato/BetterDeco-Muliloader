package net.tier1234.better_deco.screen.custom;


import com.mrcrayfish.framework.api.menu.IMenuData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.tier1234.better_deco.block.OvenBlock;
import net.tier1234.better_deco.blockentity.OvenBlockEntity;
import net.tier1234.better_deco.blockentity.WorkbenchBlockEntity;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModMenuTypes;
import net.tier1234.better_deco.screen.slot.OvenFuelSlot;

public class OvenMenu extends AbstractContainerMenu {
    public final OvenBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;
    private final ContainerLevelAccess access;

    public OvenMenu(int pContainerId, Inventory inv, CustomData data) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(data.pos()), new SimpleContainerData(5));
    }


    public OvenMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.OVEN_MENU.get(), pContainerId);
        this.blockEntity = ((OvenBlockEntity) entity);
        this.level = inv.player.level();
        this.data = data;
        this.access = ContainerLevelAccess.create(level,blockEntity.getBlockPos());

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

        this.addSlot(new OvenFuelSlot(this, this.blockEntity.itemHandler, 6, 42,35));

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

    public float getBurnProgress() {
        int litDuration = this.data.get(3);
        if (litDuration == 0) {
            litDuration = 200;
        }

        return Mth.clamp((float)this.data.get(3) / (float)litDuration, 0.0F, 1.0F);
    }


    public boolean isBurning() {
        return this.data.get(3) > 0;
    }


    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    private static final int TE_INVENTORY_SLOT_COUNT = 7;

    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        int teStart = TE_INVENTORY_FIRST_SLOT_INDEX;
        int teEnd = teStart + TE_INVENTORY_SLOT_COUNT;

        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, teStart, teStart + 3, false) &&
                    !moveItemStackTo(sourceStack, teStart + 6, teStart + 7, false)) {
                return ItemStack.EMPTY;
            }
        } else if (pIndex < teEnd) {
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX,
                    VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) sourceSlot.set(ItemStack.EMPTY);
        else sourceSlot.setChanged();
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return access.evaluate((level, blockPos)-> level.getBlockEntity(blockPos) instanceof OvenBlockEntity, true);

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
    public boolean isFuelItem(ItemStack stack) {
        return AbstractFurnaceBlockEntity.getFuel().getOrDefault(stack.getItem(), 0) > 0;
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