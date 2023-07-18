package io.curiositycore.curiousclasses.archetypes.skills.skill;

import io.curiositycore.curiousclasses.archetypes.skills.interfaces.targets.entities.singular.SingleEntityPassiveSkill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RegenOnMobKill extends BaseSkill<Player> implements SingleEntityPassiveSkill<Player> {

    /**
     * Constructor that utilises a builder object to initialise the skill.
     */
    public void setEffect(Player player) {
        if(!meetsRequirements(player)){
            return;
        }
        PotionEffect skillEffect = new PotionEffect(PotionEffectType.REGENERATION,100,0,false,true,true);
        player.addPotionEffect(skillEffect);
    }

    @Override
    public Player getTargets(Entity skillOwner) {
        return (Player) skillOwner;
    }

    @Override
    public String getName() {
        return "RegenOnMobKill";
    }

    @Override
    public Tier getTier() {
        return Tier.TIER_ONE;
    }

    @Override
    public boolean meetsRequirements(Player player) {
        if(player.getInventory().getHelmet() == null){
            return false;
        }
        return player.getInventory().getHelmet().getType() == Material.LEATHER_HELMET;
    }
    @Override
    public void activate(Player playerTarget){
        setEffect(playerTarget);
    }
}
