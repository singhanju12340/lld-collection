The Facade design pattern encapsulates all the subsystems and provides a simple method for implementation.

Example: Order system
For client to place an order 
> availability needs to be validated
> product needs to be reserved
> payments needs to be done
> Shipping needs to be processed.
> 
But all these complexity client need not to know and worry about
Client only needs simple placeOrder implementation to call.



