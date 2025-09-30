public class hammingAlgo {
    public static int getHammingBit(String parityScheme, int sum) {

        int hammingBit;
        if (parityScheme.equalsIgnoreCase("ODD")) {

            int r = sum % 2;
            if (r != 0) {
                hammingBit = 0;
            } else {
                hammingBit = 1;
            }
        } else { //even parity
            int r = sum % 2;
            if (r != 0) {
                hammingBit = 1;
            } else {
                hammingBit = 0;
            }

        }
        return hammingBit;
    }
        public static void main(String[] args){
            // 110000111001
        int[] inp= {1,1,0,0,0,0,1,1,1,0,1};
        int [] msg = {2,9,1,9,1,0,0,9,0,0,1,1,1,0,0,9,1};
        String parityScheme = "ODD";
        int msgLength = msg.length;
        int s1= 0;
        int h;

        //calculatr h1 (For practicing sum)
        System.out.println(msgLength);
        for( int i=3; i<msgLength; i+=2)
            s1 += msg[i];

            System.out.println(s1);
            h = getHammingBit ( "ODD", s1);
            System.out.println(h);
            int s2 = 0;
            for(int i=5; i < msgLength; i++){
                if((i != 6) && (i != 7) && (i != 12) && (i != 14)) {
                    if(i % 4 == 1 || i % 4 == 2) s2 += msg[i];
                }
            }
            System.out.println(s2);
            int h2 = getHammingBit(parityScheme, s2);
            System.out.println(h2);

            int s3 = 0;
            for(int i=3; i < msgLength; i++){
                if(i != 4 && i != 5 && i != 6 && i != 7 && i != 13){
                    if(i % 8 < 4 && i > 2) s3 += msg[i];
                }
            }

    }


    }