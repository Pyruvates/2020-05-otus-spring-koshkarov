# Console application for testing students (only questions output)

#### Goal:
build an application using Spring IoC to get familiar with the core IoC functionality that all of Spring is built on

#### Result:
simple application configured with an XML-context

### Start instruction:

1. Compile sources and build jar from project root directory `mvn clean package`
2. Execute `java -jar spring-course-1.1.0-jar-with-dependencies.jar`

### Task description:

The resources store questions and various answers to them in a CSV file (5 questions).
Questions can be with a choice of several options or with a free answer - at your desire and discretion.
The application should output the test questions from the CSV file with possible answers

### Requirements:
1. The application must have an object model
2. The context is described by an XML file 
3. All dependencies must be configured in the IoC container 
4. The name of the resource with questions (CSV file) must be hardcoded as a line in the XML file with the context
5. CSV with questions is read exactly as a resource, not as a file