package recipe;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class AnalyzedRecipe {
	private final String name;
	private ArrayList<Integer> number = new ArrayList<>();
    private ArrayList<String> steps = new ArrayList<>();
    private JSONArray x = new JSONArray();
    //ArrayList<String> z = new ArrayList<>();
    

    public AnalyzedRecipe(String name, JSONArray steps) {
        this.name = name;
                   
         
        /*if (steps != null) { 
           for (int i=0;i<steps.length();i++){ 
        	this.number.add(steps.getInt(i));   
            this.steps.add(steps.getString(i));
           }
           }*/
        
        for (int i = 0; i < steps.length(); i++) {
            JSONObject obj = steps.getJSONObject(i);
            String step = obj.getString("step");
            this.steps.add(step);
           
        }

        
        
    }
    

	public ArrayList<String> getSteps() {
        return steps;
    }

     

	public String getName() {
		return name;
	}

}
