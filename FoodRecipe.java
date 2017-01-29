package recipe;

public class FoodRecipe {
	private final String title;
    //private final String imageUrl;
    private final int id;

    public FoodRecipe(String title, int id) {
        this.title = title;
        //this.imageUrl = imageUrl;
        this.id = id;
        
    }

	public String getTitle() {
        return title;
    }

   
    public int getId() {
        return id;
    }

   
}
