package model;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class Order extends Updater{
    // attributes
    private double totalPrice;

    // global variable to store user choice
    private int categoryChoiceId = 0;

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
    public void autoGenerateMeal()
    {
         // Loop through the code until the user is satisfied with their selection
        do 
        {
            // Switch case to specify the order 
            switch (categoryChoiceId) {
                case 1:
                    // find and display the item requested by the user
                    Food breakfast = finder.findBreakfast(generateMealId(CATEGORY_MENU_SIZE));
                    System.out.println("\n" + breakfast.toString());
                    // Add the item to the specified list for the order summary
                    foodOrder.add(breakfast);
                    break;
                case 2:
                    // find and display the item requested by the user
                    Food lunch = finder.findLunch(generateMealId(CATEGORY_MENU_SIZE));
                    System.out.println("\n" + lunch.toString());
                    // Add the item to the specified list for the order summary
                    foodOrder.add(lunch);
                    break;
                case 3:
                    // find and display the item requested by the user
                    Food fastfood = finder.findFastFood(generateMealId(CATEGORY_MENU_SIZE));
                    System.out.println("\n" + fastfood.toString());
                    // Add the item to the specified list for the order summary
                    foodOrder.add(fastfood);
                    break;
            }
        } while (categoryChoiceId != 0);
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
}
