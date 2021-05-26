# Desafio Compasso UOL | Java Developer

## Microsserviço de catálogo de produtos utilizando Java, Spring Boot e MongoDB 
Requisitos do projeto disponíveis [aqui](https://bitbucket.org/RecrutamentoDesafios/desafio-java-springboot/src/master/). 

### Executar o Projeto

#### Inicializar o banco de dados
Na pasta `bin` do MongoDB, executar o comando:

```
mkdir data && mongod --dbpath data
```

#### Construir e executar o projeto
Na pasta do projeto, executar o comando:
```
gradlew build
```

Em seguida, executar o comando:
```
java -jar build/libs/ProductsCatalog-0.0.1-SNAPSHOT.jar br.com.compasso.desafio.productscatalog.ProductsCatalogApplication 
```

### Realizar operações no catálogo de produtos

Executar, via URL abaixo, as operações conforme endpoints e instruções nos [requisitos do projeto](https://bitbucket.org/RecrutamentoDesafios/desafio-java-springboot/src/master/).

```
http://localhost:9999
```

### Tecnologias utilizadas
[JDK 8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
<br>[Spring Boot 2.5.0](https://spring.io/projects/spring-boot)
<br>[MongoDB 4.4.6](https://www.mongodb.com/try/download/community)
<br>[Gradle 7.0.2](https://gradle.org/releases/)
<br>[Intellij IDEA 2021.1.1](https://www.jetbrains.com/pt-br/idea/download) 
