package poo.sca.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
* @author Gregui Shigunov
* @since 20/09/2007
*/
public class UtilsArquivo {

/**
* Salva o conte�do de uma vari�vel em um arquivo
* @param arquivo
* @param conteudo
* @param adicionar se true adicionar no final do arquivo
* @throws IOException
*/
public static void salvar(String arquivo, String conteudo, boolean adicionar)
throws IOException {

FileWriter fw = new FileWriter(arquivo, adicionar);

fw.write(conteudo);
fw.close();
}

/**
* Carrega o conte�do de um arquivo em uma String, se o aquivo
* n�o existir, retornar� null.
* @param arquivo
* @return conte�do
* @throws Exception
*/
public static String carregar(String arquivo)
throws FileNotFoundException, IOException {

File file = new File(arquivo);

if (! file.exists()) {
return null;
}

BufferedReader br = new BufferedReader(new FileReader(arquivo));
StringBuffer bufSaida = new StringBuffer();

String linha;
while( (linha = br.readLine()) != null ){
bufSaida.append(linha + "\n");
}
br.close();
return bufSaida.toString();
}




/**
* Exemplo de Utiliza��o
*/
public static void main(String[] args) {
try {
String texto = "Gregui Shigunov \n gregui@gmail.com.br";

//UtilsArquivo.salvar("arquivo.txt", texto, false);

texto = UtilsArquivo.carregar("arquivo.txt");

System.out.println(texto);

} catch (Exception e) {
e.printStackTrace();
}

}
}