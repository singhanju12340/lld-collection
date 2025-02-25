Imagine that you’re creating a furniture shop simulator. Your code consists of classes that represent:

A family of related products, say: Chair + Sofa + CoffeeTable.

Several variants of this family.
For example, products Chair + Sofa + CoffeeTable are available in these variants: Modern, Victorian, ArtDeco.

Solution
The first thing the Abstract Factory pattern suggests is to explicitly declare interfaces for each distinct product of the product family 
(e.g., chair, sofa or coffee table). Then you can make all variants of products follow those interfaces.
For example, all chair variants can implement the Chair interface;
all coffee table variants can implement the CoffeeTable interface, and so on.