package encriptar;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Algoritmo {
    private BufferedImage img;
    public static final int NUM_DE_SOMBRAS = 2;
    public static final int BLANCO = Color.WHITE.getRGB();
    public static final int NEGRO = Color.BLACK.getRGB();
    public static int MAX_ANCHO=800;
    public static int MAX_ALTO=600;
    int imagenPixel;
    int ancho, alto;
    
    private BufferedImage[] sombra=null;
    private Random random;
    public Algoritmo(BufferedImage img)
    {
      this.img = img;
      ancho = img.getWidth();
      alto = img.getHeight();
    }

    public BufferedImage[] generarSombras()
    {
        sombra = new BufferedImage[NUM_DE_SOMBRAS];
        for(int i=0; i<NUM_DE_SOMBRAS; i++)
        {
            sombra[i]=new BufferedImage(ancho*2, alto, BufferedImage.TYPE_BYTE_BINARY);
        }
        random = new Random();
        for(int x=0; x<ancho; x++)
        {
            for(int y=0; y<alto; y++)
            {
                imagenPixel = img.getRGB(x,y);
                int index = random.nextInt(NUM_DE_SOMBRAS);

                if(imagenPixel == BLANCO)
                {
                    for(int i=0; i<sombra.length; i++)
                    if(index==0)
                    {
                        sombra[i].setRGB(2*x, y, BLANCO);
                        sombra[i].setRGB(2*x+1, y, NEGRO);
                    }
                    else
                    {
                        sombra[i].setRGB(2*x, y, NEGRO);
                        sombra[i].setRGB(2*x+1, y, BLANCO);
                    }
                }
                else
                {
                    for(int i=0; i<sombra.length; i++)
                    if(((index+i)%sombra.length)==0)
                    {
                        sombra[i].setRGB(2*x, y, BLANCO);
                        sombra[i].setRGB(2*x+1, y, NEGRO);
                    }
                    else
                    {
                        sombra[i].setRGB(2*x, y, NEGRO);
                        sombra[i].setRGB(2*x+1, y, BLANCO);
                    }
                }
            }
        }
        return sombra;
    }
    public void validarImagenBinaria()
    {
        int cont = 0;
        for(int x=0; x<ancho; x++)
        {
            for(int y=0; y<alto; y++)
            {
                imagenPixel = img.getRGB(x,y);
                if(imagenPixel == BLANCO || imagenPixel == NEGRO)
                    cont++;
                else
                    cont--;
            }
        }
        if (cont == ancho*alto) {
            System.out.print("bien");
        }
        else
            System.err.print("Mal !");
        
    }
}
