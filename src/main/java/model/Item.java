package model;

public abstract class Item 
{
    // attributes
    protected String name;
    protected double price;
    protected int rating;
    public Category category;

    /*
     * Constructor Name : Item()
     * Parameters : name, price, rating, category
     * Description : Alternate constructor
     */
    public Item(String name, double price, int rating, Category category) 
    {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.category = category;
    }

    /*
     * Method Name : getName()
     * Parameters : none
     * Description : getter/accessor
     */
    public abstract String getName();

    /*
     * Method Name : getPrice()
     * Parameters : none
     * Description : getter/accessor
     */    
    public abstract double getPrice();

    /*
     * Method Name : getRating()
     * Parameters : none
     * Description : getter/accessor
     */
    public abstract int getRating();

    /*
     * Method Name : getCategory()
     * Parameters : none
     * Description : getter/accessor
     */
    public abstract Category getCategory();

    /*
     * Method Name : toString()
     * Parameters : none
     * Description : display attributes of the Item objects
     */
    @Override
    public abstract String toString();
    
}
