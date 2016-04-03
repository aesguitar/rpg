package testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		File rl = new File("race-list.txt");

		Scanner in = null;
		ArrayList<Race> rlist = new ArrayList<Race>();
		int lineNumber = 0;
		int[] b = new int[6];
		int id = 0;
		String rname = "";

		try {
			in = new Scanner(rl);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lineNumber++;
		String line = in.nextLine().trim();
		String tmp = line;
		while(in.hasNextLine())
		{		

			System.out.println(tmp);
			if(!tmp.startsWith("#"))
			{
				if(tmp.startsWith("{"))
				{

					for(int i = 0; i < b.length; i++)
						b[i] = 0;

					String ids = tmp.replaceAll("\\{", "").replaceAll("\\}", "");
					id = Integer.parseInt(ids);
					System.out.printf("id = %d\n", id);
					tmp = in.nextLine().trim();

					//System.out.println(tmp);
					while(tmp.startsWith("r:"))
					{	
						tmp = tmp.replaceAll("r:", "");
						if(tmp.startsWith("name"))
						{
							tmp = tmp.replaceFirst("name","").trim().replace("=", "").trim().replaceAll("\"", "");
							rname = tmp;
							//System.out.printf("name = %s\n", rname);
						}
						else if(tmp.startsWith("bonus"))
						{
							//System.out.println(tmp);
							tmp = tmp.replaceFirst("bonus","").trim().replace("=", "").trim().replaceAll("\"", "").replaceAll(",", "");
							tmp = tmp.toLowerCase();
							if(tmp.startsWith("str"))
							{
								tmp = tmp.replaceAll("strength", "");
								b[0] = Integer.parseInt(tmp);
							}
							else if(tmp.startsWith("dex"))
							{
								tmp = tmp.replaceAll("dexterity", "");
								b[1] = Integer.parseInt(tmp);
							}
							else if(tmp.startsWith("con"))
							{
								tmp = tmp.replaceAll("constitution", "");
								b[2] = Integer.parseInt(tmp);
							}
							else if(tmp.startsWith("int"))
							{
								tmp = tmp.replaceAll("intelligence", "");
								b[3] = Integer.parseInt(tmp);
							}
							else if(tmp.startsWith("wis"))
							{
								tmp = tmp.replaceAll("wisdom", "");
								b[4] = Integer.parseInt(tmp);
							}
							else if(tmp.startsWith("cha"))
							{
								tmp = tmp.replaceAll("charisma", "");
								b[5] = Integer.parseInt(tmp);
							}
							else
							{
								throw new ParseException("Unknown bonus: " + line, lineNumber);
							}
						}
						else
							throw new ParseException("Unknown Parameter: " + line.replaceAll("r:", ""), lineNumber);
						if(in.hasNextLine())
							tmp = in.nextLine().trim();
					}
					rlist.add(new Race(id, rname, Arrays.copyOf(b, b.length)));	
				}			
			}
			else{
				line = in.nextLine();
				tmp =line;
			}
		}
		System.out.printf("\n\n\nRace list: \n\n");
		Iterator<Race> it = rlist.iterator();
		while(it.hasNext())
			{it.next().printRace(); System.out.println();}

	}
}