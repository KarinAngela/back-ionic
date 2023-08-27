package ionic.back.dto;

public record DTODBUsuario(
        String email,
        String senha
) {
    public DTODBUsuario(DTODadosLogin dadosLogin, String senhaEncriptada) {
        this(dadosLogin.email(), senhaEncriptada);
    }
}
