package crud;

import fileIO.FileIO;
import fileIO.FileIOInterface;
import sports.Sport;

public class FileCrud implements Lab2CrudInterface {
	
	FileIOInterface fio;
	
	public FileCrud() {
		this.fio = new FileIO();
	}

	@Override
	public Sport readSport() {
		return (Sport)fio.loadFromFile();
	}

	@Override
	public void updateSport(Sport sport) {
		fio.saveToFile(sport);

	}

}