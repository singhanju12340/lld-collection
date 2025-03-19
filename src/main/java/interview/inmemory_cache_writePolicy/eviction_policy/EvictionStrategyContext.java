package interview.inmemory_cache_writePolicy.eviction_policy;

import com.machineCode.designPatterns.behavioral.strategyPatterns.Strategy;

/**
 * @author anju
 * @created on 12/03/25 and 11:56 PM
 */
public class EvictionStrategyContext {
    EvictionStrategy evictionStrategy;

    public EvictionStrategy getCurrentStrategy() {
        return evictionStrategy;
    }

    public void setCurrentStrategy(EvictionStrategy currentStrategy) {
        this.evictionStrategy = currentStrategy;
    }

}
