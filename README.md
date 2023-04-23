# RegexStuff
Experimentation with regex for different kinds of tasks, including some tasks which in a practical sense would be dangerous such as password and date verification. Unit tests provided.

## Execution
* The Main Class holds all functionality in public methods which take a string to check. All methods return booleans for if the string was valid and well-formed under the guidances within the javadoc for each method.
* Each method runs against the entire string using ^ and $ operators on each end. The private verification method called also uses the Matcher.matches() function which binds to the whole line naturally.
* Main.main() holds no functionality, and is simply set up for printing desired regex strings, so they can be seen as a whole instead of piecemeal.
* Each method has its own unit test class, which holds at least five True and five False tests. Most of these unit tests do not print proper errors when they fail as there's no state or interesting information to pass to the user that would be enlightening.
* Each method has its regex built on multiple lines so that each piece of the regex can be seen alone, and comments are provided to note what each piece of the regex is doing.

## Known Weaknesses
* Date checking does not complete its task completely in regex, there is helper code to validate leap years and if the day given is valid in months with less than 31 days.
* Some of these are definitely not very efficient.