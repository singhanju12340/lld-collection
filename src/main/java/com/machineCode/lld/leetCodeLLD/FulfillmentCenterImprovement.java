package com.machineCode.lld.leetCodeLLD;


/**
 * Licious
 *
 * Order Fulfillment Optimizer
 * Context: Licious operates on tight delivery timelines with perishable goods. The system receives multiple orders, and each order needs to be fulfilled from a set of available fulfillment centers (FCs) based on factors like inventory, proximity, and delivery time.
 * Problem Statement:
 * Given:
 * A list of orders, each having an order_id, product_id, and quantity.
 *
 *
 * A list of fulfillment centers, each with a fc_id, a location, and an inventory map (product_id -> available quantity).
 *
 *
 * A method get_travel_time(fc_location, customer_location) that returns time in minutes.
 *
 *
 * Assign each order to a fulfillment center that:
 * Has enough stock for the order.
 *
 *
 * Minimizes the delivery time to the customer.
 *
 *
 * Tries to consolidate multiple orders for the same customer (same location) from the same FC, if possible.
 *
 *
 * Constraints:
 * Each order must be fulfilled fully (no partial fulfillment).
 *
 *
 * If no FC can fulfill the order, mark the order as unfulfillable.
 */
public class FulfillmentCenterImprovement {
}
