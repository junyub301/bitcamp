package bitcamp.java100;

public class Test15_6 {
      
    public static void main(String[] args){

        int r = 2 + 3 * 4;
        System.out.println(r);

        r = 2 + 3 * 4 -6 / 3 + 7;
        System.out.println(r);

        r = (2 + 3) * 4;
        System.out.println(r);

    }

}

/* 우선순위
괄호                    ()
postfix	                expr++ expr--
unary	                ++expr --expr +expr -expr ~ !
multiplicative	        * / %
additive    	        + -
shift	                << >> >>>
relational	            < > <= >= instanceof
equality	            == !=
bitwise AND 	        &
bitwise exclusive OR	^
bitwise inclusive OR	|
logical AND	            &&
logical OR	            ||
ternary	                ? :
assignment	            = += -= *= /= %= &= ^= |= <<= >>= >>>=
*/