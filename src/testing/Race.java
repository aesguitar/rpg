package testing;

import util.UF;

public class Race {
	
	private String name = "";
	private int id = -1;
	private int[] bonus = new int[6];
	
	//Object containing race information
	public Race(int id, String name, int[] bonus)
	{
		for(int i = 0; i < this.bonus.length; i++)
		{
			this.bonus[i] = 0;
		}
		this.id = id;
		this.name = name;
		this.bonus = bonus;
	}
	
	//Returns the name of the race
	public String getName()
	{
		return name;
	}
	
	//Returns the racial bonuses
	public int[] getBonus()
	{
		return bonus;
	}
	
	//Returns the raceID
	public int getID()
	{
		return id;
	}
	
	public void printRace()
	{
		System.out.printf("id:\t%d\nname:\t%s\n", id, name);
		for(int i = 0; i < bonus.length; i++)
		{
			if(bonus[i] > 0)
			{
				System.out.printf("%s:\t%d\n", UF.statsList[i], bonus[i]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
