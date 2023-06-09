package com.gempire.entities.abilities;

import com.gempire.entities.abilities.base.Ability;
import com.gempire.entities.abilities.interfaces.IAttributeAbility;
import com.gempire.util.Abilities;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class AbilityUnhinged extends Ability implements IAttributeAbility {

    public AbilityUnhinged(){
        this.ability = Abilities.UNHINGED;
    }

    @Override
    public Attribute attribute() {
        return Attributes.ATTACK_SPEED;
    }

    @Override
    public double baseValue() {
        return this.holder.getAttributeValue(Attributes.ATTACK_SPEED) * 8D;
    }

    @Override
    public ITextComponent getName() {
        return new TranslationTextComponent("ability.gempire.unhinged");
    }
}
