# Sistema de Atendimento de Clínica Veterinária

Uma clínica veterinária deseja um sistema simples para registrar atendimentos de animais. Cada atendimento possui tutor, animal, serviço solicitado, valor base e situação atual.

O sistema deve ser flexível para permitir novas regras e comportamentos sem grandes alterações no código existente.

---

## Diagrama de Classes

<img width="1741" height="1028" alt="prova1 drawio" src="https://github.com/user-attachments/assets/ce687022-ed85-4b73-aa4b-e9103e5a1abb" />

### Classes mínimas esperadas

- Atendimento
- Animal
- Tutor
- ServicoVeterinario

Outras classes podem ser criadas conforme a solução proposta.

---

## Código-Fonte

Implemente em Java os seguintes comportamentos:

### a) Situação do Atendimento

O atendimento pode estar em uma das seguintes situações:

- Agendado
- EmAtendimento
- Finalizado
- Cancelado

Cada situação deve controlar quais mudanças são permitidas.

#### Exemplos

- Um atendimento **Agendado** pode ir para **EmAtendimento** ou **Cancelado**;
- Um atendimento **EmAtendimento** pode ir para **Finalizado**;
- Um atendimento **Finalizado** não pode ser cancelado.

Evite concentrar toda a lógica em vários `if` ou `switch` dentro da classe `Atendimento`.

---

### b) Avisos Automáticos

Sempre que a situação do atendimento mudar, algumas partes devem ser avisadas automaticamente.

#### Exemplos

- O tutor deve ser avisado quando o atendimento for iniciado;
- O veterinário deve ser avisado quando um atendimento for cancelado;
- A recepção deve ser avisada quando o atendimento for finalizado.

A solução deve permitir adicionar novos interessados sem modificar diretamente a classe `Atendimento`.

---

### c) Acréscimos e Descontos

O valor final do atendimento pode sofrer alterações por regras opcionais:

- Desconto para animal adotado;
- Taxa de atendimento domiciliar;
- Serviço de banho pós-consulta.

Essas regras podem ser combinadas em um mesmo atendimento.

---

## Casos de Teste

Crie os casos de teste demonstrando:

1. Mudança válida de situação;
2. Tentativa de mudança inválida;
3. Envio automático de aviso;
4. Cálculo do valor final com mais de uma regra aplicada.
