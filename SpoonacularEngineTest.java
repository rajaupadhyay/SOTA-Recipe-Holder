package recipe;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

public class SpoonacularEngineTest {
	public static SpoonacularEngine mockedSpoonacularEngine;
	public static List<FoodRecipe> result = new ArrayList<>();
	public static List<AnalyzedRecipe> analyzedRecipe = new ArrayList<>();
	static SpoonacularEngine x = new SpoonacularEngine();

			@BeforeClass
	public static void setUp() throws UnirestException{
		mockedSpoonacularEngine = mock(SpoonacularEngine.class);
		ArrayList<String> ings = new ArrayList<String>();
		ings.add("Pasta");
		ings.add("Prawns");
		result.add(new FoodRecipe("Gnocchi With Shrimp, Asparagus and Pesto", 527293));
		result.add(new FoodRecipe("Roasted Shrimp with Lemon Pasta", 592877));
		result.add(new FoodRecipe("Grilled Oregano Shrimp", 5857));	
		
		analyzedRecipe = x.getRecipe(527293);		
						
		when(mockedSpoonacularEngine.findRecipeByIngredient(ings)).thenReturn(result);	
		when(mockedSpoonacularEngine.getRecipe(527293)).thenReturn(analyzedRecipe);
		
	}
	
	
	@Test
	public void testFindRecipeByIngredient() throws UnirestException
	{	
		ArrayList<String> ings = new ArrayList<String>();
		ings.add("Pasta");
		ings.add("Prawns");		
		
		List<FoodRecipe> feedback = mockedSpoonacularEngine.findRecipeByIngredient(ings);
		assertEquals(3, feedback.size());
		FoodRecipe recipeName = feedback.get(0);
		assertEquals("Gnocchi With Shrimp, Asparagus and Pesto", recipeName.getTitle());		
		
	}
	
	@Test
	public void testGetRecipe() throws JSONException, UnirestException {
		List<AnalyzedRecipe> analyzedRecipe = new ArrayList<>();
		analyzedRecipe = mockedSpoonacularEngine.getRecipe(527293);
		System.out.println(analyzedRecipe);
		ArrayList<String> sample = analyzedRecipe.get(0).getSteps();
		assertEquals("Heat olive oil in a skillet over medium heat.", sample.get(0));
		assertEquals("Add asparagus and saute for 3 minutes. Then add shrimp, season everything with salt and (lots of!) freshly ground black pepper, and continue sauteing until shrimp are cooked (pink and no longer translucent).", sample.get(1));
	}
	
	
	
	

}
