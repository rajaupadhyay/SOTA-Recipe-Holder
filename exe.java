package recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mashape.unirest.http.exceptions.UnirestException;



public class exe {
	public static void main(String[] args) throws UnirestException 
	{
		spoonacular x = new spoonacular();
		//System.out.println(x.findRecipeByIngredient("Cheese"));
		List<FoodRecipe> z = new ArrayList<>();
	    ArrayList<String> ings = new ArrayList<String>();
	    ings.add("Pasta");
	    ings.add("Prawns");
	    
	    String listString = "";

	    for (int i=0; i<ings.size();++i)
	    {
	        if(i != ings.size()-1){
	        	listString += ings.get(i) + "%2C";
	        }
	        else{
	        	listString += ings.get(i);
	        }
	    	
	    }
	    //System.out.println(listString);
	    
		//z = x.findRecipeByIngredient("Flour");
	    z = x.findRecipeByIngredient(listString);
		
		System.out.println(z.get(0).getTitle());
		System.out.println(z.get(0).getId());
		int id = z.get(0).getId();
		//System.out.println(Arrays.toString(z.toArray()));
		
		List<AnalyzedRecipe> result = new ArrayList<>();
		
		
		result = x.getRecipe(id);
		if(result.size() > 0)
		{
		System.out.println(result.get(0).getSteps());
		}
		else{
			System.out.println("No recipe available.");
		}
		
		
		
		
		
		
	}
	
	

}
