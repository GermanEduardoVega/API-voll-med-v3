package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroMedico(
        @NotBlank(message = "Nombre es obligatorio")
        String nombre,
        @NotBlank(message = "Email es obligatorio")
        @Email(message = "Formato de email es inválido")
        String email,
        @NotBlank(message = "Teléfono es obligatorio")
        String telefono,
        @NotBlank(message = "Documento es obligatorio")
        @Pattern(regexp = "\\d{7,9}", message = "Formato do Documento es inválido")
        String documento,
        @NotNull@NotNull(message = "Especialidad es obligatorio")
        Especialidad especialidad,
        @NotNull@NotNull(message = "Datos de dirección son obligatorios")
        @Valid DatosDireccion direccion


) { //record ya incluye los get & sets y constructores
}
