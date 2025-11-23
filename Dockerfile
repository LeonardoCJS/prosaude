# Imagem oficial do Maven com Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos de configuração do Maven
COPY pom.xml .

# Baixa dependências (isso evita baixar tudo a cada build)
RUN mvn -q dependency:go-offline

# Copia o código fonte
COPY src ./src

# Executa o build — gera o JAR em /app/target
RUN mvn -q clean package -DskipTests

# ---- Runtime ----
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia o JAR gerado para a imagem final
COPY --from=build /app/target/*.jar app.jar

# Força o Spring rodar com o application-local.yml
ENV SPRING_PROFILES_ACTIVE=local

EXPOSE 8080

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
