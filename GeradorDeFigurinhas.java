import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;

public class GeradorDeFigurinhas {

	
	public void criar(InputStream inputStream , String nomeArquivo) throws IOException {
		
		//leitura da imagem
        //A classe InpuStream implementa o polimorfismo.Podemos ler bytes de diferentes formas.
        // InputStream  inputStream = new FileInputStream(new File("entrada/filme.jpg"));

       //Lendo a imagem da url
	   //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg")
       //.openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);

		
		//criar nova imagem em memória com transparência e com tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura+200;
		BufferedImage novaImagem = new BufferedImage(largura , novaAltura,BufferedImage.TRANSLUCENT);
	
		
		//copiar a imagem original para  nova imagem (em memória)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0 ,0,null);
		
		
		//Configurar a fonte
        var fonte = new Font(Font.SANS_SERIF , Font.BOLD, 64 );
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
		//Escrever uma frase na nova imagem
		
        graphics.drawString("TOMEI UM MELZINHO" , 0 , novaAltura-100 );
		//Escrever  a nova imagem em um arquivo
		//*Desafio criar um diretório pelo código
		ImageIO.write(novaImagem, "png"  , new File(nomeArquivo));
	}
	
	
}