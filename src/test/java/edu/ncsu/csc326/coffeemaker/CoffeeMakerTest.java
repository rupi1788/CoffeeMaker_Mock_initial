/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
 * All Rights Reserved.
 * 
 * Permission has been explicitly granted to the University of Minnesota 
 * Software Engineering Center to use and distribute this source for 
 * educational purposes, including delivering online education through
 * Coursera or other entities.  
 * 
 * No warranty is given regarding this software, including warranties as
 * to the correctness or completeness of this software, including 
 * fitness for purpose.
 * 
 * Modifications
 * 20171113 - Michael W. Whalen - Extended with additional recipe.
 * 20171114 - Ian J. De Silva   - Updated to JUnit 4; fixed variable names.
 */
package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;



/**
 * Unit tests for CoffeeMaker class.
 * 
 * @author Sarah Heckman
 *
 * Extended by Mike Whalen
 */

public class CoffeeMakerTest {
	
	//-----------------------------------------------------------------------
	//	DATA MEMBERS
	//-----------------------------------------------------------------------
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;
	private Recipe recipe5;
	
	private Recipe [] stubRecipies; 
	
	/**
	 * The coffee maker -- our object under test.
	 */
	private CoffeeMaker coffeeMaker;
	
	/**
	 * The stubbed recipe book.
	 */
	private RecipeBook recipeBookStub;
	
	
	//-----------------------------------------------------------------------
	//	Set-up / Tear-down
	//-----------------------------------------------------------------------
	/**
	 * Initializes some recipes to test with, creates the {@link CoffeeMaker} 
	 * object we wish to test, and stubs the {@link RecipeBook}. 
	 * 
	 * @throws RecipeException  if there was an error parsing the ingredient 
	 * 		amount when setting up the recipe.
	 */
	@Before
	public void setUp() throws RecipeException {
		
		recipeBookStub = mock(RecipeBook.class);
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		
		//Set up for recipe1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for recipe2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for recipe3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for recipe4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
		
		//Set up for recipe5 (added by MWW)
		recipe5 = new Recipe();
		recipe5.setName("Super Hot Chocolate");
		recipe5.setAmtChocolate("6");
		recipe5.setAmtCoffee("0");
		recipe5.setAmtMilk("1");
		recipe5.setAmtSugar("1");
		recipe5.setPrice("100");

		stubRecipies = new Recipe [] {recipe1, recipe2, recipe3};
	}
	
	
	//-----------------------------------------------------------------------
	//	Test Methods
	//-----------------------------------------------------------------------
	
	// put your tests here!
	
	@Test
	public void testMakeCoffee() {
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		assertTrue(true);
	}

	/**
	 * When we set name  of a recipe where
	 *   input is null.
	 */

	@Test
	public void testSetNameInRecipe1() {

			recipe1 = new Recipe();
			recipe1.setName(null);
		Assert.assertEquals(recipe1.getName(), "");
	}

	/**
	 * When we set price of a recipe where
	 *   input is invalid.
	 * @throws RecipeException
	 */
	@Test
	public void testSetPriceInRecipe1() throws RecipeException, InventoryException {
		try {
			recipe1 = new Recipe();
			recipe1.setPrice("-56");
		}
		catch (RecipeException z) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}
	@Test
	public void testSetPriceInRecipe2() throws RecipeException, InventoryException {
		try {
			recipe1 = new Recipe();
			recipe1.setPrice("abc");
		}
		catch (RecipeException z) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}


	/**
	 * When we set amount of ingredients in recipe where
	 *   input of ingredient is invalid.
	 * @throws RecipeException
	 */

	@Test
	public void testSetCoffeeInRecipe1() throws RecipeException, InventoryException {
		try {
		recipe1 = new Recipe();
		recipe1.setAmtCoffee("-3");
		}
		catch (RecipeException z) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}

	@Test
	public void testSetCoffeeInRecipe2() throws RecipeException, InventoryException {
		try {
			recipe1 = new Recipe();
			recipe1.setAmtCoffee("xyz");
		}
		catch (RecipeException z) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}

	@Test
	public void testSetMilkInRecipe1() throws RecipeException, InventoryException {
		try {
			recipe1 = new Recipe();
			recipe1.setAmtMilk("-5");
		}
		catch (RecipeException z) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}
	@Test
	public void testSetMilkInRecipe2() throws RecipeException, InventoryException {
		try {
			recipe1 = new Recipe();
			recipe1.setAmtMilk("pqr");
		}
		catch (RecipeException z) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}

