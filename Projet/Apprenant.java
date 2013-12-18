
public class Apprenant
{
	int KNOWLEDGE_COUNT = 6;
	int knowledge_success[] = new int[KNOWLEDGE_COUNT];
	int knowledge_fail[] = new int[KNOWLEDGE_COUNT];
	
	int knowledge_ponderation[] = new int[KNOWLEDGE_COUNT];
	int knowledge_lvl[] = new int[4];
	
	int numRandom;
	int nombreDeCoupJoue;
	int nombreDHypoCorrectesFaites;
	
	// 0 -> KNOWLEDGE_1, //Validation d'une valeur avec la strat�gie de l'hypoth�se seule explicite 
	// 1 -> KNOWLEDGE_2, //Validation d'une valeur avec la strat�gie de l'hypoth�se seule cach�e 
	// 2 -> KNOWLEDGE_3, //Elimination d'une hypoth�ses avec les r�gles de bases
	// 3 -> KNOWLEDGE_4, //Elimination d'une hypoth�ses avec la strat�gie des paires d'hypoth�ses explicite
	// 4 -> KNOWLEDGE_5,
	// 5 -> KNOWLEDGE_6,
	// 6 -> KNOWLEDGE_7,
	// 7 -> KNOWLEDGE_8,
	// 8 -> KNOWLEDGE_9, // Random
	
	public Apprenant()
	{
		for (int i = 0 ; i < KNOWLEDGE_COUNT; i++ )
		{
			knowledge_success[i] = 0;
			knowledge_fail[i] = 0;
		}
		//A calibrer
		knowledge_ponderation[0] = 1;
		knowledge_ponderation[1] = 5;
		knowledge_ponderation[2] = 10;
		knowledge_ponderation[3] = 30;
		//A calibrer
		knowledge_lvl[0] = 10;
		knowledge_lvl[1] = 30;
		knowledge_lvl[2] = 60;
		knowledge_lvl[3] = 100;
		
		numRandom = 0;
		nombreDeCoupJoue = 0;
		nombreDHypoCorrectesFaites = 0;
	}
	
	public void AddSuccess(int knowledge)
	{
		knowledge_success[knowledge]++;
		AddCoupJoue();
	}
	
	public void AddFail(int knowledge)
	{
		knowledge_fail[knowledge]++;
		AddCoupJoue();
	}
	
	public void AddRandom()
	{
		numRandom++;
	}
	
	public void AddCoupJoue()
	{
		nombreDeCoupJoue++;
	}
	
	public int GetNiveau()
	{
		int lvl = 0;
		
		for (int i = 0; i< KNOWLEDGE_COUNT; i++)
		{
			lvl += (knowledge_success[i] - knowledge_fail[i]) * knowledge_ponderation[i];
		}
		
		int a = 0;
		while(lvl > knowledge_lvl[a])
		{
			a++;
		}
		
		return a;
	
	}
	
}