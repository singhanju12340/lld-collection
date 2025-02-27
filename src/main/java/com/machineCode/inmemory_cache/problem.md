High Performance InMemory Cache
Your task is to design and implement an in-memory caching system that
is capable of storing and retrieving key-value pairs efficiently. The
cache should have a capacity limit, after which the items should be
evicted using an eviction policy to make space for new items.

The cache should provide the following operations:
● put(key, value): Add a new key-value pair to the cache. If the
cache is at capacity, evict the least recently used item before
adding the new item.
● get(key): Retrieve the value associated with the given key from
the cache. If the key is not present in the cache, retrieve it
from a backing store, add it to the cache, and return it. If the
value is not found in the backing store, return null.
● remove(key): Remove the key-value pair associated with the given
key from the cache.
Additionally, the cache should support several configuration options,
such as:

● Expiration strategies: Specify the time-to-live (TTL) for items
in the cache. Expired items should be removed from the cache
automatically.

○ Expire entries after the specified duration has passed since
the entry was last accessed (read/write).

● Maximum size: specify the maximum number of items allowed in the
cache.
● Write Policy: specify the methodology used to propagate updates
in cached data

Bonus:
1. Sync/ Asynchronous loading (cache creation)
2. Implement other expiration strategy
3. Implement refresh strategies.
   Expiry Strategies:
   ○ Expire entries after the specified duration has passed since
   the entry was created, or the most recent replacement of the
   value.
   ○ Expires entries after the specified duration has passed.
   Refresh time (not eviction):
   ● Specify the duration after which an item should be refreshed
   with a new value from the backing store.
   Test Cases:
   Basic Operations
   Test Case 1: Add and Retrieve
   Input: -> put('key1', 'value1')
   -> get('key1')
   Expected Output: 'value1'
   Test Case 2: Retrieve Non-existent Key
   Input: -> get('keyX') (where 'keyX' is not in cache)
   Expected Output: Retrieve from backing store or null if not
   found
   Test Case 3: Update Existing Key
   Input: -> put('key1', 'value1'), put('key1', 'value2')
   -> get('key1')
   Expected Output: 'value2'
   Test Case 4: Remove Key
   Input: -> put('key1', 'value1'),
   -> remove('key1')
   -> get('key1')
   Expected Output: Retrieve from backing store or null if not
   found
   Capacity and Eviction Policy
   Test Case 5: Evict on Capacity
   Setup: Cache capacity set to 2
   Input: -> put('key1', 'value1')
   -> put('key2', 'value2')
   -> put('key3', 'value3')
   -> get('key1')
   Expected Output: null (or retrieved from backing store if
   applicable), 'key1' should be evicted