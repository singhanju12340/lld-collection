InventoryService (Facade)
├── InventoryRepository (Repository)
├── InventoryItemFactory (Factory)
├── ValuationStrategies (Strategy)
│   ├── FIFOStrategy
│   ├── LIFOStrategy
│   └── AverageCostStrategy
├── InventoryObservable (Observer)
│   └── InventoryObserver (e.g., ReorderService)
├── InventoryCommands (Command)
│   ├── ReceiveCommand
│   ├── ShipCommand
│   └── AdjustCommand
└── InventorySpecifications (Specification)
For a Staff Engineer interview, emphasize how these patterns work together to solve specific inventory challenges like:

Concurrent inventory updates

Distributed inventory tracking

Audit and compliance requirements

Performance at scale