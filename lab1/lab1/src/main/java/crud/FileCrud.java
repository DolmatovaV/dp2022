package crud;

import FileIO.FileIO;
import FileIO.FileIOInterface;
import sports.Sport;

public class FileCrud implements Lab2CrudInterface {
	
	FileIOInterface fio;

	public FileCrud() {
	this.fio = new FileIO();
	}

	@Override
	public Sport readSport() {
		// TODO Auto-generated method stub
		return (Sport) fio.loadFromFile();
	}

	@Override
	public void updateSport(Sport sport) {
		// TODO Auto-generated method stub
		fio.saveToFile(sport);

	}
}