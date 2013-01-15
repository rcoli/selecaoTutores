INSTRUÇÕES DE USO DA APLICAÇÃO
========================================
1 - Criar um banco de dados MySQL com o nome : "seltutores";
2 - Rodar o arquivo a seguir, como Java Application, para gerar as tabelas do banco de dados: \selecaoTutores\src\br\edu\cederj\util\GeraTabelas.java
3 - Executar a instrução a seguir para gerar a carga inicial do banco: selecaoTutores\WebContent\files\db_carga-inicial.sql
4 - Rodar a aplicação no servidor Apache TomCat


<!-- PÁGINA DE INCRIÇÕES -->
	<http use-expressions="true">

		<intercept-url pattern="/incricao/**" access="hasRole('supervisor')" />

		<!-- Allow all other requests. In a real application you should adopt a 
			whitelisting approach where access is not allowed by default <intercept-url 
			pattern="/**" access="permitAll" /> <!-- Set the login page and what to do 
			if login fails -->
		<form-login login-page="/inscricao" default-target-url="/inscricao/inicio"
			authentication-failure-url="/inscricao?login_error" />
		<logout logout-success-url="/inscricao" delete-cookies="JSESSIONID" />

		<!-- Uncomment to limit the number of sessions a user can have -->
		<session-management invalid-session-url="/inscricao?login_error">
			<concurrency-control max-sessions="1"
				error-if-maximum-exceeded="true" />
		</session-management>

	</http>