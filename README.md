# taxes-mad
Evaluation of the taxes to be paid for a set of pre-configured items based on the following rules:
 1. Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt.
 2. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.
 3. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

The application allows to collect in a Cart a list of items.
There are 3 pre-configured test cases and the option to create freely a cart.


## Installation

The Application is an executable jar either you can run the application using your favorite IDE 
or build the executable jar with maven package goal and then launch using the command java -jar taxes-mad-1.0.0-SNAPSHOT (or whatever the name of the jar may be)
The class containing the main method is : com.taxesmad.start.MarketTest.

## Usage

Once the application is started a menu is printed with different options, below an example of the menu:

>Select the test you want to perform:
>[1] - 1 book at 12.49|1 music CD at 14.99|1 chocolate bar at 0.85
>[2] - 1 imported box of chocolates at 10.00|1 imported bottle of perfume at 47.50
>[3] - 1 imported bottle of perfume at 27.99|1 bottle of perfume at 18.99|1 packet of headache pills at 9.75|1 box of imported chocolates at 11.25
>[4] - Compose the cart as you want choosing the products from the Catalog



