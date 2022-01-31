package nz.kota.betterchainmail.mixin;

import net.minecraft.item.ArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ArmorMaterials.class)
public class ArmorMaterialsMixin {
    @ModifyArgs(method = "<clinit>",
            at = @At(value = "INVOKE",
                    target = "net/minecraft/item/ArmorMaterials.<init>(Ljava/lang/String;ILjava/lang/String;I[IILnet/minecraft/sound/SoundEvent;FFLjava/util/function/Supplier;)V"))
    private static void fixGold(Args arguments) {
        if (arguments.get(0).equals("CHAIN")) {
            arguments.set(3, 24);
            arguments.set(4, new int[]{4, 6, 8, 4});
            arguments.set(7, 1.0f);
        }
    }
}
