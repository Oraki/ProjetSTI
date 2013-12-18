
public class Apprenant
{
	int KNOWLEDGE_COUNT = 4;
	
	// 0 -> KNOWLEDGE_1, //Validation d'une valeur avec la stratégie de l'hypothèse seule explicite 
	// 1 -> KNOWLEDGE_2, //Validation d'une valeur avec la stratégie de l'hypothèse seule cachée 
	// 2 -> KNOWLEDGE_3, //Elimination d'une hypothèses avec les règles de bases
	// 3 -> KNOWLEDGE_4, //Elimination d'une hypothèses avec la stratégie des paires d'hypothèses explicite
	int knowledge_success[] = new int[KNOWLEDGE_COUNT];
	
	// 0 -> FAIL_1, //Echec dans l'ajout d'un chiffre
	// 1 -> FAIL_2, //Echec dans la suppression d'un hypothèse
	
	int knowledge_fail[] = new int[KNOWLEDGE_COUNT];
	
	int knowledge_sucess_ponderation[] = new int[KNOWLEDGE_COUNT];
	int knowledge_fail_ponderation[] = new int[KNOWLEDGE_COUNT/2];
	int knowledge_lvl[] = new int[4];
	
	int numRandom;
	int nombreDeCoupJoue;
	int nombreDHypoCorrectesFaites;
	
	// 0 -> KNOWLEDGE_1, //Validation d'une valeur avec la stratégie de l'hypothèse seule explicite 
	// 1 -> KNOWLEDGE_2, //Validation d'une valeur avec la stratégie de l'hypothèse seule cachée 
	// 2 -> KNOWLEDGE_3, //Elimination d'une hypothèses avec les règles de bases
	// 3 -> KNOWLEDGE_4, //Elimination d'une hypothèses avec la stratégie des paires d'hypothèses explicite
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
		knowledge_sucess_ponderation[0] = 10;
		knowledge_sucess_ponderation[1] = 30;
		knowledge_sucess_ponderation[2] = 1;
		knowledge_sucess_ponderation[3] = 30;
		
		knowledge_fail_ponderation[0] = 20;
		knowledge_fail_ponderation[1] = 15;
		
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
			lvl += (knowledge_success[i] * knowledge_sucess_ponderation[i]);
		}
		
		for (int i = 0; i< KNOWLEDGE_COUNT; i++)
		{
			lvl -= (knowledge_fail[i] * knowledge_fail_ponderation[i]);
		}
		
		int a = 0;
		while(lvl > knowledge_lvl[a])
		{
			a++;
		}
		
		return a;
	
	}
	
}