package model;

public interface Items 
{   
    /*
     * Method Name : itemSeeder()
     * Parameters : none
     * Description : abstract Method to create item objects
     */
    public abstract void itemSeeder();

    /*
     * Method Name : find()
     * Parameters : category, id
     * Description : abstract Method to find item objects
     */
    public abstract Item find(String category, int id);
}

