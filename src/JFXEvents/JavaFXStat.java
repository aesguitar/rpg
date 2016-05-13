package JFXEvents;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class JavaFXStat {
	
	private final SimpleStringProperty name;
	private final SimpleIntegerProperty value;
	
	public JavaFXStat(String name, int value)
	{
		this.name = new SimpleStringProperty(name);
		this.value = new SimpleIntegerProperty(value);
	}
	
	public JavaFXStat(util.Stat stat)
	{
		name = new SimpleStringProperty(stat.getName());
		value = new SimpleIntegerProperty(stat.getValue());
	}
	
	public String getName()
	{
		return name.get();
	}
	
	public Integer getValue()
	{
		return value.get();
	}
}
