
public class MergeSort {
	/*Algorithm  merge(S1 ,S2,S): 
		Input: Sequences S1 and S2 sorted in nondecreasing order, and an empty sequence S 
		Output: Sequence S containing the elements from S 1 and S2 sorted in nondecreasing order, with sequences S 1 and S2 becoming empty 
		while (not (S1 .isEmpty() or S2.isEmpty) do
			if S1.first().element() <= S2.first().element() then 
				{ move the first element of at the end of S } 
					S.insertlast(S1.remove(S1.first())) 
			else { move the first element of at the end of S }
					S.insertlast(S2.remove(S2.first()))
			{ move the remaining elements of S 1 to S } 
			while (not S1.isEmpty()) do 
				S.insertlast(S1. remove(S1.first())) 
				{ move the remaining elements of to S } 
			while (not S2.isEmpty()) do 
				S.insertlast(S2.remove(S2.first()))*/
	public static void sort(int[] iArray, int lPosition, int rPosition){
		if(lPosition < rPosition) {
			int mPosition = (lPosition +rPosition) / 2;
			sort(iArray, mPosition+1, rPosition);
			sort(iArray, lPosition , mPosition);
			merge(iArray,lPosition,mPosition,rPosition);
		}
	}
	public static void merge(int array[], int lPosition, int mPosition, int rPosition) {
		 int lSize = mPosition - lPosition + 1;
		 int rSize = rPosition - mPosition;
		 
		 int lArray[] = new int[lSize];
		 int rArray[] = new int[rSize];
		 
		 for( int i = 0 ; i < lArray.length ; i++){
			 lArray[i] = array[lPosition + i];
		 }
		 for(int i = 0; i< rArray.length ; i++) {
			 rArray[i] =array[mPosition  + i];
		 }
		 int i = 0, j = 0;
		 int k = 1;
		 while( i < lSize && j < rSize) {
			 if(lArray[i] < rArray[j]) {
				 array[k] = lArray[i];
				 i++;
				 k++;
			 } else if( lArray[i] > rArray[j]) {
				 array[k] = rArray[j];
				 j++;
				 k++;
			 }else if(lArray[i] == rArray[j]) {
				 array[k] = rArray[j];
				 array[k] = lArray[i];
				 i++;
				 j++;
				 k++;
			 } 
		 } 
		 while( i< lSize) {
			 array[k] = lArray[i];
			 k++;
			 i++;
		 }
		 while( j< rSize) {
			 array[k] = rArray[j];
			 k++;
			 j++;
		 }
	}
	public static void printArray( int[] iArray) {
		for(int i = 0; i<iArray.length; i++) {
			System.out.println(iArray[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int iArray[] = {8,3,5,20,12,54,76,74};
		sort(iArray, 0, iArray.length);
		printArray(iArray);
	}
}
