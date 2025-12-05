package sep.banaanatjuh.lightsaber.utils;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class giveGoldenHearts {

    public static void giveGoldenHearts(PlayerEntity player, int duration, int level) {

        StatusEffectInstance absorptionEffect = new StatusEffectInstance(
                StatusEffects.ABSORPTION,
                duration,
                level - 1,
                false,
                false

        );

        if (!player.getEntityWorld().isClient()) {
            player.addStatusEffect(absorptionEffect);
        }
    }
}
