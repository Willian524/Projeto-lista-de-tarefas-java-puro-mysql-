package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {	
	private Connection conn = null;
	public static Connection getConnection() {
		//ENQUANTO CONN RETORNAR NULL, NAO ESTA CONECTADO COM O BANCO DE DADOS
		if(conn == null) {
			try {
				//PEGA AS PROPRIEDADES DO BANCO DE DADOS, CRIADO NO METODO AUXILIAR com loadProperties
				Properties props = loadProperties();
				//PEGA A URL NO OBJETO PROPERTIES(PASSAR A CHAVE CORRETA QUE ESTA NO ARQUIVO) com getProperties
				String url = props.getProperty(dburl);
				//DriverManager E UMA CLASSE DO PACOTE JAVA.SQL QUE ATUA COMO GERENCIADOR DE DRIVERS JDBC, RESPONSAVEL POR:
				//REGISTRAR DRIVER DE BANCO DE DADOS, CRIAR CONEXAO ENTRE JAVA E O BANCO DE DADOS, GERENCIAR MULTIPLAS CONEXOES SE NECESSARIO.
				//.getConnection PEGA A URL DO BANCO E AS PROPRIEDADES DE CONEXAO(SENHA, LOGIN, PROPS)
				//TUDO ATRIBUIDO A VARIAVEL CONN QUE FOI DEFINIDA COMO NULL ANTERIORMENTE, CASO DE CERTO CONN IRA COMECAR A PASSAR O VALOR TRUE
				conn = DriverManager.getConnection(url);
				
				//EXCECAO CASO DE ALGUMA SQLEXCHEPTION
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			//RETORNAR CONN NO FINAL DO CATCH
		}
	}
	
	
	//METODO AUXILIAR PARA CARREGAR AS PROPRIEDADES QUE ESTAO SALVAS NO DB.PROPERTIES
	
	private Properties loadProperties() {
		
		try {
			//FileInputStream E UTILIZADO PARA LER ARQUIVOS BYTE A BYTE(ARQUIVOS DE FOTOS, AUDIO, TEXTO)
			//E PASSADO COMO PARAMETRO O NOME DO ARQUIVO
			FileInputStream fs = new FileInputStream("db.properties");
			
			//INSTANCIA DO PROPERTIES
			Properties props = new Properties();
			//O .load FAZ A LEITURA DO ARQUIVO PROPERTIES APONTADO PELO INPUTSTREAM(FS)E GUARDA OS DADOS DENTRO DO OBJETO PROPS
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
}
