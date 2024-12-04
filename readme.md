# ArteUni

trabalho de análise de sistemas

# Analise o cenário apresentado a seguir:

<ul>
    <li>1. Controle de Pedidos: a empresa recebe pedidos de uniformes para diferentes tipos de clientes
(escolas, empresas, clubes, etc.) e, muitas vezes, precisa personalizar os produtos com logos,
nomes e padrões específicos, realizar a arte finalização e se comunicar diretamente com o
cliente para aprovações.</li>
<li>2. Controle de Produção e Estoque: o controle rigoroso do processo de produção é essencial para
garantir a qualidade e o cumprimento dos prazos, promovendo a gestão de estoque de matérias-
primas e o acompanhamento da produção em tempo real.</li>
<li>3. Controle de Cotas e Tamanhos: os uniformes precisam ser produzidos de acordo com a
quantidade e os tamanhos solicitados, e atender às necessidades específicas de cada cliente ou
grupo de clientes</li>
<li>4. Controle de Qualidade: o registro de verificações de qualidade durante as diferentes etapas do
processo de produção, desde a inspeção dos tecidos até o produto final, é uma garantia para
que os uniformes atendam aos padrões exigidos.</li>
<li>5. Faturamento e Envio: após a produção, é feita a geração de notas fiscais e a organização do
envio dos uniformes para os clientes, viabilizado por plataformas de logística para otimizar o
processo de entrega e oforecer aos clientes um rastreamento eficaz de seus pedidos.</li>
<li>6. Atendimento ao Cliente e Pós-Venda: o acompanhamento do pós-venda é uma forma de
garantir que o cliente esteja satisfeito com o produto recebido, oferecendo a possibilidade de
trocas e devoluções, bem como o registro de feedbacks sobre os uniformes e os serviços
prestados.</li>
<li>7. Relatórios e Análise de Dados: a coleta de dados sobre vendas, produção e satisfação do cliente
é essencial para a tomada de decisões estratégicas. Isso envolve a análise do desempenho da
empresa, a identificação de gargalos na produção e de áreas que necessitam de melhorias, a
estimativa de demandas, dentre outros fatores importantes.</li>
</ul>

# Funcionalidades adicionais:

<ul>
<li>Controle de estoque: Classe Estoque adicionada para gerenciar matérias-primas.</li>
<li>Histórico de status: Cada alteração de status é registrada com um timestamp.</li>
<li>Validação de pedidos: Produtos com quantidade inválida não podem ser adicionados.</li>
<li>Gestão de prazos de entrega: Cada pedido agora possui um prazo de entrega.</li>
<li>Resumo financeiro: O valor total dos pedidos é calculado e exibido.</li>
</ul>

# Relações entre as Classes

### Relações e Tipos

1. **`Pedido` → `Cliente`**
    - **Tipo:** Agregação
    - **Descrição:** A classe `Pedido` tem uma referência para um `Cliente`, indicando que um cliente pode estar associado a um ou mais pedidos. A vida do cliente não depende do pedido, ou seja, mesmo que o pedido seja removido, o cliente pode continuar existindo.

2. **`Pedido` → `Produto`**
    - **Tipo:** Composição
    - **Descrição:** A classe `Pedido` contém uma lista de `Produto`. O ciclo de vida dos produtos está completamente vinculado ao pedido. Se o pedido for excluído, os produtos associados também deixam de existir.

3. **`Pedido` → `StatusPedido`**
    - **Tipo:** Associação via Enum
    - **Descrição:** `Pedido` utiliza o enum `StatusPedido` para representar o estado atual. Este é um relacionamento fraco, pois `Pedido` apenas referencia os valores do enum sem possuir diretamente suas instâncias.

4. **`Pedido` → `Estoque`**
    - **Tipo:** Associação indireta
    - **Descrição:** Embora `Pedido` não interaja diretamente com `Estoque`, ele depende dele para verificar e consumir materiais indiretamente, como parte do fluxo lógico do sistema.

5. **`Estoque` → `Material` (Representado como `String` no código)**
    - **Tipo:** Agregação
    - **Descrição:** A classe `Estoque` gerencia materiais como strings associadas a quantidades. A vida útil do material (neste caso, representado por uma entrada no `Map`) depende da implementação do estoque.

6. **`RelatorioPedidos` → `Pedido`**
    - **Tipo:** Composição
    - **Descrição:** A classe `RelatorioPedidos` mantém uma lista de pedidos para gerar relatórios. A existência de `RelatorioPedidos` depende da existência dos pedidos que ele gerencia.

7. **`RelatorioPedidos` → `Relatorio`**
    - **Tipo:** Implementação de Interface
    - **Descrição:** `RelatorioPedidos` implementa a interface `Relatorio`, garantindo que ela pode ser tratada de forma polimórfica como uma classe que gera relatórios.

8. **`Main` → Várias Classes**
    - **Tipo:** Dependência
    - **Descrição:** A classe principal (`Main`) instancia e coordena várias classes (`Estoque`, `Cliente`, `Pedido`, `RelatorioPedidos`). Essas interações indicam que a classe principal depende diretamente dessas classes para executar o fluxo lógico.

### Multiplicidades

- **`Cliente` → `Pedido`**: Um cliente pode estar associado a **vários pedidos** (1:N).
- **`Pedido` → `Produto`**: Um pedido contém **múltiplos produtos** (1:N).
- **`Estoque` → `Material`**: O estoque contém **vários tipos de materiais**, e cada material tem uma quantidade associada (1:N).
- **`RelatorioPedidos` → `Pedido`**: Um relatório contém **vários pedidos** (1:N).
