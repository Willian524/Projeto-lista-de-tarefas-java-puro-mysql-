package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DB {
	//METODO AUXILIAR PARA CARREGAR AS PROPRIEDADES QUE ESTAO SALVAS NO DB.PROPERTIES
	private Properties loaProperties() {
		
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
