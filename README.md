**Undergrad thesis**
**Topic**: Developing a method for sentiment analysis from the document of two languages(Engligh and bangla)
**Project Overview**
This Java-based application is designed to perform sentiment analysis on documents written in both English and Bangla. It utilizes custom-built lexicons for each language to assess the sentiment conveyed in the text. The application interfaces allow users to input text, which is then processed to determine its sentiment polarity. The results are stored in an Oracle database for further reference or analysis.

**Key Functional Components**
1) Interface Design: Interface.java, EnglishInterface.java, and BanglaInterface.java likely manage user interactions for sentiment analysis in respective languages.

2) Database Operations: ConnectDB.java, InsertIntoDatabase.java, and OracleConnectionFactory.java handle database connections and data insertion tasks.

3) Lexicon Management: get_lexicon.java is responsible for retrieving and managing sentiment lexicons, crucial for analysis.

4) Testing Modules: ConTest.java, Tester.java, and roughTest.java are presumably used for testing various components of the application
