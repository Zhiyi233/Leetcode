public class threeYuan {
    public static void main(String[] args) {
        int m = 12;
        int n = 5;

        //三目运算符，true 表达式1，false 表达式2
        //表达式1 2要求一致，不能不同类型的表达式
        int max = (m>n)?m:n;
        System.out.println(max);

        //**********************************

        n = 12;
        //可以嵌套
        String maxStr = (m>n)?"m is big":((m==n)?"m equals n":"n is big");
        System.out.println(maxStr);

        //找出3个中最大的值
        int a = 17;
        int b = 124;
        int c = 10;

        int max1 = (a > b)? a:b;
        int max2 = (max1 > c)? max1:c;
        System.out.println(max2);
    }
}
