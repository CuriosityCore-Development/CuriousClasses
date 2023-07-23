package io.curiositycore.curiousclasses.archetypes.progression;

/**
 * A container for the current amount of progression and the amount of progression required for an upgrade of the
 * Archetype's {@linkplain io.curiositycore.curiousclasses.archetypes.tier.Tier Tier}.
 * <br> Manipulated mainly through the child classes of the {@linkplain
 * io.curiositycore.curiousclasses.archetypes.archetype.BaseArchetype BaseArchetype} abstract.
 */
public class ArchetypeProgression implements Progression{
    /**
     * The amount of progression the Archetype currently has.
     */
    private int currentProgressionAmount;

    /**
     * The amount of progression required for the Archetype to upgrade its Tier.
     */
    private int progressionRequired;

    /**
     * Constructor called when a new Archetype is first created. Initialises the progress required.
     * @param progressionRequired The progress amount required for Tier upgrade.
     */
    public ArchetypeProgression(int progressionRequired){
        this.currentProgressionAmount = 0;
        this.progressionRequired = progressionRequired;
    }

    /**
     * Constructor called when a progression instance is constructed for an existing Archetype, from persistence data.
     * @param progressionRequired The progress required by the existing archetype to upgrade tier.
     * @param currentProgressionAmount The current amount of progress the existing archetype has towards upgrading tier.
     */
    public ArchetypeProgression(int progressionRequired, int currentProgressionAmount){
        this.currentProgressionAmount = currentProgressionAmount;
        this.progressionRequired = progressionRequired;
    }
    @Override
    public void addProgression(int progressionToAdd) {
        currentProgressionAmount += progressionToAdd;
    }

    @Override
    public void removeProgression(int progressionToRemove) {
        currentProgressionAmount -= progressionToRemove;
    }

    @Override
    public int getCurrentProgression() {
        return this.currentProgressionAmount;
    }

    @Override
    public void resetProgression(int progressionRequired) {
        this.currentProgressionAmount = 0;
        this.progressionRequired = progressionRequired;
    }

    @Override
    public int getProgressionTillCompletion() {
        return progressionRequired - currentProgressionAmount;
    }
}
