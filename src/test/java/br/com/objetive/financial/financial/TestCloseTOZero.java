package br.com.objetive.financial.financial;

import java.util.Arrays;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class TestCloseTOZero {

    static void secondWay(){
        int[] data = {2,3,-2};
        int curr = 0;
        int near = data[0];
        Arrays.sort(data);      //  add this
        System.out.println(Arrays.toString(data));
        // find the element nearest to zero
        for ( int i=0; i < data.length; i++ ){
            System.out.println("dist from " + data[i] + " = " + Math.abs(0 -data[i]));
            curr = data[i] * data[i];
            if ( curr <= (near * near) )  {
                near = data[i];
            }
        }
        System.out.println( near );
    }

    public static void main(String[] args) {
        int[] str = {2,3,-2};
        Arrays.stream(str).filter(i -> i != 0)
                .reduce((a, b) -> abs(a) < abs(b) ? a :
                                                    (abs(a) == abs(b) ? max(a, b) : b))
                .ifPresent(System.out::println);

        secondWay();
    }
}
