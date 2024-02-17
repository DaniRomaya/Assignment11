//Program implements bubble sort and merge sort using a generic class//



import java.util.Arrays;
import java.util.Scanner;

public class Assignment11_GenericSorting {
    public static void main(String[] args) throws Exception {
        Scanner element = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int arrayElement = element.nextInt();
        PhonePrice[] array1 = new PhonePrice[arrayElement]; 
        PhonePrice[] array2 = new PhonePrice[arrayElement];
        GenericSorting<PhonePrice> GenericSorting = new GenericSorting<>();
        generateArray(array1);
        System.out.println("Array before bubble sorting: " + Arrays.toString(array1));
        GenericSorting.bubbleSort(array1);
        System.out.println("Array after bubble sorting: " + Arrays.toString(array1));
        generateArray(array2);
        System.out.println("Array before merge sorting:  " + Arrays.toString(array2));
        GenericSorting.mergeSort(array2);
        System.out.println("Array after merge sorting: " + Arrays.toString(array2));
        element.close();
    }

    //generates an array
    public  static PhonePrice[] generateArray(PhonePrice[] array1){
        for (int i=0; i<array1.length; i++) {
            array1[i]= new PhonePrice((int) (Math.random()*300) +500);
        }
        return array1;
    }

    //generic class
    public static class GenericSorting<S extends Comparable<S>> {

        //bubble sort using generics
        public void bubbleSort(S[] array){
            int n = array.length;
            for (int i = 0; i<n-1; i++){
                for(int j = 0; j<n-i-1; j++){
                    if (array[j].compareTo(array[j+1])>0){
                        S temp = array[j];
                        array[j]=array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
        }

        //implements merge sort
        public void mergeSort(S[] array){
            if (array.length<=1){
                return;
            }
            int middle =array.length/2;
            S[] left = Arrays.copyOfRange(array, 0, middle);
            S[] right = Arrays.copyOfRange(array, middle, array.length);
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }

        //implements algorithm of merge sorting
        private void merge(S[] array, S[] left, S[] right){
            int i=0, j=0, k=0;
            while (i<left.length && j<right.length){
                if (left[i].compareTo(right[j])<=0){
                    array[k++] = left[i++];
                } else {
                    array[k++] = right[j++];
                }
            }

            while (i<left.length){
                array[k++] = left[i++];
            }

            while (j<right.length){
                array[k++] = right[j++];
            }
        }   
    }
}
