package com.machineCode.designPatterns.creational.builder;

/**
 * @author anju
 * @created on 25/02/25 and 11:50 AM
 */
public class House {
    // Required parameters
    private final int rooms;
    private final int bathrooms;

    // Optional parameters
    private final boolean hasGarage;
    private final boolean hasGarden;
    private final boolean hasSwimmingPool;

    // pass builder class to constructor
    public House(HouseBuilder builder) {
        this.rooms = builder.rooms;
        this.bathrooms = builder.bathrooms;
        this.hasGarage = builder.hasGarage;
        this.hasGarden = builder.hasGarden;
        this.hasSwimmingPool = builder.hasSwimmingPool;
    }

    @Override
    public String toString() {
        return "House{" +
                "rooms=" + rooms +
                ", bathrooms=" + bathrooms +
                ", hasGarage=" + hasGarage +
                ", hasGarden=" + hasGarden +
                ", hasSwimmingPool=" + hasSwimmingPool +
                '}';
    }

    public static class HouseBuilder {
        // Required parameters
        private  int rooms;
        private  int bathrooms;

        // Optional parameters
        private  boolean hasGarage;
        private  boolean hasGarden;
        private  boolean hasSwimmingPool;

        // Builder constructor with required parameters
        public HouseBuilder(int rooms, int bathrooms) {
            this.rooms = rooms;
            this.bathrooms = bathrooms;
        }

        public HouseBuilder() {
        }

        public HouseBuilder withRoom(int rooms) {
            this.rooms = rooms;
            return this;
        }


        public HouseBuilder withBathRoom(int bathRoom) {
            this.bathrooms = bathRoom;
            return this;
        }

        public HouseBuilder withGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder withGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public HouseBuilder withSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        // Build method to create the House object.
        public House build() {
            return new House(this);
        }

    }
}
