package onboarding;

import java.util.Arrays;
import java.util.List;


class Problem1 {

    static int isValid(int[] pobi, int[] crong) {
        if (pobi[0]==1 || crong[0]==1 || pobi[1]==400 || crong[1]==400) {
            return -1;
        }
        int checkPobi = pobi[1] - pobi[0];
        int checkCrong = crong[1] - crong[0];
        if (checkPobi!=1 || checkCrong!=1){
            return -1;
        }
        return 0;
    }

    static int parseAndMul(int input) {
        String str = Integer.toString(input);
        String[] elements = str.split("");
        int result = 1;
        for(String element: elements){
            result = result * Integer.parseInt(element);
        }
        return result;
    }

    static int parseAndAdd(int input) {
        String str = Integer.toString(input);
        String[] elements = str.split("");
        int result = 0;
        for(String element: elements){
            result = result + Integer.parseInt(element);
        }
        return result;
    }

    static int getScore(int[] pages) {
        int[] nums = new int[4];
        nums[0] = parseAndMul(pages[0]);
        nums[1] = parseAndAdd(pages[0]);
        nums[2] = parseAndMul(pages[1]);
        nums[3] = parseAndAdd(pages[1]);
        Arrays.sort(nums);
        int maximum = nums[3];
        return maximum;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int[] pobiArr = pobi.stream().mapToInt(i->i).toArray();
        int[] crongArr = crong.stream().mapToInt(i->i).toArray();;

        // Page validation
        int validity = isValid(pobiArr, crongArr);
        if (validity == -1) {
            return -1;
        }

        // Get score
        int pobiScore = getScore(pobiArr);
        int crongScore = getScore(crongArr);

        // Compare
        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }

    }
}