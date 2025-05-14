package com.machineCode.lld.wayfair;

import java.time.LocalDate;
import java.util.*;

public class ProductDiscountCalculator {

    private static class Coupon{
        private String coupanName;
        private double dicount;
        private LocalDate date;

        public Coupon(String coupanName,  LocalDate date , double dicount) {
            this.coupanName = coupanName;
            this.dicount = dicount;
            this.date = date;
        }
    }



    private static class Product {
        String name;
        double sellingPrice;
        String category;

        Product(String name, double sellingPrice, String category) {
            this.name = name;
            this.sellingPrice = sellingPrice;
            this.category = category;
        }
    }

    private final Map<String, List<Coupon>> categoryCoupons;
    private final Map<String, String> childToParent;
    private final Map<String, Product> productMap;



    public ProductDiscountCalculator(
            Map<String, List<Coupon>> categoryCoupons,
            Map<String, String> categoryParent,
            List<Product> products) {
        this.categoryCoupons = new HashMap<>(categoryCoupons);
        this.childToParent = new HashMap<>(categoryParent);
        this.productMap = new HashMap<>();
        for (Product product : products) {
            productMap.put(product.name, product);
        }
    }


    private Coupon getBestValidCoupon(String category, LocalDate currentDate) {
        if(categoryCoupons.containsKey(category)){
            Optional<Coupon> result = categoryCoupons.get(category).stream()
                    .filter(coupon -> coupon.date.isAfter(currentDate))
                    .max(Comparator.comparing(coupon -> coupon.date));
            if(result.isPresent()){
                return result.get();
            }
        }

        findParent(category);

        Optional<Coupon> result = categoryCoupons.get(category).stream()
                .filter(coupon -> coupon.date.isAfter(currentDate))
                .max(Comparator.comparing(coupon -> coupon.date));
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    private void findParent(String category) {
        String currentCategory = category;
        while(childToParent.containsKey(currentCategory)){
            String parent = childToParent.get(currentCategory);
            if(categoryCoupons.containsKey(parent)){
                categoryCoupons.put(category, categoryCoupons.get(parent));
            }else{
                currentCategory = parent;
            }
        }
    }

    public Double getDiscountedPrice(String productName, LocalDate currentDate) {
        String currentCategory = productMap.get(productName).name;
       Coupon coupon = getBestValidCoupon(currentCategory, currentDate);
       if(coupon == null){
           return productMap.get(productName).sellingPrice;
       }

       return productMap.get(productName).sellingPrice * (1-coupon.dicount);

    }

    public static void main(String[] args) {
        // Example data
        Map<String, List<Coupon>> categoryCoupons = new HashMap<>();
        categoryCoupons.put("Electronics", Arrays.asList(
                new Coupon("ELEC10", LocalDate.of(2023, 10, 1), 0.10),
                new Coupon("ELEC20", LocalDate.of(2023, 11, 15), 0.20) // Latest valid
        ));
        categoryCoupons.put("Clothing", Arrays.asList(
                new Coupon("CLOTH15", LocalDate.of(2023, 12, 1), 0.15), // Future date (ignored)
                new Coupon("CLOTH20", LocalDate.of(2023, 9, 1), 0.20)  // Valid
        ));

        Map<String, String> categoryParent = new HashMap<>();
        categoryParent.put("Laptops", "Electronics");
        categoryParent.put("T-Shirts", "Clothing");

        List<Product> products = Arrays.asList(
                new Product("MacBook Pro", 2000.0, "Laptops"),
                new Product("Cotton T-Shirt", 25.0, "T-Shirts")
        );

        LocalDate currentDate = LocalDate.of(2023, 11, 20);
        ProductDiscountCalculator calculator = new ProductDiscountCalculator(
                categoryCoupons, categoryParent, products);

        // Test cases
        System.out.println(calculator.getDiscountedPrice("MacBook Pro", currentDate)); // 1600.0 (20% off)
        System.out.println(calculator.getDiscountedPrice("Cotton T-Shirt", currentDate)); // 20.0 (20% off)
        System.out.println(calculator.getDiscountedPrice("Nonexistent Product", currentDate)); // null
    }

}
