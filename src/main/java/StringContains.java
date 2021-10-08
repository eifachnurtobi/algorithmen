public class StringContains {
    public static boolean contains(String query, String text){
        for(int i=0; i<text.length();i++){
            for(int j=0;(j<query.length());j++){
                if(
                        i+j > text.length()-1 ||
                        !(query.charAt(j) == text.charAt(i+j))
                ){
                    break;
                }

                if(j == query.length()-1){
                    return true;
                }
            }
        }

        return false;
    }
}
