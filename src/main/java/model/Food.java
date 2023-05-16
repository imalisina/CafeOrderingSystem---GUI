package model;

public class Food extends Item 
{   
    /*
     * Constructor Name : Food()
     * Parameters : name, price, rating, category
     * Description : Alternate constructor
     */
    public Food(String name, double price, int rating, Category category) 
    {
        super(name, price, rating, category);
    }

    /*
     * Method Name : getName()
     * Parameters : none
     * Description : getter/accessor
     */
    @Override
    public String getName() 
    {
        return name;
    }

    /*
     * Method Name : getPrice()
     * Parameters : none
     * Description : getter/accessor
     */    
    @Override
    public double getPrice() 
    {
        return price;
    }

    /*
     * Method Name : getRating()
     * Parameters : none
     * Description : getter/accessor
     */
    @Override
    public int getRating() 
    {
        return rating;
    }

    /*
     * Method Name : getCategory()
     * Parameters : none
     * Description : getter/accessor
     */
    @Override
    public Category getCategory() 
    {
        return category;
    }

    /*
     * Method Name : toString()
     * Parameters : none
     * Description : display attributes of the Item objects
     */
    @Override
    public String toString() 
    {
        return "Name: " + name + ", Price: $" + price + "\nDetails - Rating: " + rating + ", Category: " + category;
    }
}
