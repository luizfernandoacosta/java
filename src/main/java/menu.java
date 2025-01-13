import javax.swing.*;
import java.lang.Integer;
import java.util.List;

public class menu {
        DAO dao = new ImplementDao();
        //String funcao = "1 - Novo Usuario\n2 - Buscar Usuário\n3 - Listar Usuário\n4 - Atualizar Usuário\n5 - Remover Usuário\nS - Sair";
        String [] funcao = {"Selecione uma Opção","Novo Usuário", "Buscar Usuário", "Listar Usuários", "Atualizar Usuário", "Remover Usuário", "Sair"};
        JComboBox combo = new JComboBox(funcao);

public void exibeMenu() {
    while (combo.getSelectedItem() != ("Sair")) {
        JOptionPane.showMessageDialog(null,combo,"Menu", JOptionPane.INFORMATION_MESSAGE);
        if (combo.getSelectedItem().equals("Novo Usuário")) {
            executaAdicionaUsuario();
        }
        if (combo.getSelectedItem().equals("Buscar Usuário")) {
            executaBuscarUsuario();
        }
        if (combo.getSelectedItem().equals("Listar Usuários")) {
            executarlistarUsuario();
        }
        if (combo.getSelectedItem().equals("Atualizar Usuário")) {
            executaratualizarUsuario();
        }
        if (combo.getSelectedItem().equals("Remover Usuário")) {
            executarremoverUsuario();
        }
    }
}


        public void executaAdicionaUsuario () {
            String nome = JOptionPane.showInputDialog(null, "Digite o nome do Usuário:");
            String senha = JOptionPane.showInputDialog(null, "Digite a senha do Usuário:");
            String email = JOptionPane.showInputDialog(null, "Digite o email do Usuário:");
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setSenha(senha);
            usuario.setEmail(email);
            dao.adicionarUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");
        }

        private void executaBuscarUsuario () {
            String buscar = JOptionPane.showInputDialog(null, "Informe o ID do Usuário você deseja buscar: ");
            int ibuscar = Integer.parseInt(buscar);
            Usuario buscUser = dao.buscarUsuario(ibuscar);
            JOptionPane.showMessageDialog(null, "Este é o usuário que você buscou:\n - "+buscUser.getNome());
        }

        private void executarlistarUsuario () {
            List<Usuario> usuarios = dao.listarUsuarios();
            String list = "";
            for (Usuario usuario : usuarios) {
                String usr = usuario.getNome();
                list += "- "+usr + "\n";
            }
            JOptionPane.showMessageDialog(null, "Essa é a lista de todos os Usuários:\n"+list);
        }

        private void executaratualizarUsuario () {
            String atualizaNome = JOptionPane.showInputDialog(null, "Informe o ID do usuário que queira atualizar o nome: ");
            int iatualizaNome = Integer.parseInt(atualizaNome);
            Usuario selectNome = dao.buscarUsuario(iatualizaNome);
            JOptionPane.showMessageDialog(null, selectNome.getNome()+" É o usuário selecionado!");
            String novoNome = JOptionPane.showInputDialog(null, "Informe o novo nome para o usuário: ");
            selectNome.setNome(novoNome);
            dao.atualizarUsuario(selectNome);
            JOptionPane.showMessageDialog(null, "Nome do Usuário atualizado com sucesso!");

        }

        private void executarremoverUsuario () {
            String alterarsenha = JOptionPane.showInputDialog(null, "Informe o ID do Usuário que deseja remover: ");
            int iremover = Integer.parseInt(alterarsenha);
            dao.removerUsuario(iremover);
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");

        }
    }