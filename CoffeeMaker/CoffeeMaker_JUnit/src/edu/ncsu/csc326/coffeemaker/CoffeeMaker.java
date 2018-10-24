package edu.ncsu.csc326.coffeemaker;

import java.math.BigDecimal;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

/**
 * @author Sarah Heckman
 */

//I am testing a pull reqeustpackage edu.ncsu.csc326.coffeemaker;

import java.math.BigDecimal;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

/**
 * @author Sarah Heckman
 */

//I am testing a pull reqeust

public class CoffeeMaker {
	/** Array of recipes in coffee maker */
	private static RecipeBook recipeBook;
	/** Inventory of the coffee maker */
    private static Inventory inventory;
	
    /**
     * Constructor for the coffee maker
     *
     */
	public CoffeeMaker() {
	    recipeBook = new RecipeBook();
		inventory = new Inventory();
	}
	
	/**
	 * Returns true if the recipe is added to the
	 * list of recipes in the CoffeeMaker and false
	 * otherwise.
	 * @param r
	 * @return boolean
	 */
	public boolean addRecipe(Recipe r) {
		return recipeBook.addRecipe(r);
	}
	
	/**
	 * Returns the name of the successfully deleted recipe
	 * or null if the recipe cannot be deleted.
	 * 
	 * @param recipeToDelete
	 * @return String
	 */
	public String deleteRecipe(int recipeToDelete) {
		return recipeBook.deleteRecipe(recipeToDelete);
	}
	
	/**
	 * Returns the name of the successfully edited recipe
	 * or null if the recipe cannot be edited.
	 * @param recipeToEdit
	 * @param r
	 * @return String
	 */
	public String editRecipe(int recipeToEdit, Recipe r) throws RecipeException {
		return recipeBook.editRecipe(recipeToEdit, r);
	}
    
    /**
     * Returns true if inventory was successfully added
     * @param amtCoffee
     * @param amtMilk
     * @param amtSugar
     * @param amtChocolate
     * @return boolean
     */
    public synchronized void addInventory(String amtCoffee, String amtMilk, String amtSugar, String amtChocolate) throws InventoryException {
	    if((inventory.getCoffee()+Integer.parseInt(amtCoffee))>300 || (inventory.getMilk()+Integer.parseInt(amtMilk))>300 || (inventory.getSugar()+Integer.parseInt(amtSugar))>300 || (inventory.getChocolate()+Integer.parseInt(amtChocolate))>300 )
		{
	    	if (((inventory.getCoffee())+Integer.parseInt(amtCoffee)) >300){
	    		System.out.println("The amount of coffee is full.");
	    	}
	    	if ((inventory.getMilk()+Integer.parseInt(amtMilk))>300){
	    		System.out.println("The amount of milk is full.");
	    	}
	    	if ((inventory.getSugar()+Integer.parseInt(amtSugar))>300) {
	    		System.out.println("The amount of sugar is full.");
	    	}
	    	if ((inventory.getChocolate()+Integer.parseInt(amtChocolate))>300) {
	    		System.out.println("The amount of chocholate is full.");
	    	}
	    	throw new InventoryException("Inventory Not successfully added.");
		}
	    
		else {
	    inventory.addCoffee(amtCoffee);
	    inventory.addMilk(amtMilk);
	    inventory.addSugar(amtSugar);
	    inventory.addChocolate(amtChocolate);
		}
    }
    
    /**
     * Returns the inventory of the coffee maker
     * @return Inventory
     */
    public synchronized String checkInventory() {
        return inventory.toString();
    }
    
    /**
     * Returns the change of a user's beverage purchase, or
     * the user's money if the beverage cannot be made
     * @param r
     * @param amtPaid
     * @return BigDecimal
     */
     public synchronized BigDecimal makeCoffee(int recipeToPurchase, int amtPaid, int unitbuy) {        
        BigDecimal change = new BigDecimal("0.00");
        if (getRecipes()[recipeToPurchase] == null) {
 
        	change = new BigDecimal("-1.00"); // temporary flag for non-existent recipe
        } else if ((getRecipes()[recipeToPurchase].getPrice().multiply(new BigDecimal(unitbuy))).compareTo(new BigDecimal(amtPaid)) <= 0) {
        	if (inventory.useIngredients(getRecipes()[recipeToPurchase])) {
        		change = new BigDecimal(amtPaid).subtract((getRecipes()[recipeToPurchase].getPrice()).multiply(new BigDecimal(unitbuy)));
        	} else {
        		change = new BigDecimal("-2.00"); // temporary flag for insufficient resource
        	}
        } else {
        	change = new BigDecimal(amtPaid);
        }
        return change;
    }
	/**
	 * Returns the list of Recipes in the RecipeBook.
	 * @return Recipe []
	 */
	public synchronized Recipe[] getRecipes() {
		return recipeBook.getRecipes();
	}
}


