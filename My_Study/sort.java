import java.io.*;
import java.util.*;

public class sort {
	static int [] arr = {4,2,1,5,8,7,3,6};;
	public static void main(String[] args) throws IOException {
		
				//insertion();
				
		quickSort(arr, 0, arr.length-1);
				
				
				System.out.println(0);
	}
	private static void insertion() { // 삽입
		for(int i=1; i<arr.length; i++) {
			int temp = arr[i];
			int prev = i-1;
			while((prev>=0) && (arr[prev]>temp)) {
				arr[prev+1] = arr[prev--];
			}
			arr[prev+1] = temp;
		}
	}
	
	 private static void quickSort(int[] arr, int left, int right) {
	        int L = left;
	        int R = right;
	        int pivot = arr[(left + right) / 2];
	   			// 피벗을 배열의 가운데 위치한 요소로 설정.

	        while (L <= R) {
	          	// 피벗 왼쪽에는 피벗보다 작은 원소들이 위치해야 하고, 큰 원소가 있다면 반복문을 나온다.
	            while (arr[L] < pivot) L++;
				
	          	// 피벗 오른쪽에는 피벗보다 큰 원소들이 위치해야 하고, 작은 원소가 있다면 반복문을 나온다.
	            while (pivot < arr[R]) R--;

	          	// L과 R이 역전되지 않고, 같은 경우가 아니라면 두 원소의 위치를 교환한다.
	          	// 이를 통해서 피벗 기준으로 왼쪽에는 작은 원소가, 오른쪽에는 큰 원소가 위치하게 된다.
	            if (L <= R) {
	                if (L != R) {
	                    swap(arr, L, R);
	                }
	                L++;
	                R--;
	            }
	        }

	   	// L과 R이 역전된 후에 피벗의 왼쪽과 오른쪽에는 정렬되지 않은 부분 배열이 남아있을 수 있다.
	   	// 이 경우, 남아 있는 부분 배열에 대해서 퀵 정렬을 수행한다.
	        if (left < R) quickSort(arr, left, R);

	        if (L < right) quickSort(arr, L, right);
	    }

	    // 입력 받은 원소의 자리를 교환해준다.
	    private static void swap(int[] arr, int left, int right) {
	        int temp = arr[left];
	        arr[left] = arr[right];
	        arr[right] = temp;
	    }
}
