# Arquitetura Spring

[Classe Application](#Classe-Application)

![imagem local](imagem_readme/springboner.png)


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

[imgspringappbuilder]

Comentei o SpringApplication para rodar manualmente com o SpringApplciationBuilder e fazer configuração adicionais:

[imgbuildermetodos]

Existem diversas configurações, remover o banner Mode, configurar contexto da applicação, rodar aplicação apontando para perfils

