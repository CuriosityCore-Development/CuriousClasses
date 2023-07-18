package io.curiositycore.curiousclasses.archetypes.skills.skill;

import io.curiositycore.curiousclasses.archetypes.skills.interfaces.targets.entities.aoe.AoeEntityPassiveSkill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import io.curiositycore.curiousclasses.utils.TargetSelector;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Set;

/**
 * Test class of the AOE functionality of the skill system. <i>Temporary so will not have full docs</i>
 */
public class AoeRegen extends BaseSkill<Player> implements AoeEntityPassiveSkill<Player> {
    @Getter @Setter
    private int aoeRadius = 10;
    @Override
    public void setEffect(Set<Player> targetPlayers) {
        PotionEffect skillEffect = new PotionEffect(PotionEffectType.REGENERATION,100,0,false,true,true);

        for(Player player : targetPlayers){
            player.addPotionEffect(skillEffect);
        }
    }

    @Override
    public Set<Player> getTargets(Entity skillOwner) {
        return TargetSelector.getTargetsInRadius(skillOwner,this.aoeRadius);
    }

    @Override
    public String getName() {
        return "RegenPlayersSkill";
    }

    @Override
    public Tier getTier() {
        return Tier.TIER_ONE;
    }

    @Override
    public boolean meetsRequirements(Player player) {
        return true;
    }

    @Override
    public void activate(Player skillOwner) {
        setEffect(getTargets(skillOwner));
    }
}
