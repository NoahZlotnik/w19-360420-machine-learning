import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

   
	String Path_To_Data = args[0];
	DataSet Iris = new DataSet();
	List<DataPoint> Iris1 = DataSet.readDataSet(Path_To_Data);
	
	DataPoint a = Iris1.get(5);
	String Label = a.getLabel();
	double [] values = a.getX();
	
	/*System.out.println( Label);
	
	for(int i=0; i< values.length; i ++)
	{
		System.out.println( + values[i]);
	}*/
	
	
	
	KNNClassifier thingToFind = new KNNClassifier (17);
	
	
	
	
	/*DataPoint IrisA = Iris1.get(0);
	double [] valuesA = IrisA.getX();
	for(int i=1; i< values.length; i ++)
	{
		System.out.println( + valuesA[i]);
	}
	DataPoint IrisB = Iris1.get(40);
	double [] valuesB = IrisB.getX();
	for(int i=1; i< values.length; i ++)
	{
		System.out.println( + valuesB[i]);
	}
	double distance = DataSet.distanceEuclid(IrisA,IrisB);
	System.out.println(distance);*/

	double [] storage = new double [1000];
	double percentTotal = 0;
	int ctr = 0;
	int ctr2 = 0;
	int ctr3 = 0;
	double precision = 0;
	int ctr4 = 0;
	int ctr5 = 0;
	double recall = 0;
	
	
	for (int j = 0; j < 1000; j ++)
	{
		Iris1 = DataSet.readDataSet(Path_To_Data);
		List<DataPoint> Insurance = DataSet.getTestSet(Iris1, 0.3);
		List<DataPoint> Train = DataSet.getTrainingSet(Iris1, 0.7);
		
		ctr = 0;
		for (int i = 0; i < Insurance.size(); i ++)
		{
			String predictedThingy = thingToFind.predict( Train, Insurance.get(i));
			if(predictedThingy .equals (Insurance.get(i).getLabel()))
			{
				ctr++; 
			}
			//System.out.println( predictedThingy);
		}
		double percentage = (double)(ctr)/(double)(Insurance.size()) * 100;
		storage[j] = percentage;
		percentTotal = percentTotal + percentage;
		ctr2 = 0;
		ctr3 = 0;
		for(int i = 0; i < Insurance.size(); i ++)
		{
			String predictedThingy = thingToFind.predict(Train,Insurance.get(i));
			if(predictedThingy.equals("malignant"))
			{
				ctr3++;
				if (predictedThingy.equals(Insurance.get(i).getLabel()))
				{
					ctr2++;
				}
			}
			
			
		}
		
		precision = precision + ((double)(ctr2))/((double)(ctr3))*100.0;
		ctr4 = 0;
		ctr5 = 0;
		for(int i = 0; i < Insurance.size(); i++)
		{
			String predictedThingy = thingToFind.predict(Train,Insurance.get(i));
			if(Insurance.get(i).getLabel().equals("malignant"))
			{
				ctr5++;
				if(predictedThingy.equals(Insurance.get(i).getLabel()))
				{
					ctr4++;
				}
			}
		}
		recall = recall + ((double)(ctr4))/((double)(ctr5))*100.0;
	}
	
	System.out.println("Recall is " + recall/1000.0 + "%");
	System.out.println("Precision is " + precision/1000.0 + "%");
//	double finalPercent = percentTotal/1000.0;
//	System.out.println(finalPercent + " average");
	double average = mean(storage);
	System.out.println(average + " mean");
	double sd = standardDeviation(storage);
	System.out.println(sd + " standard deviation");
	DataSet.printLabelFrequencies(Iris1);
	

	
  }

  public static double mean(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: average of the elements of array, as a double
    */
    double sum = 0.0;

    for (double a : arr){
      sum += a;
    }
    return (double)sum/arr.length;
  }

  public static double standardDeviation(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: standard deviation of the elements of array, as a double
    Dependencies: requires the *mean* method written above
    */
    double avg = mean(arr);
    double sum = 0.0;
    for (double a : arr){
      sum += Math.pow(a-avg,2);
    }
    return (double)sum/arr.length;
  }

}
