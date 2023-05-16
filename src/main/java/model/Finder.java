package model;

public class Finder 
{
    /*
     * Constructor Name : Finder()
     * parameters : none
     * Description : Default constructor
     */
    public Finder()
    {

    }
    
    /*
     * Method Name : findBreakfast()
     * parameters : id
     * Description : Find the breakfast Meal at the given index 
     *               and return the meal as a Food object
     */
    public Food findBreakfast(int id)
    {
        Foods breakfast = new Foods();
        breakfast.filterBreakfastMeals();
        return breakfast.find("Breakfast",id);
    }

    /*
     * Method Name : findLunch()
     * parameters : id
     * Description : Find the lunch Meal at the given index 
     *               and return the meal as a Food object
     */
    public Food findLunch(int id)
    {
        Foods lunch = new Foods();
        lunch.filterLunchMeals();
        return lunch.find("Lunch", id);
    }

    /*
     * Method Name : findFastFood()
     * parameters : id
     * Description : Find the fastfood Meal at the given index 
     *               and return the meal as a Food object
     */
    public Food findFastFood(int id)
    {
        Foods fastfood = new Foods();
        fastfood.filterFastFoodMeals();
        return fastfood.find("Fast Food", id);
    }
}