public class CoffeeMaker {
	/** Array of recipes in coffee maker */
	private static RecipeBook recipeBook;
	/** Inventory of the coffee maker */
    private static Inventory inventory;
	
    /**
     * Constructor for the coffee maker
     *
     */
	public CoffeeMaker() {
	    recipeBook = new RecipeBook();
		inventory = new Inventory();
	}
	
	/**
	 * Returns true if the recipe is added to the
	 * list of recipes in the CoffeeMaker and false
	 * otherwise.
	 * @param r
	 * @return boolean
	 */
	public boolean addRecipe(Recipe r) {
		return recipeBook.addRecipe(r);
	}
	
	/**
	 * Returns the name of the successfully deleted recipe
	 * or null if the recipe cannot be deleted.
	 * 
	 * @param recipeToDelete
	 * @return String
	 */
	public String deleteRecipe(int recipeToDelete) {
		return recipeBook.deleteRecipe(recipeToDelete);
	}
	
	/**
	 * Returns the name of the successfully edited recipe
	 * or null if the recipe cannot be edited.
	 * @param recipeToEdit
	 * @param r
	 * @return String
	 */
	public String editRecipe(int recipeToEdit, Recipe r) throws RecipeException {
		return recipeBook.editRecipe(recipeToEdit, r);
	}
    
    /**
     * Returns true if inventory was successfully added
     * @param amtCoffee
     * @param amtMilk
     * @param amtSugar
     * @param amtChocolate
     * @return boolean
     */
    public synchronized void addInventory(String amtCoffee, String amtMilk, String amtSugar, String amtChocolate) throws InventoryException {
	    if((inventory.getCoffee()+Integer.parseInt(amtCoffee))>300 || (inventory.getMilk()+Integer.parseInt(amtMilk))>300 || (inventory.getSugar()+Integer.parseInt(amtSugar))>300 || (inventory.getChocolate()+Integer.parseInt(amtChocolate))>300 )
		{
	    	if (((inventory.getCoffee())+Integer.parseInt(amtCoffee)) >300){
	    		System.out.println("The amount of coffee is full.");
	    	}
	    	if ((inventory.getMilk()+Integer.parseInt(amtMilk))>300){
	    		System.out.println("The amount of milk is full.");
	    	}
	    	if ((inventory.getSugar()+Integer.parseInt(amtSugar))>300) {
	    		System.out.println("The amount of sugar is full.");
	    	}
	    	if ((inventory.getChocolate()+Integer.parseInt(amtChocolate))>300) {
	    		System.out.println("The amount of chocholate is full.");
	    	}
	    	throw new InventoryException("");
		}
	    
		else {
	    inventory.addCoffee(amtCoffee);
	    inventory.addMilk(amtMilk);
	    inventory.addSugar(amtSugar);
	    inventory.addChocolate(amtChocolate);
		}
    }
    
    /**
     * Returns the inventory of the coffee maker
     * @return Inventory
     */
    public synchronized String checkInventory() {
        return inventory.toString();
    }
    
    /**
     * Returns the change of a user's beverage purchase, or
     * the user's money if the beverage cannot be made
     * @param r
     * @param amtPaid
     * @return BigDecimal
     */
     public synchronized BigDecimal makeCoffee(int recipeToPurchase, int amtPaid, int unitbuy) {        
        BigDecimal change = new BigDecimal("0.00");
        if (getRecipes()[recipeToPurchase] == null) {
 
        	change = new BigDecimal("-1.00"); // temporary flag for non-existent recipe
        } else if ((getRecipes()[recipeToPurchase].getPrice().multiply(new BigDecimal(unitbuy))).compareTo(new BigDecimal(amtPaid)) <= 0) {
        	if (inventory.useIngredients(getRecipes()[recipeToPurchase])) {
        		change = new BigDecimal(amtPaid).subtract((getRecipes()[recipeToPurchase].getPrice()).multiply(new BigDecimal(unitbuy)));
        	} else {
        		change = new BigDecimal("-2.00"); // temporary flag for insufficient resource
        	}
        } else {
        	change = new BigDecimal(amtPaid);
        }
        return change;
    }
	/**
	 * Returns the list of Recipes in the RecipeBook.
	 * @return Recipe []
	 */
	public synchronized Recipe[] getRecipes() {
		return recipeBook.getRecipes();
	}
}
