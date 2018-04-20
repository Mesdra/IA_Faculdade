package Imagem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class LeituraImagem {

	public void jButton1ActionPerformed(String nomeArq) {
		BufferedImage image;

		String str = "C:\\Users\\vini\\Pictures\\";
		str = str.concat(nomeArq);
		try {
			image = ImageIO.read(new File(str));
			ImageIcon icon = new ImageIcon(image);
			JLabel imageLabel = new JLabel(icon);
			JFrame frame = new JFrame();
			Container contentPane = frame.getContentPane();
			contentPane.setLayout(new BorderLayout());
			contentPane.add(new JScrollPane(imageLabel), BorderLayout.CENTER);
			frame.setSize(600, 400);
			frame.setVisible(true);

			int width = image.getWidth();
			int height = image.getHeight();
			frame.setTitle("Imagem Sem Filtro: " + height + " x " + width);
			int nbands = image.getSampleModel().getNumBands();
			Raster inputRaster = image.getData();
			int[] pixels = new int[nbands * width * height];
			inputRaster.getPixels(0, 0, width, height, pixels);

			WritableRaster teste;

			int[][] r = new int[width][height];
			int[][] g = new int[width][height];
			int[][] b = new int[width][height];

			int[][] mediaR = new int[width][height];
			int[][] mediaG = new int[width][height];
			int[][] mediaB = new int[width][height];

			Color rgb = null;

			for (int w = 0; w < width; w++) {
				for (int h = 0; h < height; h++) {

					rgb = new Color(image.getRGB(w, h));

					r[w][h] = rgb.getRed();
					g[w][h] = rgb.getGreen();
					b[w][h] = rgb.getBlue();

					teste = image.getRaster();

				}
			}
			BufferedImage imagemSoma = new BufferedImage(image.getWidth(), image.getHeight(),
					BufferedImage.TYPE_INT_RGB);

			int[][] imagemSemFiltro = new int[width][height];
			for (int i = 0; i <= image.getWidth() - 1; i++) {
				for (int j = 0; j <= image.getHeight() - 1; j++) {
					int vermelho = r[i][j];
					int verde = g[i][j];
					int azul = b[i][j];
					int cor = (vermelho + verde + azul) / 3;
					imagemSoma.setRGB(i, j, new Color(cor, cor, cor).getRGB());
					imagemSemFiltro[i][j] = cor;
				}
			}

			ImageIO.write(imagemSoma, "jpg", new File("C:\\Users\\vini\\Pictures\\PET2.jpg"));

			
			int[][] mat = { { 0, -1, 0 }, { -1, 4, -1 }, { 0, -1, 0 } };
			int[][] imagemComFiltro = funcConvolucao(mat, 3, image.getWidth(), image.getHeight(), imagemSemFiltro);
			mat = new int[][] { { -1 , -1, -1 }, { 0, 0, 0 }, { 1, 1, 1 } };
			int[][] imagemFiltro2 = funcConvolucao(mat, 3, image.getWidth(), image.getHeight(), imagemComFiltro);
			
			BufferedImage imagemFiltroRgb = new BufferedImage(image.getWidth(),image.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			BufferedImage imagemTeste = new BufferedImage(image.getWidth(),image.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			
			for (int i = 0; i <=  image.getWidth()-1; i++) {
				for (int j = 0; j <= image.getHeight()-1; j++) {
					int cor = imagemComFiltro[i][j];
					int sub = imagemFiltro2[i][j];
					int soma = sub + cor;
					if(soma > 255)
						soma = 255;
					if(soma < 0)
						soma = 0;
					imagemFiltroRgb.setRGB(i, j, new Color(cor, cor, cor).getRGB());
					imagemTeste.setRGB(i, j,new Color(soma,soma,soma).getRGB());
				}
			}
			
				ImageIO.write(imagemFiltroRgb, "jpg", new File("C:\\Users\\vini\\Pictures\\PETcomFiltroTeste.jpg"));
				
				ImageIO.write(imagemTeste, "jpg", new File("C:\\Users\\vini\\Pictures\\PETsubtracaoTeste.jpg"));
			
			

		} catch (IOException ex) {
		}

	}

	public int[][] funcConvolucao(int[][] mat, int tamanhoMat, int Width, int Height, int[][] imagemSemFiltro) {
		int[][] imagemComFiltro = new int[Width][Height];

		int meio = (tamanhoMat - 1) / 2;
		int largura = Width - (1 + meio);
		int altura = Height - (1 + meio);
		
		
		
		for (int i = meio; i <= largura; i++) {
			for (int j = meio; j <= altura; j++) {
				int[] dados = new int[tamanhoMat * tamanhoMat];
				int k = 0;
				for (int l = 0; l < tamanhoMat; l++) {
					for (int m = 0; m < tamanhoMat; m++) {
						if (mat[l][m] != 0) {
							dados[k] = mat[l][m] * imagemSemFiltro[i + (l - meio)][j + (m - meio)];
							k++;
						}
					}

				}
				int total = 0;
				for (int o = 0; o < tamanhoMat * tamanhoMat; o++) {
					total += dados[o];
				}
				if(total > 255)
					total = 255;
				if(total < 0)
					total = 0;
				imagemComFiltro[i][j] = Math.abs(total);

			}
		}
		
		return imagemComFiltro;
	}

}
