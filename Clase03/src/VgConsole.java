
public class VgConsole {
	private String name;
	private int year;
	
	VgConsole(){
		
	}
	VgConsole(String name, int year){
		setName(name);
		setYear(year);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getname() {
		return name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
