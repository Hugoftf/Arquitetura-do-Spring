# Arquitetura Spring

![imagem local](imagem_readme/springboner.png)


Entendendo e configurando Arquiterura do Spring

- [Classe Application](#Classe-Application)
- [Configuration e Bean](#Configuration-e-Bean)
- [Padrão MVC](#Padrão-MVC)
- [Injeção de Dependência](#Injeção-de-Dependência)
- [Arquivos de configuração externalizada application properties](#Configuração-Application-properties)


## Classe Application

"A classe application é responsável por configurar e iniciar a aplicação. Ela contém o método run(), que lança a aplicação e configura os componentes do Spring."

A estrutura básica de uma aplicação Spring Boot geralmente inclui uma classe principal (com a anotação @SpringBootApplication) que chama o método run() da classe SpringApplication 
para iniciar a aplicação.

### Anotação @SpringBootApplication

"É uma combinação de anotações  que ajudam a configurar e inicializar um aplicativo Spring Boot de forma simplificada. Existem 3 principais anotações:"

@Configuration: Indica que a classe pode ser usada como uma fonte de definições de beans no contexto da aplicação.

@EnableAutoConfiguration: Diz ao Spring Boot para começar a configurar automaticamente os beans necessários com base nas dependências presentes no classpath. Isso ajuda a reduzir a 
quantidade de configuração manual que você teria que fazer, pois o Spring Boot configura muitos aspectos de sua aplicação automaticamente, como fontes de dados, web servers, segurança, 
entre outros.

@ComponentScan: Permite que o Spring procure por componentes, configurações e serviços em pacotes específicos. Por padrão, ela faz com que o Spring Boot procure por componentes em pacotes 
dentro do mesmo pacote da classe onde a anotação @SpringBootApplication está.

![imagem local](imagem_readme/Classe_application/anotacaoSpringbootaplication.png)

### Spring Application Builder

"A classe SpringApplicationBuilder é uma ferramenta fornecida pelo Spring Boot para ajudar a construir e configurar uma aplicação Spring Boot de maneira mais flexível, especialmente quando você precisa personalizar ou modificar as configurações de inicialização do aplicativo."

"Ela é uma alternativa ao uso direto do método estático SpringApplication.run() quando você deseja ter um controle maior sobre o processo de inicialização do aplicativo."

![imagem local](/imagem_readme/Classe_application/classeSpringapplicationbuilder.png)

Comentei o SpringApplication para rodar manualmente com o SpringApplciationBuilder e fazer configuração adicionais:

![imagem local](/imagem_readme/Classe_application/buildermetodos.png)

Existem diversas configurações, remover o banner Mode, configurar contexto da applicação, rodar aplicação apontando para perfils, configurações com environment, etc.

![imagem local](/imagem_readme/Classe_application/configuracaocompleta.png)

### @Configuration e Bean

A anotação @Configuration no Spring Framework é usada para indicar que uma classe contém configurações de beans. Em outras palavras, ela define uma classe como uma fonte de definições de beans que o Spring irá usar para configurar o contexto da aplicação.

Quando você anota uma classe com @Configuration, ela funciona de maneira similar a um arquivo de configuração XML no Spring, mas de forma mais moderna e orientada a código Java. Essa anotação é utilizada para registrar beans que podem ser usados em toda a aplicação.

![imagem local](imagem_readme/Configuration_Bean/config.png)

 #### Bean

 é usada para definir um método que cria um bean que será gerido pelo Spring IoC container. Basicamente, ela permite que você registre objetos dentro do contexto do Spring de forma programática, em vez de utilizar arquivos de configuração XML.

básicamente uma forma de você criar objetos e passar como injeção de dependencia sem que seja passada por um cronstrutor ou uma instanciação de objeto:

![imagem local](imagem_readme/Configuration_Bean/bean.png)

Na prática, na sua classe Controller, quando você definir uma variavel da classe para se realizar a injação de dependência, você utilizar o @Autowired (Quando você usa @Autowired, o Spring cuida de injetar o objeto necessário, sem que você precise criá-lo manualmente. Ela é usada para realizar injeção de dependência.).

![imagem local](imagem_readme/Configuration_Bean/injecao.png)

#### E se tiver mais de um Bean ?

 Você pode definir multiplos beans no seu programa, dependendo da lógica do seu programa não utilizamos uma instancia de objeto da mesma classe, e sim multiplas. Mas como diferenciar uma da outra ? Existe algumas formas, mas primeiro caso você não diferencie, em tempo de execução retornarar um error dizendo que há multiplas beans mais a jvm não sabe qual injetar, nesse caso existe uma anotação chamada @Qualifier, ela é usada para especificar qual beans você quer utilizar, com o parametro determinado pelo nome do metodo.

Defenindo mais beans:

![imagem local](imagem_readme/Configuration_Bean/beanmotoraspirado.png) 

![imagem local](imagem_readme/Configuration_Bean/beanmotorturbo.png) 

![imagem local](imagem_readme/Configuration_Bean/beanMotorEletrico.png) 

Qualifier na prática: 

![imagem local](imagem_readme/Configuration_Bean/qualifier.png)

Retorno: 

![imagem local](imagem_readme/Configuration_Bean/postmaneletrico.png)

Você pode denifir um metodo como padrão caso esqueça de definir no seu controller qual é o qualifier, através da anotação @Primary: 

![imagem local](imagem_readme/Configuration_Bean/primary.png) 

Existe outra forma de usar o @Qualifier, através de anotação personalizada. Elas são exemplos de bom uso, e deixão o código mais limpo:

![imagem local](imagem_readme/Configuration_Bean/anotacaoAspirado.png)

"A anotação @Retention no Java é usada para indicar em qual fase do ciclo de vida da anotação ela estará disponível. Quando você aplica @Retention em uma anotação personalizada, você está especificando o nível de visibilidade dessa anotação, ou seja, onde e por quanto tempo ela será acessível". No caso em RunTime: " RetentionPolicy.RUNTIME: A anotação será retida no bytecode e estará acessível em tempo de execução. Isso significa que você pode acessá-la programaticamente durante a execução do programa, geralmente por meio de reflexão. Isso é essencial para anotações usadas em frameworks como o Spring, que podem ler e processar anotações durante a execução."

"A anotação @Target é usada em anotações personalizadas para especificar onde a anotação pode ser aplicada. Ou seja, ela define os alvos possíveis de uma anotação (por exemplo, métodos, classes, campos, parâmetros, etc.). Quando você cria uma anotação personalizada, o @Target ajuda a garantir que a anotação só possa ser usada nos locais apropriados." 

Em uso: 

![imagem local](imagem_readme/Configuration_Bean/metodocomanotacao.png)

Retorno: 

![imagem local](imagem_readme/Configuration_Bean/resultadoanotacao.png)


### Padrão MVC

"No Spring Framework, o padrão MVC (Model-View-Controller) é amplamente utilizado para desenvolver aplicações web. O Spring promove uma clara separação de responsabilidades entre diferentes camadas da aplicação, o que facilita o desenvolvimento e a manutenção. As camadas Controller, Service e Repository (ou DAO) são partes essenciais dessa arquitetura." 

"A camada de Controller é responsável por gerenciar as requisições HTTP e orientar a execução do fluxo da aplicação. O Controller recebe as entradas do usuário (geralmente via requisições HTTP), processa essas entradas com base na lógica de controle e, em seguida, retorna a resposta adequada, que pode ser uma View ou algum tipo de dados em formato JSON ou XML." (Geralmente usamos o [Postman](https://www.postman.com/) para realizar esses testes).

"A camada de Service contém a lógica de negócios da aplicação. Ela é responsável por processar dados, executar regras de negócio, interagir com os repositórios (camada de acesso a dados), e fornecer a funcionalidade necessária para o Controller. O Service atua como uma abstração entre o Controller e o Repository."

A camada de Repository é responsável pelo acesso aos dados. Ela fornece os métodos para acessar e manipular os dados persistidos, como fazer consultas ao banco de dados. No Spring, a camada Repository pode ser implementada facilmente utilizando o Spring Data JPA ou outras tecnologias de persistência, como JDBC, MongoDB, etc.

#### @Component

"É um dos principais conceitos para trabalhar com a Injeção de Dependência (DI) e a Inversão de Controle (IoC). Ele refere-se a um objeto que é gerido pelo Spring Container, ou seja, é um bean que pode ser criado, configurado e mantido pelo Spring. 

Quando uma classe é anotada com uma dessas anotações (@Component, @Service, @Repository, @Controller), o Spring automaticamente registra essa classe como um bean no ApplicationContext do Spring. Esses beans podem ser injetados em outras partes da aplicação utilizando a injeção de dependência.

Ele é pai de outras anotações, então é uma anotação genérica, embora possa ser usados no lugar de @Service (Na lógica da aplicação), @Repository (No acesso a dados da aplicação), @Controller (Na parte web da aplicação), não se é recomendado por questões semânticas e clareza de código.

#### Quando usar um component ?

Você pode usar o component quando há alguma classe que tem alguma logica ou funcionamento separados do padrão (Quando você tiver componentes mais genéricos e que não se encaixem em categorias específicas como @Service, @Repository ou @Controller.), Dessa forma essa classe será gerenciado pelo spring sendo usada como ferramenta para injeção de dependência.

### Injeção de Dependência

No Spring a injeção de dependência é um padrão de design que visa desacoplar as classes da aplicação, permitindo que elas não precisem criar ou gerenciar suas próprias dependências (ou seja, objetos de que precisam para funcionar). Em vez disso, essas dependências são "injeçadas" (fornecidas) pelo Spring Framework.

Ao invés de instanciar diretamente objetos dentro de uma classe, o Spring se encarrega de criar e injetar as dependências para você.

Vamos a um exemplo em que você precisaria fazer as instancias e também injeta-lás de maneira manual:

![imagem local](/imagem_readme/injecao_dependencia/injecaodedependenciamanual.png)

O spring consegue gerenciar melhor que nós a parte de injeção de dependência.

#### Três formas de fazer a injeção

A primeira injeção é através de construtor, onde o @Autowired não é obrigatório, e também é a forma mais recomendada de ser feito, pois ela diz ao spring que para instanciar tal classe dependende da outra classe, e também por questão de semantica.

A segunda injeção é através do metodo set, você pode receber um objeto por via set, dessa forma você pode implementar alguma lógica no sistema, seja no proprio metodo, ou em outros campos da classe. É obrigatório imformar o @Autowired.

a terceira injeção é através do @Autowired na própria variavel, e a forma menos recomendavel, ela não detona obrigátoriedade e também você não consegue fazer nenhuma lógica como no construtor ou via set

![imagem local](/imagem_readme/injecao_dependencia/tresformasdeinjetar.png)

### Configuração Application properties


Em um projeto Spring, a configuração externalizada é uma prática fundamental que permite separar as configurações da aplicação do código-fonte. Isso oferece maior flexibilidade e facilita a manutenção, especialmente em ambientes de produção, onde diferentes configurações podem ser necessárias para diferentes ambientes (desenvolvimento, teste, produção, etc.).

No Spring, a maneira mais comum de lidar com a configuração externalizada é por meio do arquivo application.properties ou application.yml, que são usados para armazenar valores de configuração e parâmetros para a aplicação.

Primeira coisa  que precisamos entender sobre, as configurações no properties são pertinentes a sua dependência no arquivo xml, exemplo, só vai ser possivel e fazer sentido de configurar um Jpa, se no seu projeto, no seu arquivo xml, tiver uma dependencia para jpa.

Você pode encontrar as propriedades de configuração para cada respectivas dependencias no site do [spring docs io](https://docs.spring.io/spring-boot/appendix/application-properties/index.html).

Você consegue também recuperar essas propriedades no seu programa, para aplicar no contexto ou classe que tem anotação de Configuration para personolizar seus beans:

Primeiro eu troquei meu arquivo properties pelo yamal, assim o código fica mais legivel:

![imagem local](/imagem_readme/appPropeties_configuration/yamal.png)

Depois Foi criado uma classe com a anotação generica @Component para servi como exemplo de recuperação de valor, ela tem uma variavel que armazena o valor com a anotação @Value com as propiedades do yamal ou propities, e um metodo que retornar o valor:

![imagem local](/imagem_readme/appPropeties_configuration/classevalue.png)

Na classe com a anotação application do spring, utilizamos o application contexto para recuperar esse valor e chamar o metodo da classe: 

![imagem local](/imagem_readme/appPropeties_configuration/context.png)

Retorno no console da ide: 

![imagem local](/imagem_readme/appPropeties_configuration/consoledospring.png)





