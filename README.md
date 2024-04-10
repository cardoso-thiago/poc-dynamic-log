# Mudança do log em tempo de execução

## Mudança do level do log com o Actuator

Basta executar o seguinte comando informando o level desejado: `curl -X POST -H 'Content-Type: application/json' -d '{"configuredLevel": "WARN"}' http://localhost:8080/actuator/loggers/ROOT`

## Mudança do level do log com o LoggingSystem

Injetando o `LoggingSystem`, basta realizar a seguinte chamada:

```java
loggingSystem.setLogLevel("ROOT", LogLevel.valueOf(level));
```

Para testar nessa POC, basta executar o seguinte comando informando o level desejado: `curl localhost:8080/log/WARN`

### Idéias para implementação

- Disponibilizar um facilitador ou documentar o mecanismo para criação de um listener do Hazelcast a nível de aplicação, permitindo a mudança do level de acordo com o recebimento de determinada chave
  - Nesse ponto, poderiam ser adicionadas também informações no MDC
- Possível facilitador para  consulta de métricas de counter de erros para disparar a mudança no level