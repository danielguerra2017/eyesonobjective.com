//********************************************************************
//  Account.java       Author: Daniel S. Guerra
//
//  Represents a store with products being sold on sale for 20%
//********************************************************************

import java.text.NumberFormat;

public class Product
{
   private final double RATE = 0.8;  // 20% Sale Price

   private double getPrice;
   private double reducePrice;
   private String getName;

   //-----------------------------------------------------------------
   //  Sets up product, along with their oringal price
   //-----------------------------------------------------------------

   public Product (String prodName, double regPrice, double salePrice)
   {

      getName = prodName;
      getPrice = regPrice;
      reducePrice = salePrice;

   }

   //-----------------------------------------------------------------
   //  Deducts 20% from the original price.
   //-----------------------------------------------------------------

   public double addSale ()
   {

      reducePrice = (getPrice * RATE);
      return reducePrice;

   }

   //-----------------------------------------------------------------
   //  Returns the product name, original price, and sale price.
   //-----------------------------------------------------------------

   public String toString ()
   {

      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      return (getName + "\t\t" + fmt.format(getPrice) + "\t\t" + fmt.format(reducePrice));

   }
}
