# Harbor & Pine – Spring Boot website

Requires Java 17+ and Maven 3.9+.

    mvn spring-boot:run

Open http://localhost:8080

- Text and layout:   src/main/resources/templates/index.html
- Styling:           src/main/resources/static/css/site.css
- Services list:     SiteController.java (SERVICES)
- Form handling:     SiteController.contact() – replace the log line with email or database code

Build a runnable jar:  mvn clean package  ->  java -jar target/site-1.0.0.jar
