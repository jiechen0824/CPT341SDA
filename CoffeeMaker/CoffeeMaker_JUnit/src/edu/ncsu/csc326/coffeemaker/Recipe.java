package edu.ncsu.csc326.coffeemaker;

import java.math.BigDecimal;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

/**
 * @author   Sarah Heckman
 */
public class Recipe {
    private String name;
    private BigDecimal price;
    private int amtCoffee;
    private int amtMilk;
    private int amtSugar;
    private int amtChocolate;
    
    /**
     * Creates a default recipe for the coffee maker.
     */
    public Recipe() {
    	this.name = "";
    	this.price = new BigDecimal("0.00");
    	this.amtCoffee = 0;
    	this.amtMilk = 0;
    	this.amtSugar = 0;
    	this.amtChocolate = 0;
    }
    
    /**
	 * @return   Returns the amtChocolate.
	 */
    public int getAmtChocolate() {
		return amtChocolate;
	}
    
    /**
	 * @param amtChocolate   The amtChocolate to set.
	 */
    public void setAmtChocolate(String chocolate) throws RecipeException {
    	int amtChocolate = 0;
    	try {
    		amtChocolate = Integer.parseInt(chocolate);
    	} catch (NumberFormatException e) {
    		throw new RecipeException("Units of chocolate must be a positive integer");
    	}
		if (amtChocolate >= 0) {
			this.amtChocolate = amtChocolate;
		} else {
			throw new RecipeException("Units of chocolate must be a positive integer");
		}
	}
    
    /**
	 * @return   Returns the amtCoffee.
	 */
    public int getAmtCoffee() {
		return amtCoffee;
	}
    
    /**
	 * @param amtCoffee   The amtCoffee to set.
	 */
    public void setAmtCoffee(String coffee) throws RecipeException {
    	int amtCoffee = 0;
    	try {
    		amtCoffee = Integer.parseInt(coffee);
    	} catch (NumberFormatException e) {
    		throw new RecipeException("Units of coffee must be a positive integer");
    	}
		if (amtCoffee >= 0) {
			this.amtCoffee = amtCoffee;
		} else {
			throw new RecipeException("Units of coffee must be a positive integer");
		}
	}
    
    /**
	 * @return   Returns the amtMilk.
	 */
    public int getAmtMilk() {
		return amtMilk;
	}
    
    /**
	 * @param amtMilk   The amtMilk to set.
	 */
    public void setAmtMilk(String milk) throws RecipeException{
    	int amtMilk = 0;
    	try {
    		amtMilk = Integer.parseInt(milk);
    	} catch (NumberFormatException e) {
    		throw new RecipeException("Units of milk must be a positive integer");
    	}
		if (amtMilk >= 0) {
			this.amtMilk = amtMilk;
		} else {
			throw new RecipeException("Units of milk must be a positive integer");
		}
	}
    
    /**
	 * @return   Returns the amtSugar.
	 */
    public int getAmtSugar() {
		return amtSugar;
	}
    
    /**
	 * @param amtSugar   The amtSugar to set.
	 */
    public void setAmtSugar(String sugar) throws RecipeException {
    	int amtSugar = 0;
    	try {
    		amtSugar = Integer.parseInt(sugar);
    	} catch (NumberFormatException e) {
    		throw new RecipeException("Units of sugar must be a positive integer");
    	}
		if (amtSugar >= 0) {
			this.amtSugar = amtSugar;
		} else {
			throw new RecipeException("Units of sugar must be a positive integer");
		}
	}
    
    /**
	 * @return   Returns the name.
	 */
    public String getName() {
		return name;
	}
    
    /**
	 * @param name   The name to set.
	 */
    public void setName(String name) throws RecipeException {
    	if(name != null && !name.isEmpty()) {
    		this.name = name;
    	}
    	else throw new RecipeException("Please input a valid recipe name.");
	}
    /**
	 * @return   Returns the price.
	 */
    public BigDecimal getPrice() {
		return price;
	}
    
    /**
	 * @param price   The price to set.
	 */
    public void setPrice(String price) throws RecipeException{
    	BigDecimal amtPrice;
    	try {
    		amtPrice = new BigDecimal(price);
    	} catch (NumberFormatException e) {
    		throw new RecipeException("Price must be a positive integer");
    	}
		if (amtPrice.compareTo(BigDecimal.ZERO) > 0) {
			this.price = amtPrice;
		} else {
			throw new RecipeException("Price must be a positive integer");
		}
	} 
    
    /**
     * Returns the name of the recipe.
     * @return String
     */
    public String toString() {
    	return name;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Recipe other = (Recipe) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
