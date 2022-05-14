package models;

import models.exceptions.ContrasenaDebilException;
import models.exceptions.UsuarioNoDisponibleExeption;
import models.factory.ValidadorFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RegistroUsuarioTest {

  @Test
  public void validarContrasenasDebiles()  {
    SoftAssertions soft = new SoftAssertions();

    soft.assertThatThrownBy(() -> new Administrador(ValidadorFactory.validador()
            ,"admin1234"
            ,"admin1234"))
        .isExactlyInstanceOf(ContrasenaDebilException.class)
        .hasMessage("Contraseña dentro de las 10000 mas usadas. Elija otra por favor."
            + "La contraseña no debe tener 4 caracteres consecutivos."
            +"No se puede utilizar contraseñas por defecto.");

    soft.assertThatThrownBy(() -> new Administrador(ValidadorFactory.validador()
        ,"admin"
        ,"aaa1234"))
        .isExactlyInstanceOf(ContrasenaDebilException.class)
        .hasMessage("La contraseña debe tener al menos 8 caracteres."
            + "La contraseña no debe tener 4 caracteres consecutivos."
            + "La contraseña no debe repetir 3 veces seguidas un mismo caracter.");
  }


  @Test
  public void registrarYObtener() throws FileNotFoundException {
    Administradores administradores= Administradores.getInstance();
   Administrador administrador = new Administrador(ValidadorFactory.validador(),"Juancito","ContraSUper*MegaS3gUr4");
   Assertions.assertEquals(administrador,administradores.obtenerAdministrador("Juancito","ContraSUper*MegaS3gUr4"));
    SoftAssertions soft = new SoftAssertions();

    assertThatThrownBy(() -> administradores.obtenerAdministrador("Juancito","contraIncorrecta"))
        .isExactlyInstanceOf(UsuarioNoDisponibleExeption.class)
        .hasMessage("No se pudo validar que sea ese administrador");

    assertThatThrownBy(() -> administradores.obtenerAdministrador("Usuario_Inexistente","contraIncorrecta"))
        .isExactlyInstanceOf(UsuarioNoDisponibleExeption.class)
        .hasMessage("No existe el usuarion: Usuario_Inexistente");
  }

  @BeforeEach
  public void limpiarSingleton() {
    Administradores.getInstance().admins= new ArrayList<Administrador>();
  }

}
