
public class Mutation {
	public int changeIt(String Start, String End, String [] Bank) 
	{
		
		
		int count = 0;
		
		if(Start.equals(End)) 
		{
			return 0;
		}
		
		
		{
			for (int i = 0; i<Bank.length;i++) 
			{
				if (isAcceptableMutation(Start,Bank[i])) 
				{
				 if (charactersOffBy(Start,End)>charactersOffBy(Bank[i],End)) 
				 {
					Start = Bank[i];
					Bank[i]=null;
					count++;
					if (Start.equals(End)) 
					{
						return count;
					}
				 }
				}
			}
		}
		return -1;
		
		
		
	}
	
	public boolean isAcceptableMutation (String str1, String str2) 
	{
		int count = 0;
		for (int i = 0; i < str1.length(); i++) 
		{
			if (!Character.toString(str1.charAt(i)).equals(Character.toString(str2.charAt(i)))) 
			{
				 count++;
			}
		}
		
		if (count == 1) 
		{
			return true;
		}
		
		return false;
	}
	
	public int charactersOffBy(String str1, String End) {
		int count=0;
		for (int i = 0; i < str1.length(); i++) 
		{
			if (!Character.toString(str1.charAt(i)).equals(Character.toString(End.charAt(i)))) 
			{
				 count++;
			}
		}
	return count;
	}

}
