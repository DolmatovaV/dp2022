package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import jakarta.servlet.http.HttpServletRequest;
import sports.Sport;

public class Helpers {

	public static JsonElement bodyParse(HttpServletRequest request) {
		JsonElement jsonElement=null;	
		
		try {
			jsonElement = JsonParser.parseReader(request.getReader());
		} catch (JsonIOException | JsonSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonElement;
	}
	
	public static Sport sportParse(HttpServletRequest request) {
		Sport sport = new Sport(0, "Baseball bat", 130, "Perfect in case of a zombie apocalypse");
		JsonElement jsonElement = bodyParse(request);
		sport.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
		sport.setTitle(jsonElement.getAsJsonObject().get("title").getAsString());
		sport.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
		sport.setDesc(jsonElement.getAsJsonObject().get("desc").getAsString());
		
		return sport;
	}
	
	
	public static int getNextId(List<Sport> list) {
		int maxId = 0;
		Iterator<Sport> iterator = list.iterator();
		while(iterator.hasNext()) {
			int currentId = iterator.next().getId();
			if(currentId>maxId) maxId=currentId;
		}
		return maxId+1;
	}
	
	public static int getIndexBySportId(int Id,List<Sport> list) {
		int listId = Id;
		
		Iterator<Sport> iterator = list.iterator();
		while(iterator.hasNext()) {
			Sport temp =iterator.next();
			if(temp.getId()==listId) { 
				listId=list.indexOf(temp);
				break;
			}
		}
		return listId;
	}
	
}