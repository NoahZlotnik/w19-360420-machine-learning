import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class kNNMain{

  public static void main(String[] args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	
	String PATH_TO_DATA = args[0]; 										// gets first cmd line arg
	List<DataPoint> irisData = DataSet.readDataSet(PATH_TO_DATA); 	// passes DataSet.readDataSet a file path and stores return value
	DataPoint chosenDataPoint = irisData.get(87);						// stores a given datapoint (the first one)
	//System.out.println("Features:");
	for (int i = 0; i < chosenDataPoint.x.length; i++) { 				// iterates through features of datapoint's 'x' attribute and prints them
		//System.out.println(chosenDataPoint.x[i]);
	}
	//System.out.println("Label: " + chosenDataPoint.label);				// prints datapoint's label attribute


    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	List<DataPoint> training = DataSet.getTrainingSet(irisData,0.8);
	List<DataPoint> testing	 = DataSet.getTestSet(irisData,0.2);



    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)
	// all done


    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
	KNNClassifier figureOutThisBoi = new KNNClassifier(5);
	//String gotty = figureOutThisBoi.predict(irisData,chosenDataPoint);
	//System.out.println(gotty);

		String gotty = figureOutThisBoi.predict(training,testing.get(0));
		int count = 0;
    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
	for(int i = 0; i<testing.size();i++){
		gotty = figureOutThisBoi.predict(training,testing.get(i));
		//System.out.println(gotty);
		//System.out.println(testing.get(i).getLabel());
		if(gotty.equals(testing.get(i).getLabel())){
			count++;
		}	
	}
	System.out.println("Accuracy is " + (double)(count) / (double)(testing.size()) * 100. + "%");	
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
