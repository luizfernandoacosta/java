import java.util.List;
public interface DAO {
    void adicionarUsuario(Usuario usuario);
    Usuario buscarUsuario(int id);
    List<Usuario>  listarUsuarios();
    void atualizarUsuario(Usuario selectNome);
    void removerUsuario(int id);
}
