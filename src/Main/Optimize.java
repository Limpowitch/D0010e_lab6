package Main;
import Main.RunSim;
import Helper_Functions.K;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import State.StoreState;
public class Optimize implements K{	
	public static void main(String args[]) 
	{
		Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an example to run (1 or 2):");
        int choice = scanner.nextInt();
    	Optimize optimize = new Optimize();

        switch (choice) {
            case 1:		
                optimize.Optimizer(K.SEED);
                break;
            case 2:
                optimize.loopThroughCapacity(K.SEED);
                break;
            default:
                System.out.println("Error: Invalid choice.");
                break;
        }
	
	}
	
	public int returnMissedCustomers(int maxCheckoutCapacity, int seed)  // WIP TODO: Metoden ska bara köra en gång och returnera sluttilsståndet.
	{
		//RunSim runSim = new RunSim(seed, K.L, K.M, maxCheckoutCapacity, K.LOW_COLLECTION_TIME, K.HIGH_COLLECTION_TIME, K.LOW_PAYMENT_TIME, K.HIGH_COLLECTION_TIME, K.END_TIME, 0); // ex1
        RunSim runSim = new RunSim(seed, K.L, K.M, maxCheckoutCapacity, K.LOW_COLLECTION_TIME, K.HIGH_COLLECTION_TIME, K.LOW_PAYMENT_TIME, K.HIGH_PAYMENT_TIME, K.END_TIME, 0); // ex1

		StoreState storeState = runSim.getStoreState();
		
		storeState.updatePrintAll(0);
		int returnedvalue = storeState.getMissedCustomers();
		
		return returnedvalue;
		
	}
	public int loopThroughCapacity(int seed) // WIP TODO: Metoden ska steppa från 1 kassa till max antal kunder i butiken och hitta det optimala antalet kassor
	{
		int storeStateInitial = returnMissedCustomers(1, seed);
		int Smallest = storeStateInitial;
		
		//System.out.println("Starting smallest" + Smallest + "\n");
		int optimalCheckout = 1;
		for(int i = 1; i < K.M; i++)
		{
			int storeState = returnMissedCustomers(i, seed);
			//System.out.print("This is the amount of missed customers: " + storeState + "\n");

				if(Smallest > storeState)
				{	
					//System.out.print("found smaller" + storeState + "\n");
					Smallest = storeState;
					optimalCheckout = i;
				}
				
			}
		System.out.print("Optimal found checkout: " + optimalCheckout + "\n");
		return optimalCheckout;
		}
		
	
	public void Optimizer(int seed)
	{
		Random random = new Random(seed);
		int total = 0;
		int notFoundLower = 0;
		int indexCounter = 0;
		int returnedInitialValue = loopThroughCapacity(random.nextInt());
		
		for (int i = 0; i < 100; i++) {
			int returnedValue = loopThroughCapacity(random.nextInt());
			//System.out.print(returnedValue);
			
			if(returnedInitialValue > returnedValue)
			{
				returnedInitialValue = returnedValue;
				notFoundLower = 0;
			} else {
				notFoundLower++;
			}
			

			if(notFoundLower != 10) {
				total = total + returnedValue;
				indexCounter++;
			} else {
				indexCounter++;
				System.out.print("notFoundLower counter at 10, cant find lower. Breaking out at iteration: " + indexCounter + "\n");
				break;
			}
			//System.out.println("Current indexCounter: " + indexCounter);
			//System.out.println("Current notFoundLower: " + notFoundLower);

			
			
		}
		System.out.println("Average value: " + total/indexCounter);
	}
}
