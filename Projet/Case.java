
public class Case
{
	public int chiffre; //chiffre d�finitif mis dans la case
	
	public boolean tabHypo[] = new boolean[9]; //false le chiffre ne peut se trouver l�
	
	
	public Case()
	{
		chiffre = 0;
		
		for (int i  = 0; i < 9; i++)
		{
			tabHypo[i]=false;
		}
	}
	
	public boolean CaseRemplie()
	{
		return (chiffre != 0);
	}
	
}