

@ebayall
Feature: As user Ebay
 		I want filter the products for different criterias 
 		to buy ones that were more suited for me.

  @shoes
  Scenario: Filter shoes for brand and size
	  Given I access ebay website
	  And   I enter 'shoes' in box
		When  I click on the search button
		And   I select brand
		And   I select size
		And   I order of ascending form
		Then  The order the first 5 results should be correct