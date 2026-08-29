package net.tier1234.better_deco.mixin;

import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.schemas.Schema;
import net.minecraft.util.datafix.DataFixers;
import net.minecraft.util.datafix.fixes.BlockRenameFix;
import net.tier1234.better_deco.datafix.ModDataFixer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

@Mixin(DataFixers.class)
public abstract class DataFixersMixin {
    @Shadow
    @Final
    private static BiFunction<Integer, Schema, Schema> SAME_NAMESPACED;

    @Shadow
    private static UnaryOperator<String> createRenamer(Map<String, String> renameMap) {
        throw new AssertionError("Mixin injection failed");
    }

    @Inject(method = "addFixers", at = @At("TAIL"))
    private static void addFixers(DataFixerBuilder builder, CallbackInfo ci) {
        var schema = builder.addSchema(3955, SAME_NAMESPACED);
        builder.addFixer(BlockRenameFix.create(schema, "BetterDeco Renamed/Removed Blocks", createRenamer(ModDataFixer.CHANGED_BLOCK)));

    }

}
