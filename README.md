# CircleIn Exercise - Social Crawler API

## How It Works
This is a Java Spring Boot API for the social media application which calculates the number of word matches on a specific web page

## Technology Stack
Here is a list of technologies, frameworks, and libraries used for delivering this API:
* **Programming Language**: Java (JDK 11)
* **Application Framework**: Spring Boot 2
* **Unit Testing Framework**: JUnit 5
* **Build Tool**: Gradle


## How To Build and Test The API
Run the following command to build the API and run unit tests:
```
./gradlew build
```

To launch unit tests only run the following command:
```
./gradlew cleanTest test
```

## How To Deploy the API Locally
To deploy the API locally run the following command:
```
./gradlew bootRun
```

To verify the API has been deployed successfully run the curl request below:
```
curl -v --location --request POST 'http://localhost:8080/webpage/words/count' \
--header 'Content-Type: application/json' \
--data-raw '{
    "url": "https://en.wikipedia.org/wiki/Back_to_the_Future",
    "word": "future"
}'
```

## Important Implementation Details

Here is a list of important considerations:
* **xUnit Test Patterns are adopted** for delivering high quality unit tests (http://xunitpatterns.com/). For example, there are multiple test classes for testing the same SUT (system under test) to separate the concerns and to make it easier to maintain unit tests. Another example is that each unit/integration test has three distinct phases clearly demarkated in each test: setup fixture, exercise system under test, and verify outcome. 


* **Clean code principles are used** for delivering both code and unit tests (https://www.amazon.com.au/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882). Both unit tests and code should be self-explanotory, therefore comments are not needed for explanations. Where necessary the test scenario has enough details through json/html file names and their content.


* **A True Test Driven Development was used** for developing code. Unit tests were added first followed by developing code. 


* **Handling HTTP error codes** - the support for returning useful 4xx and 5xx errors to clients have been implemented but is not 100% complete. But most common scenarios have been covered. Each error returned in the response has both internal code and description as per the industry standard RESTful practices.


* **'Best effort to clean HTML tags and punctuation' approach taken** for calculating words in the HTML payload. Specifically, the HTML code tags are stripped and punctuation is removed before calculating the number of words. No character encoding considerations are currently in place to minimise the amount of work needed as it has taken a long time already to get to this point. Similarly IFRAME tags are not supported for nested crawling. 


* **'Building on the shoulders of giants' approach** is adopted to avoid reinventing the wheel for solving common problems. For example, a robust Java HTML parser called Jsoup (https://jsoup.org/) is used to strip HTML tags while calculating word matches

