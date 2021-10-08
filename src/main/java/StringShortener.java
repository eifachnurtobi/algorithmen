public class StringShortener {
    private static final String SHORTENED_STRING_APPENDIX = "...";

    public static String shorten(String text, int maxlength){
        StringBuilder shortenedSB = new StringBuilder();
        String[] words = text.split(" ");
        for (String word : words) {
            // String length, plus what would be added, plus last space.
            if(shortenedSB.length()+word.length()+1 > maxlength){
                shortenedSB.append(SHORTENED_STRING_APPENDIX);
                break;
            }

            shortenedSB.append(word);
            shortenedSB.append(' ');
        }

        return shortenedSB.toString();
    }
}
