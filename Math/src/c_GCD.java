public class c_GCD {
    /*
    HCF/GCD of 2 numbers is the max square size that can fill given numbers area.

    proof for below:
    let GCD(a,b)=g then: a=gx, b=gy
    GCD(x,y)=1
    a-b = g(x-y)
    this means 'g' is also GCD of b,a-b

     */
    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b); //if you are thinking why a%b instead of a-b, work on maths first!
    }
    public static void main(String[] args)
    {
        int a =60 , b = 75;
        System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b));
    }
    /*
    HCF * LCM = a*b
     */
}