	@Test
	public void testSetChocolateInRecipe1() throws RecipeException, InventoryException {
		try {
			recipe1 = new Recipe();
			recipe1.setAmtChocolate("-3");
		}
		catch (RecipeException z) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}
	@Test
	public void testSetChocolateInRecipe2() throws RecipeException, InventoryException {
		try {
			recipe1 = new Recipe();
			recipe1.setAmtChocolate("efg");
		}
		catch (RecipeException z) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}

	@Test
	public void testSetSugarInRecipe1() throws RecipeException, InventoryException {
		try {
			recipe1 = new Recipe();
			recipe1.setAmtSugar("-7");
		}
		catch (RecipeException z) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}
	@Test
	public void testSetSugarInRecipe2() throws RecipeException, InventoryException {
		try {
			recipe1 = new Recipe();
			recipe1.setAmtSugar("abc");
		}
		catch (RecipeException z) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}


	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities
	 * Then we do not get an exception trying to read the inventory quantities.
	 *
	 * @throws InventoryException if there was an error parsing the quanity
	 *                            to a positive integer.
	 */
	@Test
	public void testAddInventory1() throws InventoryException {
		coffeeMaker.addInventory("4", "7", "0", "9");
	}


	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException if there was an error parsing the quanity
	 *                            to a positive integer.
	 */
	@Test
	public void testAddInventoryExceptionForChocolate1() {
		try {
			coffeeMaker.addInventory("4", "1", "0", "-3");
		} catch (InventoryException e) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}

	@Test
	public void testAddInventoryExceptionForChocolate2() {
		try {
			coffeeMaker.addInventory("4", "1", "0", "abc");
		} catch (InventoryException e) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}

	@Test
	public void testAddInventoryExceptionForCoffee1() {
		try {
			coffeeMaker.addInventory("-4", "1", "0", "3");
		} catch (InventoryException e) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}

	@Test
	public void testAddInventoryExceptionForCoffee2() {
		try {
			coffeeMaker.addInventory("efg", "1", "0", "3");
		} catch (InventoryException e) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}

	@Test
	public void testAddInventoryExceptionForMilk1() {
		try {
			coffeeMaker.addInventory("4", "-10", "0", "3");
		} catch (InventoryException e) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}

	@Test
	public void testAddInventoryExceptionForMilk2() {
		try {
			coffeeMaker.addInventory("4", "pqr", "0", "3");
		} catch (InventoryException e) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}

	@Test
	public void testAddInventoryExceptionForSugar1()  {
		try {
			coffeeMaker.addInventory("4", "1", "-4", "3");
		}
		catch (InventoryException e) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}

	@Test
	public void testAddInventoryExceptionForSugar2() {
		try {
			coffeeMaker.addInventory("4", "1", "xyz", "3");
		} catch (InventoryException e) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
	}

	/**
	 * Given a coffee maker with one existing inventory
	 * having each ingredient amount 15
	 * When we check inventory
	 * Then we get the correct list of ingredients
	 * with correct amount available.
	 */
	@Test
	public void testCheckInventory1() {
		CoffeeMaker coffeeMaker4 = new CoffeeMaker(null, new Inventory());
		assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n", coffeeMaker4.checkInventory());
	}

	@Test
	public void testCheckInventory2() throws InventoryException {
		Inventory i = new Inventory();
		CoffeeMaker coffeeMaker5 = new CoffeeMaker(null, i);
		coffeeMaker5.addInventory("15", "15", "0", "15");
		assertEquals("Coffee: 30\nMilk: 30\nSugar: 15\nChocolate: 30\n", coffeeMaker5.checkInventory());
	}

