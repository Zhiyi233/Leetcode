public class Plusone {
    public int[] plusOne(int[] digits) {
        int size = digits.length;

        for(int i=size-1; i>=0;i--){
            //if the last digit of array is not 9 just add 1
            if(digits[i]!=9){
                digits[i]++;
                return digits;
            }else{
                //the last digit is 9 we need to make it to 0
                digits[i]=0;
            }
        }

        //if all the integers in the array are 9
        //The length of digit will add one
        digits = new int[size+1];
        digits[0]=1;
        return digits;
    }
//
//    public static void main(String[] args) {
//        Plusone ps = new Plusone();
//        int result[] = ps.plusOne(new int[]{9,9});
//        for(int i=0;i<result.length;i++){
//            System.out.println(result[i]);
//        }
//    }
}
