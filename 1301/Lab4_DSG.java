//********************************************************************
//  Transactions.java       Author: Daniel S. Guerra
//
//  Demonstrates the creation of products and their sale price
//********************************************************************

public class Lab4_DSG
{
   //-----------------------------------------------------------------
   //  Creates new products with their original price
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      Product prod1 = new Product ("Puma Shirt", 24.99, 24.99);
      Product prod2 = new Product ("Puma Shoes", 89.99, 89.99);

      System.out.println ("\n\t\tNorth Georgia Premium Outlet");

      System.out.println ("\n\t\tBest Deal Super Store");

      System.out.println ("\n\t\t\tSpring Sale");

      System.out.println ("\nProduct\'s Name\t\tRegular Price\tSale Price");

      prod1.addSale();
      prod2.addSale();

	  System.out.println ();
      System.out.println (prod1 + "\n");
      System.out.println (prod2 + "\n");
      System.out.println ("\n\n\t\t\t\tDesigned by: Daniel S. Guerra\n");
   }
}
