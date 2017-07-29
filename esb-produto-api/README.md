# esb-produto-api

projeto que simula um sistema de produtos de uma loja. Esse projeto usa a api da empresa B2W (Americanas, Submarino ...) para exibir produtos reais.

# projeto

O projeto foi feito utilizando a linguagem de programação scala (https://www.scala-lang.org/).
Para executar o projeto é preciso baixar o sbt (http://www.scala-sbt.org/) e configurá-lo na variável de ambiente de seu sistema operacional.

# executar o projeto

`sbt`

O modo interativo será iniciado. Dentro do modo interativo basta digitar `run`

# compilar para produção

No modo interativo (`sbt`), digite `dist`. Um arquivo será criado em target\universal\<project-name>.zip

https://www.playframework.com/documentation/2.6.x/Deploying

# executar o projeto compilado

extrair o arquivo zip gerado e executar o comando:

`path/to/bin/<project-name> -Dplay.http.secret.key=abcdefghijk`

https://www.playframework.com/documentation/2.6.x/HTTPServer
