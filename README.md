# boredShellApp

## Übungsaufgabe Junior Backend Developer für Upstream Mobility

>Bitte erstelle eine Spring Shell Application, welche basierend auf der Bored API (https://www.boredapi.com/) einen Vorschlag für eine Aktivität ausgeben kann.

-[x] Erstelle einen BoredApiClient, um die Bored API abzufragen.
-[x] Optional: erstelle zusätzliche Filter Parameter, um z.B. nur Sport Aktivitäten
 abzufragen.
-[x] Optional: unterstütze Completion für den zusätzlichen Filter Parameter
-[ ] Optional: erstelle Unit Tests
-[ ] Optional: erstelle einen Spring Shell Test als Integration Test und überprüfe die Code
 Coverage
-[ ] Optional: erstelle eine OpenAPI Spezifikation bored.yaml und verwende den OpenAPI
 Generator, um den API-Client generieren zu lassen.
-[ ] Bitte übermittle uns den Quellcode deines Projekts am Vortrag zur zweiten Runde
 (gerne auch als Link auf ein Github Repository)


### create 
```
./mvnw clean install -DskipTests
```

### run
``` 
java -jar target/<artifactId>-<version>.jar 
```

### references
- [spring docs](https://docs.spring.io/spring-shell/docs/3.1.x/docs/)
- [Bored API](https://www.boredapi.com/)
- [Swagger Open API Specs](https://swagger.io/specification/)
- [Java Web Client](https://docs.spring.io/spring-framework/reference/web/webmvc-client.html#webmvc-webclient)

