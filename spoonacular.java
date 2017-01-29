package recipe;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class spoonacular {
	
	
	
		public static final String API_KEY = "mEe1EyPU1fmshl9GtvwhAhxqC8m1p18xaTJjsnFX6SMn1NYSg9";
		
		public final List<FoodRecipe> findRecipeByIngredient(String ingredient) throws UnirestException {
	        HttpResponse<JsonNode> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/recipes/findByIngredients?ingredients="+ingredient+"&limitLicense=false&number=6&ranking=1")
	                .header("X-Mashape-Key", API_KEY)
	                .asJson();

	        final List<FoodRecipe> result = new ArrayList<>();
	        final JSONArray body = response.getBody().getArray();
	        for (int i = 0; i < body.length(); i++) {
	            final JSONObject node = body.getJSONObject(i);
	            result.add(new FoodRecipe(node.getString("title"), node.getInt("id")));
	        }
	        return result;
		}
		
		
		
			
		public final List<AnalyzedRecipe> getRecipe(int s) throws JSONException, UnirestException {
			HttpResponse<JsonNode> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/recipes/" + String.valueOf(s) + "/analyzedInstructions?stepBreakdown=true")
					.header("X-Mashape-Key", API_KEY)
					.header("Accept", "application/json")
					.asJson();
		
			final List<AnalyzedRecipe> result = new ArrayList<>();
	        final JSONArray body = response.getBody().getArray();
	        for (int i = 0; i < body.length(); i++) {
	            final JSONObject node = body.getJSONObject(i);
	            result.add(new AnalyzedRecipe(node.getString("name"), node.getJSONArray("steps")));
	        }
	        return result;
		
		
		

	    
		}
}
