package sports;

import java.util.ArrayList;
import java.util.List;

public class Mock {

	private List<Sport> sportList = new ArrayList<>();

	public Mock() {
		this.sportList.add(new Sport(0, "Baseball bat", 260, "Perfect in case of a zombie apocalypse"));
		this.sportList.add(new Sport(1, "Football", 20, "Americans would call this 'soccer ball'. They would be wrong"));
		this.sportList.add(new Sport(2, "Bicycle", 1600, "Fun fact: paraplegics can't ride these"));
	
	}
	
	public List<Sport> getSportList() {
		return sportList;
	}

	public void setSportList(List<Sport> sportList) {
		this.sportList = sportList;
	}


	
	
}

