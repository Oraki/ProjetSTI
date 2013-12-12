
public class Apprenant
{
	int KNOWLEDGE_COUNT = 6;
	int knowledge_success[] = new int[KNOWLEDGE_COUNT];
	int knowledge_fail[] = new int[KNOWLEDGE_COUNT];
	int numRandom;
	int nombreDeCoupJoue;
	int nombreDHypoCorrectesFaites;
	
	// 0 -> KNOWLEDGE_1, //Voir un chiffre d'une ligne et l'�liminer de cette derni�re
	// 1 -> KNOWLEDGE_2, //Voir un chiffre d'une colonne et l'�liminer de cette derni�re
	// 2 -> KNOWLEDGE_3, //Voir un chiffre d'une r�gion et l'�liminer de cette derni�re
	// 3 -> KNOWLEDGE_4, //Valider un chiffre sur une case lorsque c'est la seule possibilit�
	// 4 -> KNOWLEDGE_5, 
	// 5 -> KNOWLEDGE_6, // Random
	
	public Apprenant()
	{
		for (int i = 0 ; i < KNOWLEDGE_COUNT; i++ )
		{
			knowledge_success[i] = 0;
			knowledge_fail[i] = 0;
		}
		numRandom = 0;
		nombreDeCoupJoue = 0;
		nombreDHypoCorrectesFaites = 0;
	}
	
	void AddSuccess(int knowledge)
	{
		knowledge_success[knowledge]++;
	}
	
	void AddFail(int knowledge)
	{
		knowledge_fail[knowledge]++;
	}
	
	void AddRandom()
	{
		numRandom++;
	}
	
	void AddCoupJoue()
	{
		nombreDeCoupJoue++;
	}
	
}