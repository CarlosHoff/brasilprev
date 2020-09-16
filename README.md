<h1> BrasilPrev - Desafio Java </h1>
API de Loja virtual 

<h1>Ferramentas de apoio</h1>
<ul>
  <li>Postman</li>
  <li>IntelliJ IDEA - Community</li>
  <li>JDK 1.8 ou superior</li>
  <li>Git</li>
  <li>Gradle</li>
  <li>Postgresql</li>
</ul>

<h1>Pré Requisito</h1>
<ol>
  <li>Para realizar chamadas rest nas API’s, é necessário a utilização de um token.</li>
  <li>Fazer o cadastro pelo end-point http://localhost:8090/v1/brasilprev/cadastracliente</li>
  <li>Para obter o token, será necessário realizar uma chamada POST no end-point http://localhost:8090/v1/brasilprev/login, <br>
  enviando um JSON no formato abaixo (cadastrado no passo acima): { “username”:“seu_email”, “password”: “sua_senha” }</li>  
</ol>

<h1>Projeto</h1>
Projeto foi baseado na modelagem abaixo:
<img src="https://user-images.githubusercontent.com/52975130/93294407-cc349100-f7c0-11ea-853d-9cd4abc7f1d5.JPG">

<h3>Foi criado os end-points abaixo para atender a loja virtual</h3>
<ul>
  <li><b>POST</b> - /v1/brasilprev/cadastraproduto</li>
  <li><b>DELETE</b> - /v1/brasilprev/deletaproduto/{id}</li>
  <li><b>GET</b> - /v1/brasilprev/buscaprodutos</li>
  <li><b>GET</b> - /v1/brasilprev/buscaprodutopeloid?id=1</li>
  <li><b>PUT</b> - /v1/brasilprev/updateproduto/{id}</li>
  <li><b>POST</b> - /v1/brasilprev/cadastracliente</li>
  <li><b>DELETE</b> - /v1/brasilprev/deletacliente/{id}</li>
  <li><b>GET</b> - /v1/brasilprev/buscaclientes</li>
  <li><b>GET</b> - /v1/brasilprev/buscaclientepeloid?id=1</li>
  <li><b>POST</b> - /v1/brasilprev/cadastracategoria</li>
  <li><b>POST</b> - /v1/brasilprev/cadastrapedido</li>
  <li><b>DELETE</b> - /v1/brasilprev/deletapedido/{id}</li>
  <li><b>GET</b> - /v1/brasilprev/buscapedidos</li>
  <li><b>GET</b> - /v1/brasilprev/buscapedidopeloid?id=1</li>
  <li><b>POST</b> - /v1/brasilprev/login</li>
</ul>

<h3>Observação</h3>
<ul>
  <li>Adicionar o Authorization no Header das requisições. (Authorization: BrasilPrev XXXX)</li>
</ul>  

<h3>Conclusão</h3>
Já tinha uma parte desse projeto desenvolvido por já ter feito um teste anteriormente na Brasilprev, porem ele estava bem simples e não atendia todos os requesitos. Busquei conhecimento e nesta outra oportunidade venho mostrar o trabalho que foi desenvolvido com o conhecimento adquirido para cumprir todos os requesitos solicitados.
