package encriptar;

import java.math.BigInteger;
import java.util.Random;

public class AlgoritmoRSA {
    static int TAM_BITS = 256;
    BigInteger n, q, p;
    BigInteger euler;
    BigInteger e, d;
    String a;

    /** Constructor de la clase RSA
    public AlgoritmoRSA(int bits) {
        this.bits = bits;
    } */
    
    public void generaPrimos()
    {
        p = new BigInteger(TAM_BITS,10, new Random());
        do 
            q = new BigInteger(TAM_BITS,10, new Random());
        while(q.compareTo(p)==0);
    }
    
    public void generaClaves()
    {
        // n = p * q;
        n = p.multiply(q);
        // toltient = (p-1)*(q-1)
        euler = p.subtract(BigInteger.valueOf(1));
        euler = euler.multiply(q.subtract(BigInteger.valueOf(1)));
        // Elegimos un e coprimo de y menor que n
        do 
            e = new BigInteger(2 * TAM_BITS, new Random());    
        while((e.compareTo(euler) != -1) || (e.gcd(euler).compareTo(BigInteger.valueOf(1)) != 0));
            d = e.modInverse(euler);
            // d = e^1 mod totient
    }
    
    /**
     * Encripta el texto usando la clave pública
     */
    public BigInteger[] encripta(String mensaje)
    {
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];
        
        for(i=0; i<bigdigitos.length;i++){
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }
        
        BigInteger[] encriptado = new BigInteger[bigdigitos.length];
        
        for(i=0; i<bigdigitos.length; i++)
        {
            encriptado[i] = bigdigitos[i].modPow(e,n);
        }
        
        return(encriptado);
    }
    
    /**
     * Desencripta el texto cifrado usando la clave privada
     */
    public String desencripta(BigInteger[] encriptado) {
        BigInteger[] desencriptado = new BigInteger[encriptado.length];
        
        for(int i=0; i<desencriptado.length; i++)
            desencriptado[i] = encriptado[i].modPow(d,n);
        
        char[] charArray = new char[desencriptado.length];
        
        for(int i=0; i<charArray.length; i++)
            charArray[i] = (char) (desencriptado[i].intValue());
        
        return(new String(charArray));
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getTotient() {
        return euler;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }
    
    
}