	@Test
	public void testCheckInventory3() throws RecipeException, InventoryException {
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("2");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		Recipe[] recipes = new Recipe[]{recipe1};
		RecipeBook r = mock(RecipeBook.class);
		when(r.getRecipes()).thenReturn(recipes);

		Inventory i = new Inventory();
		CoffeeMaker coffeeMaker2 = new CoffeeMaker(r, i);
		coffeeMaker2.makeCoffee(0, 50);

		assertEquals("Coffee: 12\nMilk: 14\nSugar: 14\nChocolate: 13\n",coffeeMaker2.checkInventory());
	}


	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying more than
	 * the coffee costs
	 * Then we get the correct change back.
	 */
	@Test
	public void testMakeCoffee1() throws RecipeException {

		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("2");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");

		Recipe[] recipes = new Recipe[]{recipe1};
		RecipeBook r = mock(RecipeBook.class);
		when(r.getRecipes()).thenReturn(recipes);

		Inventory i = new Inventory();
		CoffeeMaker coffeeMaker10 = new CoffeeMaker(r, i);
		assertEquals(25, coffeeMaker10.makeCoffee(0, 75));
	}


	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying equal to
	 * the coffee costs
	 * Then we get the correct change back.
	 */

	@Test
	public void testMakeCoffee2() throws RecipeException {
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("2");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");

		Recipe[] recipes = new Recipe[]{recipe1};
		RecipeBook r = mock(RecipeBook.class);
		when(r.getRecipes()).thenReturn(recipes);

		Inventory i = new Inventory();
		CoffeeMaker coffeeMaker10 = new CoffeeMaker(r, i);
		assertEquals(0, coffeeMaker10.makeCoffee(0, 50));
	}


	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying less than
	 * the coffee costs
	 * Then we get the amount paid back.
	 */
	@Test
	public void testMakeCoffee3() throws RecipeException {
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("2");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		Recipe[] recipes = new Recipe[]{recipe1};
		RecipeBook r = mock(RecipeBook.class);
		when(r.getRecipes()).thenReturn(recipes);

		Inventory i = new Inventory();
		CoffeeMaker coffeeMaker2 = new CoffeeMaker(r, i);

		assertEquals(25, coffeeMaker2.makeCoffee(0, 25));
	}

	/**
	 * Given a coffee maker with one valid recipe but in
	 * the inventory one ingredient is not available
	 * When we make coffee, selecting the valid recipe and paying more than
	 * the coffee costs
	 * <p>
	 * Then we get the amount paid back.
	 */
	@Test
	public void testMakeCoffeeWithoutChocolate4() throws RecipeException {
		RecipeBook r = mock(RecipeBook.class);
		Inventory i = new Inventory();
		CoffeeMaker coffeeMaker3 = new CoffeeMaker(r,i);

		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		Recipe[] recipes = new Recipe[]{recipe2};
		when(r.getRecipes()).thenReturn(recipes);

		assertEquals(100, coffeeMaker3.makeCoffee(0, 100));
	}

	@Test
	public void testMakeCoffeeWithoutCoffee4() throws RecipeException {
		RecipeBook r = mock(RecipeBook.class);
		Inventory i = new Inventory();
		CoffeeMaker coffeeMaker3 = new CoffeeMaker(r,i);

		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("2");
		recipe2.setAmtCoffee("30");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		Recipe[] recipes = new Recipe[]{recipe2};
		when(r.getRecipes()).thenReturn(recipes);

		assertEquals(100, coffeeMaker3.makeCoffee(0, 100));
	}
	@Test
	public void testMakeCoffeeWithoutMilk4() throws RecipeException {
		RecipeBook r = mock(RecipeBook.class);
		Inventory i = new Inventory();
		CoffeeMaker coffeeMaker3 = new CoffeeMaker(r,i);

		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("2");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("24");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		Recipe[] recipes = new Recipe[]{recipe2};
		when(r.getRecipes()).thenReturn(recipes);

		assertEquals(100, coffeeMaker3.makeCoffee(0, 100));
	}
	@Test
	public void testMakeCoffeeWithoutSugar4() throws RecipeException {
		RecipeBook r = mock(RecipeBook.class);
		Inventory i = new Inventory();
		CoffeeMaker coffeeMaker3 = new CoffeeMaker(r,i);

		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("2");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("21");
		recipe2.setPrice("75");
		coffeeMaker3.addRecipe(recipe2);
		Recipe[] recipes = new Recipe[]{recipe2};
		when(r.getRecipes()).thenReturn(recipes);

		assertEquals(100, coffeeMaker3.makeCoffee(0, 100));
	}

