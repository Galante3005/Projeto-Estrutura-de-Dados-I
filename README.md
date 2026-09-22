# Central de Atendimento

Sistema de central de atendimento via terminal, desenvolvido em Java para a disciplina de **Estruturas de Dados I** (Mackenzie). Simula um suporte técnico: o cliente registra uma solicitação, ela aguarda em uma fila e, em seguida, é atendida em ordem de chegada. Todas as operações realizadas ficam registradas em um histórico.

## Funcionalidades

O sistema é operado por um menu interativo no terminal, com as seguintes opções:

1. Cadastrar nova solicitação
2. Consultar próxima solicitação
3. Atender próxima solicitação
4. Exibir fila de solicitações
5. Exibir quantidade de solicitações aguardando
6. Consultar última operação
7. Exibir histórico de operações
8. Remover última operação do histórico
9. Gerar solicitações automáticas (para testes)
0. Encerrar

## Estruturas de dados

O projeto implementa as estruturas do zero, sem usar `java.util.Collections` (sem `Queue`, `Stack`, `LinkedList`, `ArrayList`, `Deque` etc.):

- **`Fila<T>`** — fila genérica circular, implementada sobre um vetor, usada para organizar as solicitações aguardando atendimento (ordem FIFO).
- **`Pilha<T>`** — pilha genérica, implementada sobre um vetor, usada para armazenar o histórico de operações realizadas (a última operação fica sempre no topo).

## Estrutura do projeto

```
src/
├── Main.java              # Ponto de entrada da aplicação
├── Menu.java               # Interface de terminal e interação com o usuário
├── CentralAtendimento.java # Regras de negócio: liga a Fila, a Pilha e as Solicitações
├── Fila.java                # Estrutura de dados: fila genérica circular
├── Pilha.java                # Estrutura de dados: pilha genérica
├── Solicitacoes.java        # Modelo de uma solicitação de atendimento
└── Operacao.java             # Modelo de uma operação registrada no histórico
```
