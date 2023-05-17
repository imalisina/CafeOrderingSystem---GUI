package model;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class Order extends Updater{
    // attributes
    private double totalPrice = 0;

    // constants
    private final int CATEGORY_MENU_SIZE = 5;

    // Linked list to store collection of items per Order
    private LinkedList<Food> foodOrder = new LinkedList<Food>();

    // An instance of Finder class
    private Finder finder = new Finder();

    // An instance of Decimal format class
    private DecimalFormat formatter = new DecimalFormat("#.##");

    /*
     * Constructor Name : Order()
     * Parameters : none
     * Description : Default Constructor
     */
    public Order() 
    {

    }


    /*
     * Method Name : displayMealMenu()
     * Parameters : categoryId
     * Description : display the menu based on the selected category
     */
    public String displayMealMenu(String category) {
        // Switch case to find the correct category field
        switch (category) {
            case "Breakfast":
                return displayBreakfastMenu();
            case "Lunch":
                return displayLunchMenu();
            case "Fast Food":
                return displayFastFoodMenu();
        }
        return "";
    }

    /*
     * Method Name : selectMeal()
     * Parameters : none
     * Description : - allow the user to randomly generate their meals
     */
    public String autoGenerateMeal(String category)
    {
        // Switch case to specify the order 
        switch (category) {
            case "Breakfast":
                // find and display the item requested by the user
                Food breakfast = finder.findBreakfast(generateMealId(CATEGORY_MENU_SIZE));
                // Add the item to the specified list for the order summary
                foodOrder.add(breakfast);
                return breakfast.toString();
            case "Lunch":
                // find and display the item requested by the user
                Food lunch = finder.findLunch(generateMealId(CATEGORY_MENU_SIZE));
                // Add the item to the specified list for the order summary
                foodOrder.add(lunch);
                return lunch.toString();
            case "Fast Food":
                // find and display the item requested by the user
                Food fastfood = finder.findFastFood(generateMealId(CATEGORY_MENU_SIZE));
                // Add the item to the specified list for the order summary
                foodOrder.add(fastfood);
                return fastfood.toString();
        }
        return "";
    }

    public String displayOrderSummary() {
        StringBuilder summaryBuilder = new StringBuilder();

        // If the user ordered from the Food Category, display each Item
        if (foodOrder.size() != 0) {
            // Loop through the food list
            for (Food food : foodOrder) {
                // Calculate new total
                totalPrice += food.price;

                // Append food item information to the summary
                summaryBuilder.append(food.toString());
                summaryBuilder.append("\n\n");
            }

            // Return the complete summary
            return summaryBuilder.toString();
        }

        return "No Meal Selected!!";
    }


    public String displayTotalPrice()
    {
        // If the user ordered fro the Food Category, display each Item
        if (foodOrder.size() != 0) {
            // Loop through the food list
            for (Food food : foodOrder) {
                // Calculate new total
                totalPrice += food.price;
            }
        }
        // Format price to 2 decimal places
        String price = formatter.format(totalPrice);
        // Display formatted total cost of order
        return "\nTOTAL : $" + price;
    }

    /*
     * Method Name : generateMealId()
     * Parameters : sizeOfCategory
     * Description : generate random meal Id
     */
    public int generateMealId(int sizeOfCategory)
    {
        return ((int) Math.round(Math.random() * (sizeOfCategory - 1))) + 1;
        
    }

    /*
     * Method Name : displayBreakfastMenu()
     * Parameters : none
     * Description : display all the brekafast items
     */
    public String displayBreakfastMenu() {
        Foods breakfast = new Foods();
        breakfast.filterBreakfastMeals();
        return breakfast.displayBreakfastMenu();
    }

    /*
     * Method Name : displayLunchMenu()
     * Parameters : none
     * Description : display all the lunch items
     */
    public String displayLunchMenu() {
        Foods lunch = new Foods();
        lunch.filterLunchMeals();
        return lunch.displayLunchMenu();
    }

    /*
     * Method Name : displayFastFoodMenu()
     * Parameters : none
     * Description : display all the fast food items
     */
    public String displayFastFoodMenu() {
        Foods fastfood = new Foods();
        fastfood.filterFastFoodMeals();
        return fastfood.displayFastFoodMenu();
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }
}
