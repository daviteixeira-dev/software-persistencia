<div>
  <h1>Desenvolvimento de Software para Persistência</h1>
  <p>Listas de exercicios e trabalhos práticos da disciplina de desenvolvimento de software para persistência - 2022.2</p>
  
  <div>
    <h2>Lista de exercicios 01</h2>
    <h3>Questão 1</h3>
    <p>
      Crie uma aplicação Java para receber via entrada de teclado um caminho ou nome de arquivo texto e dois números inteiros (n1 e n2).
    </p>
    <p>
      A aplicação deve exibir as linhas do arquivo entre n1 e n2, incluindo as linhas n1 e n2. Se n1 não for definido, deve-se exibir as linhas do arquivo a partir da primeira linha até n2. Se n2 não for definido, deve-se exibir as linhas do arquivo a partir de n1 até o final do arquivo.
    </p>
    <h3>Questão 2</h3>
    <p>
      Escreva uma aplicação para ler um arquivo texto ou binário qualquer e gravá-lo em outro arquivo (arquivo destino).
    </p>
    <p>
      Os nomes dos arquivos (origem e destino) devem ser definidos via argumentos de linha de comando (Dica: usar o String args[] do método main).
    </p>
  </div>
  
  <div>
    <h2>Lista de exercicios 02</h2>
    <h3>Questão 1</h3>
    <p>
    Crie uma aplicação Java para receber via argumento de linha de comando um nome de arquivo texto e uma string S. 
    A aplicação deve exibir todas as linhas que tenham S como substring, independente dos caracteres estarem em caixa alta ou baixa (case-insensitive).
    </p>
    <h3>Questão 2</h3>
    <p>
    Escreva uma aplicação Java para receber via argumentos de linha de comando três nomes de arquivos. 
    Deve-se gerar um novo arquivo a partir da concatenação dos dois primeiros arquivos. 
    O nome do novo arquivo gerado é o último dos três nomes de arquivos recebidos como entrada.
    </p>
    <h3>Questão 3</h3>
    <p>
    Escolha e baixe um arquivo csv de no mínimo 1 MB, a partir da plataforma 
    Kaggle (<a href="https://www.kaggle.com/datasets" target="_blank">https://www.kaggle.com/datasets</a>) e use-o nas questões a seguir. 
    Na resolução desta questão, não enviar os arquivos envolvidos, mas somente os resultados pedidos em arquivo PDF. 
    Envie somente o link do arquivo escolhido.
    </p>
    <ul>
      <li>
      Gere as somas checksum, md5 e sha1 do arquivo usando utilitários de linha de comando do próprio sistema operacional ou instalado nele. 
      Compacte via linha de comando o arquivo csv original usando compressões zip, gzip e rar. Depois disso compare os tempos e tamanhos dos arquivos gerados. 
      Dica: para obter o tempo de execução, use o comando time.
      </li>
      <ul>
        <li>Exemplo: time zip iris.zip iris.csv</li>
      </ul>
    </ul>
    <h3>Questão 4</h3>
    <p>
    Escreva um arquivo de propriedades Java via editor de textos. Esse arquivo deve ter os dados de chave e valor. Exemplo:
    <p>
    <ul>
      <li>arquivo config.properties</li>
      <ul>
        <li>arquivo = meu_arquivo.txt</li>
        <li>linha_inicial = 1</li>
        <li>linha_final = 3</li>
      </ul>
      <li>Depois, escreva uma classe Java que exibe da linha_inicial até a linha_final do arquivo, 
      conforme definidos no arquivo de propriedades config.properties.</li>
    </ul>
    <p>
    OBS: Enviar as resoluções das questões compactadas em um arquivo em formato zip.
    </p>
  </div>
  
  <div>
    <h2>Lista de exercicios 03</h2>
    <h3>Passo 1</h3>
    <p>
    Crie uma classe Java de entidade. Exemplo: Filme (id, titulo, sinopse, diretor). A classe deve implementar a interface java.io.Serializable.
    </p>
    <h3>Passo 2</h3>
    <p>
    Crie uma classe Java de nome Serializa para instanciar objetos da classe definida no passo 1 e adicionar esses objetos em uma Lista. Depois percorrer a lista e Serializar os objetos em disco/ssd. Serialize usando a Serialização de objetos da própria API Java (<a href="https://www.baeldung.com/java-serialization">Introduction to Java Serialization | Baeldung</a>).
    </p>
    <h3>Passo 3</h3>
    <p>
    Crie uma classe java de nome Desserializa para ler / desserializar os objetos Serializados do passo 2 e exibi-los. 
    </p>
  </div>
  
  <div>
    <h2>Lista de exercicios 04</h2>
    <h3>Questão 1</h3>
    <p>
    Crie uma classe Java de entidade. Exemplo: Filme (id, titulo, sinopse, diretor).
        <ul>
            <li>
                OBS: A classe não precisa implementar a interface java.io.Serializable.
            </li>
        </ul>
    </p>
    <h3>Questão 2</h3>
    <p>
    Crie uma classe Java de nome Serializa para instanciar objetos da classe definida na Questão 1 e adicionar esses objetos em uma Lista. Depois, percorrer a lista e Serializar os objetos em disco/ssd. Serialize usando XML através da biblioteca Jackson (<a href="https://www.baeldung.com/jackson-xml-serialization-and-deserialization">XML Serialization and Deserialization with Jackson | Baeldung</a>).
    </p>
    <h3>Questão 3</h3>
    <p>
    Crie uma classe java de nome Desserializa para ler / desserializar os objetos Serializados na Questão 2 e exibi-los também através do uso da bilbioteca Jackson (<a href="https://www.baeldung.com/jackson-xml-serialization-and-deserialization">XML Serialization and Deserialization with Jackson | Baeldung</a>). 
    </p>
  </div>
  
  <div>
    <h2>Lista de exercicios 05</h2>
    <h3>Questão 1</h3>
    <p>
    Crie uma classe Java de entidade. Exemplo: Filme (id, titulo, sinopse, diretor).
        <ul>
            <li>
                OBS: A classe não precisa implementar a interface java.io.Serializable.
            </li>
        </ul>
    </p>
    <h3>Questão 2</h3>
    <p>
    Crie uma classe Java de nome Serializa para instanciar objetos da classe definida na Questão 1 e adicionar esses objetos em uma Lista. Depois, percorrer a lista e Serializar os objetos em disco/ssd. Serialize usando JSON através da biblioteca Jackson <a href="https://blog.codeminer42.com/serialization-and-deserialization-in-java-using-jackson/">(Serialization and Deserialization in Java using Jackson A practical guide on how to serialize and deserialize objects to JSON in Java using Jackson)</a>.
    </p>
    <h3>Questão 3</h3>
    <p>
    Crie uma classe java de nome Desserializa para ler / desserializar os objetos Serializados na Questão 2 e exibi-los também através do uso da bilbioteca Jackson <a href="https://blog.codeminer42.com/serialization-and-deserialization-in-java-using-jackson/">(Serialization and Deserialization in Java using Jackson A practical guide on how to serialize and deserialize objects to JSON in Java using Jackson)</a>.
    </p>
  </div>
  
  <div>
    <h2>Trabalho Prático 1</h2>
  </div>
  
</div>