	/**
	 * Given a coffee maker with a valid recipe
	 * When we make coffee, selecting the valid recipe and paying equal to
	 * the coffee costs
	 * Then we get zero in return.
	 */
	@Test
	public void testMakeCoffee5() throws RecipeException {

		RecipeBook r = mock(RecipeBook.class);
		Inventory i = new Inventory();
		CoffeeMaker coffeeMaker10 = new CoffeeMaker(r,i);

		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("2");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		Recipe[] recipes = new Recipe[]{recipe2};
		when(r.getRecipes()).thenReturn(recipes);

		assertEquals(0, coffeeMaker10.makeCoffee(0, 75));
		assertEquals(12, i.getCoffee());
		assertEquals(13, i.getChocolate());
		assertEquals(14, i.getMilk());
		assertEquals(14, i.getSugar());
	}

	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the recipe not available and paying more than
	 * the coffee costs
	 * Then we get the amount paid back.
	 */
	@Test
	public void testMakeCoffee6() throws RecipeException {
		RecipeBook r = mock(RecipeBook.class);
		Inventory i = new Inventory();
		CoffeeMaker coffeeMaker11 = new CoffeeMaker(r,i);

		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("2");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		Recipe[] recipes = new Recipe[]{recipe1};
		when(r.getRecipes()).thenReturn(recipes);

		assertEquals(75, coffeeMaker11.makeCoffee(2, 75));
	}

	@Test
	public void testDeleteCoffee2() throws RecipeException {
		//Set up for recipe1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("2");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");

		//Set up for recipe2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");

		Recipe[] recipes = new Recipe[]{recipe1, recipe2};
		RecipeBook r = mock(RecipeBook.class);
		when(r.getRecipes()).thenReturn(recipes);

		Inventory i = new Inventory();
		CoffeeMaker coffeeMaker10 = new CoffeeMaker(r, i);
		assertEquals(null, coffeeMaker10.deleteRecipe(1));
	}


	/**
	 * Given a coffee maker with default inventory
	 *  where each ingredients is 15.
	 * When we try to set new value for ingredient
	 *   and it's either less than zero
	 * or alphabetic value
	 * Then we get the previous value of ingredients.
	 */
	@Test
	public void testSetIngredientsCoffee1() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.setCoffee(-2);
		int coffee = inventory.getCoffee();
		assertEquals(coffee, 15);
	}

	@Test
	public void testSetIngredientsChocolate1() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.setChocolate(-5);
		int chocolate = inventory.getChocolate();
		assertEquals(chocolate,15);
	}
	@Test
	public void testSetIngredientsMilk1() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.setMilk(-12);
		int milk = inventory.getMilk();
		assertEquals(milk, 15);
	}
	@Test
	public void testSetIngredientsSugar1() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.setSugar(-6);
		int sugar = inventory.getSugar();
		assertEquals(sugar, 15);
	}

	@Test
	public void testRecipeEqual()  {
		Recipe r = new Recipe();
		assertNotEquals( r, null);
	}

	@Test
	public void testRecipeEqual1()  {
		Recipe r = new Recipe();
		assertEquals(r, r);

	}

	@Test
	public void testRecipeEqual2()  {
		Recipe r = new Recipe();
		r.setName("abc");
		Recipe r1 = new Recipe();
		r1.setName("abc");
		assertEquals(r, r1);

	}

	@Test
	public void testRecipeEqual3()  {
		Recipe r = new Recipe();
		r.setName("abc");
		Recipe r1 = new Recipe();
		r1.setName("def");
		assertNotEquals(r, r1);

	}

	@Test
	public void testRecipeEqual4()  {
		Recipe r = new Recipe();
		Inventory i = new Inventory();
		assertNotEquals(r, i);

	}

	@Test
	public void testRecipeEqual5()  {
		Recipe r = new Recipe();
		r.setName(null);
		Recipe r1 = new Recipe();
		r1.setName("def");
		assertNotEquals(r, r1);

	}

	@Test
	public void testRecipeEqual6()  {
		Recipe r = new Recipe();
		r.setName(null);
		Recipe r1 = new Recipe();
		r1.setName(null);
		assertEquals(r, r1);

	}

	@Test
	public void testRecipeEqual7()  {
		Recipe r = new Recipe();
		r.setName(null);
		Recipe r1 = new Recipe();
		r1.setName("abc");
		assertNotEquals(r, r1);

	}

	@Test
	public void testRecipeEqual8()  {
		Recipe r = new Recipe();
		r.setName("abc");
		Recipe r1 = new Recipe();
		r1.setName(null);
		assertNotEquals(r, r1);

	}






}
