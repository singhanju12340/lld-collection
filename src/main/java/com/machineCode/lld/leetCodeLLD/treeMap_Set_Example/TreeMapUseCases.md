>Key Features of TreeMap

## Sorted Keys:

Keys are stored in natural order (or custom order via a Comparator).

Example: {1: "A", 2: "B", 3: "C"} is stored in ascending order.

## Balanced Tree Structure:

Uses a Red-Black Tree to ensure operations (insert/delete/search) take O(log n) time.

## Additional Utilities:

Methods like firstKey(), lastKey(), floorKey(), ceilingKey() for navigation.

## Log(n) complexity for all operation 

>1. E-Commerce: Price-Sorted Products


TreeMap<Double, Product> productsByPrice = new TreeMap<>();
productsByPrice.put(99.99, new Product("Laptop"));
productsByPrice.put(49.99, new Product("Mouse"));
// Products are auto-sorted: {49.99: Mouse, 99.99: Laptop}



>2. Calendar/Scheduling Systems

TreeMap<LocalDateTime, String> events = new TreeMap<>();
events.put(LocalDateTime.of(2023, 12, 25, 10, 0), "Christmas Party");
events.put(LocalDateTime.of(2023, 12, 1, 9, 0), "Team Meeting");


>3. Financial Systems: Stock Price Analysis

TreeMap<Date, Double> stockPrices = new TreeMap<>();
stockPrices.put(new Date(2023, 1, 1), 150.0);
stockPrices.put(new Date(2023, 1, 2), 152.5);
// Easily find the closest price to a given date using floorKey()/ceilingKey().



>4. Geospatial Data: Nearest Location Search

TreeMap<Double, String> restaurantsByDistance = new TreeMap<>();
restaurantsByDistance.put(1.2, "Cafe A");
restaurantsByDistance.put(0.5, "Cafe B");
Double nearestDistance = restaurantsByDistance.floorKey(1.0); // Returns 0.5


>5. Leaderboard Systems (Gaming/Sports)

TreeMap<Integer, String> leaderboard = new TreeMap<>(Comparator.reverseOrder());
leaderboard.put(1500, "Player1");
leaderboard.put(1700, "Player2");
// Leaderboard: {1700: Player2, 1500: Player1}

>6. Using TreeMap for Time-Based Price Calculations

Find all entries where endTime < currentTime.

| Method | Purpose | Time Complexity|
| ---| --- | --- | --- |
| put(endTime, entry) |	Add an entry |	O(log n) |
| headMap(currentTime)	| Get all entries with endTime < currentTime |	O(log n) |


