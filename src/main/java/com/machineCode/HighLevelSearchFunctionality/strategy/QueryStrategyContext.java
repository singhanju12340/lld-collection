package com.machineCode.HighLevelSearchFunctionality.strategy;

/**
 * @author anju
 * @created on 04/04/25 and 11:45 AM
 */
public class QueryStrategyContext {
    SpellCheckerStrategy spellCheckerStrategy;
    SynonymExpenderStrategy synonymExpenderStrategy;


    public QueryStrategyContext(SpellCheckerStrategy spellCheckerStrategy, SynonymExpenderStrategy synonymExpenderStrategy) {
        this.spellCheckerStrategy = spellCheckerStrategy;
        this.synonymExpenderStrategy = synonymExpenderStrategy;
    }

    public SpellCheckerStrategy getSpellCheckerStrategy() {
        return spellCheckerStrategy;
    }

    public void setSpellCheckerStrategy(SpellCheckerStrategy spellCheckerStrategy) {
        this.spellCheckerStrategy = spellCheckerStrategy;
    }

    public SynonymExpenderStrategy getSynonymExpenderStrategy() {
        return synonymExpenderStrategy;
    }

    public void setSynonymExpenderStrategy(SynonymExpenderStrategy synonymExpenderStrategy) {
        this.synonymExpenderStrategy = synonymExpenderStrategy;
    }

    public void executeStrategy(){
        spellCheckerStrategy.executeSpellChecker();
        synonymExpenderStrategy.executeSynonym();
    }
}
