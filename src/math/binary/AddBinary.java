package math.binary;

public class AddBinary {

    public String addBinary(String x, String y) {
        int j = y.length() -1;

        int i = x.length()-1;
        int s = 0;
        String sum = "";
        while (i >=0 || j >= 0) {

            if(i >= 0) {
                s += ((i >= 0)? x.charAt(i) - '0': 0);
                i--;
            }
            if(j >= 0) {
                s += ((j >= 0)? y.charAt(j) - '0': 0);

                j--;
            }


            sum =  s % 2  + "0" + sum;
            s /= 2;
        }
        System.out.println(s);
        return sum;
    }

}
