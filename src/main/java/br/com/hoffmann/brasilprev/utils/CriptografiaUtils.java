package br.com.hoffmann.brasilprev.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class CriptografiaUtils implements PasswordEncoder {

    @Value("${prefixo}")
    private String prefixo;

    @Override
    public String encode(CharSequence senha) {
        String hashCompleto = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            hashCompleto = DatatypeConverter.printBase64Binary(
                    md.digest(prefixo.concat(senha.toString()).getBytes()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashCompleto;
    }

    @Override
    public boolean matches(CharSequence senha, String senhaEncoed) {
        String hashCompleto = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            hashCompleto = DatatypeConverter.printBase64Binary(
                    md.digest(prefixo.concat(senha.toString()).getBytes()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashCompleto.equalsIgnoreCase(senhaEncoed);
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

}
