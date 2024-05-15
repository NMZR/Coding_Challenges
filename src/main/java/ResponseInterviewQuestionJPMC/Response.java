package ResponseInterviewQuestionJPMC;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Response {
    /// This method processes a batch of HTTP requests to determine their validity.
    ///it has 2 parameters, request and validatetoken
    // request:  A list of lists, where each inner list represents a single HTTP request. Each request list
    // contains the HTTP method (like "GET" or "POST") and the URL, which may include query parameters.
    //validAuthTokens: a list of string represent valid authentication

    public static List<String> getResponses(List<List<String>> requests, List<String> validAuthTokens) {
        List<String> responses = new ArrayList<>();
        for (List<String> request : requests) {
            responses.add(validate(request, validAuthTokens));
        }
        return responses;
    }


// validate method: Validates a single HTTP request against a list of
// valid authentication tokens and specific method-based rules.
// it also has 2 parameter
//reques: alist of string where the first element of http method and the second
//in the url
//validthoke: a list of valid authentication
// how it works:
    //Extracts the HTTP method and URL from the request.
//Calls parseParameters to extract query parameters from the URL.
//Retrieves the authentication token from the query parameters.
//Checks if the token is in the list of valid authentication tokens.
//If the token is valid:
//For a "GET" request, removes the "token" parameter from the query parameters and returns "VALID" followed by the remaining parameters.
//For a "POST" request, additionally checks for a valid CSRF token that matches a regex pattern. If valid, it removes both "token" and "csrf" parameters before returning "VALID" with the remaining parameters.
//If the validation fails at any point, returns "INVALID".
    private static String validate(List<String> request, List<String> validAuthTokens) {
        String method = request.get(0);
        String url = request.get(1);
        Map<String, String> params = parseParameters(url);
        String token = params.get("token");
        boolean isValidToken = validAuthTokens.contains(token);

        if (isValidToken) {
            if (method.equals("GET")) {
                // For GET, remove the token from parameters
                params.remove("token");
                return "VALID, " + paramsToString(params);
            } else if (method.equals("POST")) {
                // For POST, additionally check for CSRF token
                String csrf = params.get("csrf");
                if (csrf != null && csrf.matches("[a-zA-Z0-9]{8}")) {
                    params.remove("token"); // Remove the token
                    params.remove("csrf"); // Remove the csrf token
                    return "VALID, " + paramsToString(params);
                }
            }
        }
        return "INVALID";
    }
// Extracts query parameters from a url
// url is the parameter
//how it works?
// Splits the URL at the "?" character to separate the base URL from the query string.
//Splits the query string into key-value pairs using "&".
//Further splits each pair into a key and a value using "=".
//Stores these key-value pairs in a HashMap.
//Returns this map.
    private static Map<String, String> parseParameters(String url) {
        Map<String, String> params = new HashMap<>();
        String[] urlParts = url.split("\\?");
        if (urlParts.length > 1) {
            String[] pairs = urlParts[1].split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                params.put(keyValue[0], keyValue.length > 1 ? keyValue[1] : "");
            }
        }
        return params;
    }
// this methode  converts a map of query parameters into a string format
//params: A map containing query parameter keys and values.
//how it works?
//Streams the entry set of the map.
//Maps each entry to a string in the format "key=value".
//Collects all strings into a single string joined by ", ".
    private static String paramsToString(Map<String, String> params) {
        return params.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining(", "));
    }
// the main is just to execute the codes
    public static void main(String[] args) {

        List<List<String>> requests = Arrays.asList(
                Arrays.asList("GET", "https://example.com/api?token=abcd1234&user_id=1001"),
                Arrays.asList("POST", "https://example.com/submit?token=abcd1234&csrf=xyz7890123")
        );
        List<String> validTokens = Arrays.asList("abcd1234");
        List<String> responses = getResponses(requests, validTokens);
        responses.forEach(System.out::println);
    }
}
