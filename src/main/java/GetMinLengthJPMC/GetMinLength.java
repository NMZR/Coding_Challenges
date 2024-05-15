package GetMinLengthJPMC;

//To solve the problem described, you need to implement the getMinLength function.
// The key is to iteratively remove the substrings "AB" or "BB"
// until no more can be removed, and then return the length of the remaining string.
public class GetMinLength {
    public static int getMinLength(String seq) {
        // Create a StringBuilder to efficiently manipulate strings
        StringBuilder sb = new StringBuilder(seq);

        // This variable will track our position in the StringBuilder
        int i = 0;

        // We'll iterate over the StringBuilder
        while (i < sb.length() - 1) {
            // Check for "AB" or "BB" substrings
            if ((sb.charAt(i) == 'A' && sb.charAt(i + 1) == 'B') || (sb.charAt(i) == 'B' && sb.charAt(i + 1) == 'B')) {
                // Remove the substring starting at index i
                sb.delete(i, i + 2);
                // After removing a pair, step back one position to check for new possible removals
                if (i > 0) i--;
            } else {
                // If no pair is found, move to the next character
                i++;
            }
        }

        // Return the length of the remaining string
        return sb.length();
    }
}


