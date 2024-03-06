package Main;
import Main.RunSim;
import Helper_Functions.K;
import java.util.ArrayList;
public class Optimize {

	private int maxCapacity=5;
	private double lambda=1;
	private int maxCheckoutCapacity=5; 
	private double pickLow=0.5; 
	private double pickHigh=1; 
	private double payLow=2; 
	private double payHigh=3;
	private int seed=1234;
	
	
	public Optimize() 
	{
		
		
	
	}
	
	public int alternativ1(int maxCheckoutCapacity)  // WIP TODO: Metoden ska bara köra en gång och returnera sluttilsståndet.
	{
		RunSim runsim = new RunSim();
		
		int missed = runsim.startNew(seed,
				lambda,
				maxCapacity,
				maxCheckoutCapacity,
				pickLow,pickHigh,
				payLow,
				payHigh);
		
		return missed;
	}
	public void alternativ2() // WIP TODO: Metoden ska steppa från 1 kassa till max antal kunder i butiken och hitta det optimala antalet kassor
	{
		
		ArrayList<Integer> missed_costumers = new ArrayList<Integer>();
		for(int testOptimum = 1;testOptimum<=maxCheckoutCapacity;testOptimum++)
		{
			int missed = alternativ1(testOptimum);
			missed_costumers.add(missed);
			
		}
		int smallest = missed_costumers.get(0);
		for(int i = 0;i<missed_costumers.size();i++)
		{
			if(smallest < missed_costumers.get(i))
			{
				smallest = missed_costumers.get(i);
			}
			
		}
		System.out.println("Missade kunder idag:" + smallest);
		
	}
	public void alternativ3()
	{
		//TODO: Denna metod ska slumpa mellan en massa seed värden och ska hitta det minsta antal kassor som behövs till max antal kunder.
		
	}
}
