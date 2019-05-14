# Error Analysis Report for kNN Model
## 360-420-DW section 00003
## David Seleznev and Noah Zlotnik

## Distributions of Model Accuracy
	
	Every time we run the classification model, we get a different accuracy. This occurs because every time we run the program, the 
training and testing set are randomly assigned different sets of data. After 1000 trials for the Breast Cancer data, the average accuracy
is 96.94%. The standard deviation of the accuracies is 1.23. The distribution of the full dataset is 65% benign and 35% malignant. Because
of this, a sensible baseline would be 65% since if we assumed all the tumours to be benign then we woul achieve 65% accuracy.

## Analysis of Different Error Types
	In the case of this dataset, a false positive is when you predict someone to have a malignant tumor when they in fact they have a
benign tumor. A false negative is when you predict someone to only have a benign tumor when in fact they have a malignant tumor. The
precision is 95.56%. The recall is 95.55%. The values are different because they divide the number of true positives by different values.
The precision divides the true positives by all predicted positives. Recall divides true positives over all actual positives. Assuming all
tumours to be benign would not be sensible since precision and recall would both be 0%. However, if we assume all tumours to be malignant,
then the precision would be 35% and the recall would be 100%, and so these are the sensible baselines. With increasing k values, the
recall goes down as the precision goes up.
