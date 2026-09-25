# PaymentHub 💳

Projeto acadêmico em Java para praticar **Design Patterns** do GoF aplicados em um contexto real de processamento de pagamentos.

## Sobre o projeto

PaymentHub simula um hub de pagamentos que suporta múltiplos métodos (Pix, Cartão de Crédito e Boleto), aplica descontos configuráveis e notifica o usuário após cada transação — tudo isso usando patterns clássicos de forma integrada, sem exemplos artificiais.

## Patterns implementados

| Pattern | Aplicação no projeto |
|---|---|
| **Strategy** | Troca o método de pagamento em tempo de execução sem `if/else` |
| **Facade** | Expõe uma interface simples que orquestra todos os subsistemas |
| **Observer** | Notifica os canais (e-mail, SMS) após cada pagamento sem acoplamento |
| **Decorator** | Empilha descontos (VIP, cupom) dinamicamente sobre o valor base |
| **Singleton** | Logger único compartilhado por toda a aplicação |

## Estrutura

```
src/
├── facade/        # PaymentFacade — ponto de entrada
├── strategy/      # PixPayment, CreditCardPayment, BoletoPayment
├── observer/      # EmailNotifier, SmsNotifier
├── decorator/     # VipDiscount, CouponDiscount
├── logger/        # PaymentLogger (Singleton)
└── Main.java      # Cenários de demonstração
```

## Como rodar

Requer Java 11+. Sem dependências externas.

```bash
# Compilar
javac -d out -sourcepath src src/Main.java

# Executar
java -cp out Main
```

## Objetivo

Exercício prático de Engenharia de Software — FIAP. O foco não é o domínio de pagamentos em si, mas demonstrar como patterns resolvem problemas reais de design: extensibilidade, baixo acoplamento e responsabilidade única.