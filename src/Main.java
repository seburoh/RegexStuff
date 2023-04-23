import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /*
    TODO output capture, ion casing
     */

    /**
     * Unused, it prints some regex for fun so I know when I ran the wrong file :D.
     * @param args unused.
     */
    public static void main(String[] args) {
        String rgx = "^" //if start of str required to be good
                + "(" //begin month capture group
                + "(1[012])" //months 10-12
                + "|(0?[1-9])" //OR: months 1-9, 01-09
                + ")" //end month capture group
                + "[-/]{1}" //MM-DD separator
                + "(" //begin day capture group
                + "0?[1-9]" //capture days 1-9, 01-09
                + "|([1-2][0-9])" //OR: days 10-29
                + "|3[01]" //OR: days 30, 31
                + ")" //end day capture group
                + "[-/]{1}" //DD-YYYY separator
                + "\\d+" //Years can be any amount of digits, 1, 01, 99999, they are all years at some point in time
                //+ "\\d{4}" //optional four digit date only
                + "$"; //end of string reached

        System.out.println(rgx);
    }

    private static boolean regexChecker(final String rgx, final String input) {
        Pattern pat = Pattern.compile(rgx);
        Matcher mat = pat.matcher(input);

        return mat.matches(); //bet this works.

        //from the harness, probably don't need.
//        if (mat.find()) {
//            System.out.printf("I found the text" +
//                            " \"%s\" starting at " +
//                            "index %d and ending at index %d.%n",
//                    mat.group(),
//                    mat.start(),
//                    mat.end());
//            return true;
//        }
//
//        return false;
    }

    /**
     * Accepts only valid SSNs, well-formed.
     * No preceding or following characters allowed, 0-1 dashes or spaces allowed between number blocks.
     * Allows for a mix of spaces and dashes.
     * Uses rules for SSNs found <a href="https://en.wikipedia.org/wiki/Social_Security_number#Valid_SSNs">here</a>.
     * @param input string to check.
     * @return if string is valid SSN.
     */
    public static boolean isSSN(final String input) {
        String rgx = "^" //if start of str required to be good
                + "(?!666|000|9\\d{2})\\d{3}" //disallow 666,000,900-999, take 3 digits
                + "[- ]?" //take - or space 0-1 times.
                + "(?!00)\\d{2}" //disallow 00, take two digits
                + "[- ]?" //take - or space 0-1 times.
                + "(?!0000)\\d{4}" //disallow 0000, take four digits
                + "$"; //if end of str required to be good

        return regexChecker(rgx, input);
    }

    /**
     * Accepts only valid US phone numbers, well-formed
     * No preceding or following characters allowed, 0-1 dashes allowed between number blocks.
     * Parens are optional, Country Code is optional.
     * Rules for valid phone numbers taken from <a href="https://en.wikipedia.org/wiki/All-number_calling">here</a>.
     * Basic explanation of rules is first two blocks must be 200-999, fourth block unbound.
     * Service codes (911,211, etc.) also function properly.
     * "Bad" numbers like 911-333-4444 allowed, as this should just dial out to 911 proper in life as a safeguard.
     * There is a commented out line which prevents above numbers, which can be used in place of it's preceding line.
     * @param input string to check.
     * @return if string is valid US phone number.
     */
    public static boolean isPhoneNumber(final String input) {
        String rgx = "^" //if start of str required to be good
                + "(" //Start of normal block
                + "(1|1\\-)?" //country code optional
                + "\\(?" //take ( 0-1 times
                + "(?!0\\d{2}|1\\d{2})" //disallow 000-199
                //+ "(?!0\\d{2}|1\\d{2}|\\d11)" //OPTIONAL: disallow 000-199 + service codes as full numbers
                + "\\d{3}" //take 3 digits
                + "\\)?\\-?" //take ) 0-1 times plus - 0-1 times
                + "(?!0\\d{2}|1\\d{2})" //disallow 000-199
                + "\\d{3}" //take 3 digits
                + "\\-?" //take - 0-1 times
                + "\\d{4}" //take 4 digits
                + ")$" //End of normal block
                + "|^" //Start of service code block
                + "(?!0|1)" //disallow 011,111
                + "\\d11" //allow 211,311,...,911
                + "$"; //if end of str required to be good

        return regexChecker(rgx, input);
    }

    /**
     * Does not adhere to proper email standard because good god no. Does check for basic form.
     * Rules followed are listed <a href="https://en.wikipedia.org/wiki/Email_address#Syntax">here</a>.
     * Some rules are not followed (comments, quotes, etc).
     * Basic rules followed: no consecutive periods, domain and local chunks cannot begin or end on period.
     * Character set of allowed characters are the allowed characters for non-comment, non-quote email formats.
     * In researching what formats emails must adhere to, I found the below, which at one point was ALMOST correct.
     * It scares me: <a href="http://www.ex-parrot.com/%7Epdw/Mail-RFC822-Address.html">yikes</a>.
     * @param input string to verify as email.
     * @return if string was email.
     */
    public static boolean isEmail(final String input) {
        String rgx = "^" //if start of str required to be good
                + "(?!\\.)" //ensure local does not start with period
                + "((?!\\.{2})[.!#$%&'*+\\-/=?^_`{|}~\\w\\d])*" //disallow consecutive periods, capture optional chunk.
                + "[!#$%&'*+\\-/=?^_`{|}~\\w\\d]+" //final capture chunk of local, to ensure does not end on period.
                + "@" //split to domain chunk
                + "[a-zA-Z\\-\\d]+" //first domain chunk
                + "\\." //main period of domain
                + "(?!\\.)" //prevent consecutive periods.
                + "((?!\\.{2})[a-zA-Z\\-.\\d])*" //optional middle domain chunk, allows non-consecutive periods.
                + "[a-zA-Z\\-\\d]+" //final capture of domain, to ensure it doesn't end on periods
                + "$"; //end of string reached

        return regexChecker(rgx, input);
    }

    /**
     * Accepts valid names in format of 'Last, First, MI'.
     * The separators between name chunks can be ',' ', ' or ' '.
     * Dashes are allowed within name chunks, including MI, but not at beginning/end of chunks.
     * Less strict positioning rules are available, as the commented out code.
     * Allowing the name to end with a period is also available as commented out code.
     * Unintended behavior: Optional period function allows Last to end in period if MI not supplied.
     * @param input string to verify as name.
     * @return if string was well-formed name.
     */
    public static boolean isName(final String input) {
        String rgx = "^" //if start of str required to be good
                + "[a-zA-Z][a-zA-Z\\-]*[a-zA-Z]" //First name starts/ends with letters, dashes allowed in middle
                + "( |, |,)" //strict valid separators.
                //+ "[, ]{1,2}" //optional less strict valid separators between first/last name
                + "[a-zA-Z][a-zA-Z\\-]*[a-zA-Z]" //Last name starts/ends with letters, dashes allowed in middle
                + "(" //begin MI group
                + "( |, |,)?" //strict optional valid separators for middle initial
                //+ "[, ]{0,2}" //optional less strict valid separators for middle initial
                + "(?!\\-)" //MI cannot start with dash
                + "[a-zA-Z\\-]*" //MI can include dashes inside
                + "(?<!\\-| )" //MI cannot end with dashes
//                + "\\.?" //optional allowance of MI to end in period
                + ")?" //end MI group
                + "$"; //end of string reached

        return regexChecker(rgx, input);
    }

    /**
     * Accepts valid dates in format of MM-DD-YYYY.
     * Accepts any numerical value for Y, 0 year, 99999 year, all are years.
     * Optional code commented out for securing that years must be 4 digits.
     * Checks if month is within 1-12, 01 and 02 valid.
     * Checks if day is valid to current month, leading 0's for single digits valid.
     * @param input string to check if year.
     * @return if string was year.
     */
    public static boolean isDate(final String input) {
        String rgx = "^" //if start of str required to be good
                + "(" //begin month capture group
                + "(1[012])" //months 10-12
                + "|(0?[1-9])" //OR: months 1-9, 01-09
                + ")" //end month capture group
                + "[-/]{1}" //MM-DD separator
                + "(" //begin day capture group
                + "0?[1-9]" //capture days 1-9, 01-09
                + "|([1-2][0-9])" //OR: days 10-29
                + "|3[01]" //OR: days 30, 31
                + ")" //end day capture group
                + "[-/]{1}" //DD-YYYY separator
                + "\\d+" //Years can be any amount of digits, 1, 01, 99999, they are all years at some point in time
                //+ "\\d{4}" //optional four digit date only
                + "$"; //end of string reached

        if (regexChecker(rgx, input)) {
            String[] date = input.split("[-/]");

            //System.out.println("DEBUG: " + Arrays.toString(date));
            int year = Integer.parseInt(date[2]);
            int day = Integer.parseInt(date[1]);
            int mon = Integer.parseInt(date[0]);

            //months with 31 days
            Integer[] tOne = {1,3,5,7,8,10,12};
            List<Integer> thirtyOne = Arrays.asList(tOne);

            if (thirtyOne.contains(mon)) { //31 day months
                return true;
            } else if (mon == 2) { //feb sucks
                if ((year % 100 != 0 && year % 4 == 0) || (year % 100 == 0 && year % 400 == 0)) {
                    return day <= 29; //leap
                } else {
                    return day <= 28; //no leap
                }
            } else { //30 day months
                return day <= 30;
            }
        }
        return false;
    }

    /**
     * Accepts valid addresses that are well-formed.
     * Addresses must be of type number road-name road-type.
     * Road name can be multiple words.
     * Road type must be ave,rd,st,blvd, or their full-name equivalents.
     * Case is insensitive, it doesn't mind if you're lower or upper, you live your life.
     * @param input string to check as address.
     * @return if string was address.
     */
    public static boolean isAddress(final String input) {
        String rgx = "(?i)" //case-insensitive for whole situation
                + "^" //if start of str required to be good
                + "\\d+" //house numbers can be anything
                + " " //space before street name
                + "(?! )" //prevent consecutive spaces
                + "[a-z ]*" //road names anything we desire, with multiple words
                + "[a-z]" //ensure road name ends on a letter
                + " " //space before last chunk
                + "(" //begin last chunk grouping
                + "r(oa)?d" //rd, road
                + "|st(reet)?" //OR st, street
                + "|blvd" //OR blvd
                + "|ave(nue)?" //OR ave,avenue
                + "|boulevard" //OR boulevard
                + ")" //end last chunk grouping
                + "$"; //end of string reached

        return regexChecker(rgx, input);
    }

    /**
     * Accepts valid city state zipcodes that are well-formed.
     * States must be their two letter abbreviation approved by the FAA.
     * List of abbrev's <a href="https://www.faa.gov/air_traffic/publications/atpubs/cnt_html/appendix_a.html">here</a>.
     * Chunks may be separated by at most one space and/or comma, in a well-formed order.
     * City names may be multiple words.
     * @param input string to verify as city state zip.
     * @return if string was valid.
     */
    public static boolean isCityState(final String input) {
        String rgx = "(?i)" //case-insensitive for whole situation
                + "^" //if start of str required to be good
                + "(?! )" //ensure does not start with space
                + "[a-z ]*" //city name can be multiple words
                + "[a-z]" //ensure city ends with letter
                + "( |, |,){1}" //strict separator for city-state
                + "(a[lkzrs]|c[aot]|d[ec]|fl|g[au]|hi|i[dlna]|k[sy]|la|m[edainsotp]" //state codes
                + "|n[evhjmycd]|o[hkr]|p[ar]|ri|s[cd]|t[nxt]|ut|v[tai]|w[aviy])" //more state codes
                + "( |, |,){1}" //strict separator for state-zip
                + "\\d{5}" //zips are five digits
                + "$"; //end of string reached

        return regexChecker(rgx, input);
    }

    /**
     * Accepts valid military time that is well-formed.
     * HH:MM accepted, if single digit hour must be preceding 0 as per standard.
     * optional ability for single digit hour commented out.
     * Hours and Minutes must be within normal 24h clock.
     * @param input string to check as military time.
     * @return if string was military time.
     */
    public static boolean isMilitaryTime(final String input) {
        String rgx = "^" //if start of str required to be good
                + "(" //begin hour group
                + "([01]\\d)" //if hour begins with 0,1, can end in any digit
                + "|(2[0-3])" //OR: if hour begins with 2, can end in 0-3
                //+ "|\\d" //optional: no leading 0
                + ")" //end hour group
                + ":" //wheeee
                + "[0-5]" //minutes can begin with 0-5
                + "\\d" //minutes can end in any digit
                + "$"; //end of string reached

        return regexChecker(rgx, input);
    }

    /**
     * Accepts valid US currency that is well-formed.
     * Input must begin with $ and have a period to separate out the cents.
     * Cents must be double digits.
     * Dollars must have separating commas.
     * @param input string to check if valid currency.
     * @return if string was valid.
     */
    public static boolean isCurrency(final String input) {
        String rgx = "^" //if start of str required to be good
                + "\\$" //begin with a $ sign
                + "\\d{0,3}" //up to three digits for "front" of currency
                + "(,\\d{3})*" //chained ,NNN for as many times as needed
                + "\\." //the period ending dollars
                + "\\d{2}" //cents exists
                + "$"; //end of string reached

        return regexChecker(rgx, input);
    }

    /**
     * Accepts valid URLs that are mostly well-formed.
     * http,https, are optional.
     * URL must end in a letter/number or forward slash.
     * Case-insensitive, feelings are built of steel.
     * Split into two "bodies" so that there must be at least one period in URL.
     * @param input string to check as URL.
     * @return if string was URL.
     */
    public static boolean isURL(final String input) {
        String rgx = "(?i)" //case-insensitive for whole situation
                + "^" //if start of str required to be good
                + "(https?://)?" //allows for optional input of http,https at beginning
                + "(" //start main body one
                + "[\\w_]+" //as many letters/numbers as we want
                + "\\." //ensure main body one ends in period
                + ")" //close main body one
                + "(" //open main body two
                + "[\\w_]+" //as many letters/numbers as we want
                + "[./\\-#]" //singular funny characters
                + ")*" //close main body group, allow for it to spin as many times as needed, minimum zero
                + "[\\w]+" //ensure after main body, that there are still some valid chars to finish with
                + "/?" //ending on a / is ok
                + "$"; //end of string reached

        return regexChecker(rgx, input);
    }

    /**
     * Accepts valid passwords, if you like terrible passwords.
     * Must be at least 10 char long.
     * Must include: uppercase, lowercase, number, and ! characters.
     * Must not include triple consecutive repeated characters.
     * @param input string to check as valid password.
     * @return if string was valid.
     */
    public static boolean isPassword(final String input) {
        String rgx = "^" //if start of str required to be good
                + "(?=.*[a-z])" //do we have at least one lower case?
                + "(?=.*[A-Z])" //upper case?
                + "(?=.*\\d)" //number?
                + "(?=.*!)" //!?
                + "(?!.*(.)\\1{2,})" //for any character, do we find two+ duplicates after it?
                + "[A-Za-z\\d!]" //eat the whole string
                + "{10,}" //ensure we eat at least 10 characters
                + "$"; //end of string reached

        return regexChecker(rgx, input);
    }

    /**
     * Accepts odd character count words which end in "ion".
     * Case-insensitive for the "ion" append of the word.
     * If case is desired to be sensed, swap the commented regex out below.
     * @param input string to check for ions.
     * @return if string was properly ionized.
     */
    public static boolean isOddIon(final String input) {
        String rgx = "(?i)" //case-insensitive for whole situation
                + "^" //if start of str required to be good
                + "([a-z]{2})+" //accept any EVEN combination of letters
                + "[a-z]" //hey look it's odd now
                + "(?<=ion)" //did we end in ion?
                + "$"; //end of string reached

//        String rgx = "^" //if start of str required to be good
//                + "([a-zA-Z]{2})+" //accept any EVEN combination of letters
//                + "[a-zA-Z]" //hey look it's odd now
//                + "(?<=ion)" //did we end in ion?
//                + "$"; //end of string reached

        return regexChecker(rgx, input);
    }
}