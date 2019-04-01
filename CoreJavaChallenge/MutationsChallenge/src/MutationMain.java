
public class MutationMain 
{
	public static void main(String[] args) 
	{
		Mutation mu = new Mutation();
		String Start = "AGCTAGCTTG";
		String End =  "AAAATTTTCC";
		String[] Bank = {"AGCTAGCTTG", "AACTAGCTTG", "AAATAGCTTG", "AAAAAGCTTG", "AAAATGCTTG", "AAAATTCTTG", "AAAATTTTTG", "AAAATTTTCG", "AAAATTTTCC"};
		System.out.println(mu.changeIt(Start, End, Bank));
	}
	
//	public static void main(String[] args) 
//	{
//		Mutation mu = new Mutation();
//		String Start = "AGCT";
//		String End =  "AAAA";
//		String[] Bank = {"AGCT", "AACT", "AAAT", "AAAA"};
//		System.out.println(mu.changeIt(Start, End, Bank));
//	}
}
