import java.util.Scanner;

public class Majority {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        int[] elements = new int[a];
        for (int i=0; i<a; i++) {
            elements[i] = scanner.nextInt();
        }

        System.out.println(isMajorityElementThere(elements));
    }

    private static int isMajorityElementThere(int[] arr) {

        int candidateKey = findCandidateKey(arr);
        int count = countCandidateKey(arr, candidateKey);
        int n = (int)Math.floor(arr.length/2);
//        System.out.println("n->"+n);

        if(count>n) {
            return 1;
        }
        return 0;
    }

    private static int countCandidateKey(int[] arr, int key) {
        int count=0;
        for (int i=0; i<arr.length; i++ ) {
            if(arr[i]==key) {
                count++;
            }
        }
//        System.out.println("count->"+count);
        return count;
    }

    private static int findCandidateKey(int[] arr) {
        int temp=arr[0];
        int count = 1;
        for (int i=1; i<arr.length; i++) {
            if(temp==arr[i]) {
                count++;
            }
            else {
                count--;
            }
            if(count==0) {
                temp= arr[i];
                count++;
            }
        }
//        System.out.println("candidate->"+temp);
        return temp;
    }
}
