# social-media-crawler-api
A social media crawler API for determining how many time influencers are mentioned

TODO: 
Document that due to time constraints error codes and messages for 4xx and 5xx responses are not included in responses

Limitations
- No attempt is made to cover all languages and character sets, everything is simplified to standard character sets and string matching
- No HTML cleaning is done (removal of tags)
- HTML tag removal is very simplistic
- Jsoup - java HTML parser https://jsoup.org/
- case insensitive
- not crawling iframes