# demoSeleniumJava
Demo proyecto Selenium y Cucumber

-JDK 1.8
-Maven 3.6.1

Ejecutar Tests:

mvn test -Dcucumber.options="src/test/java/resources/features/ebayfilter.feature"

mvn test -Dcucumber.options="--tags @ebayall"

Visualizar reporte en carpeta output en la raíz del proyecto.
