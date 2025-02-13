Imagine that you’re working on an online ordering system.
You want to restrict access to the system so only authenticated users can create orders.
Also, users who have administrative permissions must have full access to all orders.

After a bit of planning, you realized that these checks must be performed sequentially.
The application can attempt to authenticate a user to the system whenever it receives a request that contains the user’s credentials

After few month
One of your colleagues suggested that it’s unsafe to pass raw data straight to the ordering system.
So you added an extra validation step to sanitize the data in a request.

Later, somebody noticed that the system is vulnerable to brute force password cracking. To negate this,
you promptly added a check that filters repeated failed requests coming from the same IP address.

Someone else suggested that you could speed up the system by returning cached results on repeated requests containing the same data. Hence,
 you added another check which lets the request pass through to the system only if there’s no suitable cached response

### Request ----> {authentication + authorisation + Validation + caching } ---> Order system



Solution :

the Chain of Responsibility relies on transforming particular behaviors into stand-alone objects called handlers.
 In our case, each check should be extracted to its own class with a single method that performs the check.
  The request, along with its data, is passed to this method as an argument.

The pattern suggests that you link these handlers into a chain.
Each linked handler has a field for storing a reference to the next handler in the chain.
 In addition to processing a request, handlers pass the request further along the chain.
 The request travels along the chain until all handlers have had a chance to process it.