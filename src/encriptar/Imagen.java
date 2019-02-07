package encriptar;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.misc.BASE64Decoder;

public class Imagen {

    private BufferedImage imageActual;
    private BufferedImage imageModificada;
    public BufferedImage sombra1, sombra2,sombrafinal=null;//sombra3,sombra4,sombra5, sombrafinal=null;
    
    public boolean validarTamaño()
    {
        int alto = imageActual.getHeight();
        int ancho = imageActual.getWidth();
        boolean bandera = false;
        if(alto <= 1000 && ancho <=1000){
            JOptionPane.showMessageDialog(null, "Imagen aceptada");
            bandera = true;
        }
        else
            JOptionPane.showMessageDialog(null, "El tamaño de la imagen es incorrecto","Error !",JOptionPane.ERROR_MESSAGE);
        return bandera;
    }
    
    public BufferedImage abrirImagen(){
        BufferedImage bmp=null, bmpAux=null;
        JFileChooser selector=new JFileChooser();
        selector.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & BMP & PNG", "jpg", "bmp","png");
        selector.setFileFilter(filtroImagen);
        int flag=selector.showOpenDialog(null);
        if(flag==JFileChooser.APPROVE_OPTION){
            try {
                File imagenSeleccionada=selector.getSelectedFile();
                bmp = ImageIO.read(imagenSeleccionada);
                bmpAux = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
                System.err.print(e);
            }
                  
        }
        imageActual=bmp;
        imageModificada = bmpAux;
        
        return bmp;
    }
    public void descifrar(BufferedImage share[]) {
      sombra1 = share[0];
      sombra2 = share[1];
//      sombra3 = share[2];
//      sombra4 = share[3];
//      sombra5 = share[4];
      sombrafinal = new BufferedImage(sombra1.getWidth(), sombra1.getHeight(), BufferedImage.TRANSLUCENT);
      
    }
    public BufferedImage mergeShares()
    { 
        Graphics2D g = sombrafinal.createGraphics();
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g.drawImage(sombra1, 0, 0, null);
        g.drawImage(sombra2, 0, 0, null);
//        g.drawImage(sombra3, 0, 0, null);
//        g.drawImage(sombra4, 0, 0, null);
//        g.drawImage(sombra5, 0, 0, null);
       
       return sombrafinal;
    }
    public void guardarImagen(BufferedImage img, String direccion){
        final ByteArrayOutputStream os = new ByteArrayOutputStream();	
        try {
            ImageIO.write( img, "png", os);
            File archivo=new File(direccion);
            archivo.delete();
            FileWriter escribir=new FileWriter(archivo,true);
            escribir.write(Base64.getEncoder().encodeToString(os.toByteArray()));
            escribir.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public void guardarRSA(String cifrado,String ruta){
        try {
            File archivo=new File(ruta);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("");
            FileWriter escribir = new FileWriter(archivo,true);
            escribir.write(cifrado);
            escribir.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public String obtenerDireccion(){
	JFileChooser openFile = new JFileChooser();
	int ret = openFile.showOpenDialog(null);
	if (ret==0) 
        {
            File file = openFile.getSelectedFile();
            String filename = file.getAbsolutePath();
            return filename;
	}
	else
            return null;
    }
    public String leerImagen(String archivoRuta)
    {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        String texto = "";

        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File (archivoRuta);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

           // Lectura del fichero
            
            while((linea=br.readLine())!=null)
                texto = linea;
                
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return texto;
    }
    
    public String leerRSA(String archivoRuta)
    {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        String texto = "";

        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File (archivoRuta);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

           // Lectura del fichero
            
            while((linea=br.readLine())!=null)
                texto = linea;
                
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return texto;
    }
    public String convertirBigAString(BigInteger mensaje[])
    {
        String concadenacion = "";
        BigInteger[] big = new BigInteger[mensaje.length];
        for (int i = 0; i < 3; i++) {
            big[i] = new BigInteger(mensaje[i].toString());
            concadenacion += big[i].toString()+":";
        }
        
        return concadenacion;
    }
    public BigInteger [] StringABig(String cadena)
    {
        String [] temp;
        temp = cadena.split(":");
        BigInteger[] nuevo = new BigInteger[temp.length];
        
        for (int i = 0; i < temp.length; i++) {
            
            System.out.println(temp[i]);
            nuevo[i] = new BigInteger(temp[i]);
        }
        return (nuevo);
    }
    public static BufferedImage decodeToImage(String imageString) throws IOException {
        BufferedImage image = null;
        byte[] imageByte;
        BASE64Decoder decoder = new BASE64Decoder();
        imageByte = decoder.decodeBuffer(imageString);
        ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
        image = ImageIO.read(bis);
        bis.close();
        return image;
    }
}
