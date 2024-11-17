package net.remclean.mapleforest.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodCompontents {
    public static final FoodComponent MAPLE_SYRUP = new FoodComponent.Builder().hunger(8).saturationModifier(0.25f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 2), 1.0f).build();
    public static final FoodComponent MAPLE_SAP = new FoodComponent.Builder().hunger(2).saturationModifier(0.25f).build();
}
