package TinderEvolution.Console;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import TinderEvolution.Gerenciador.UsuarioGerenciador;
import TinderEvolution.Dominio.Usuario;

public class UsuarioMenu {
    private UsuarioGerenciador gerenciador;

    public UsuarioMenu() {
        this.gerenciador = new UsuarioGerenciador();
    }

    public void opcoes() {
        Scanner scanner = new Scanner(System.in);
        char opcao = ' ';

        while (opcao != 'X') {

            System.out.println("\nSelecione uma opção");
            System.out.println("[ C ] Criar");
            System.out.println("[ E ] Editar");
            System.out.println("[ L ] Listar");
            System.out.println("[ P ] Procurar");
            System.out.println("[ D ] Deletar");
            System.out.println("[ X ] Voltar");
            System.out.print("> ");
            opcao = scanner.next().charAt(0);

            switch (opcao) {
                case 'C':
                    create();
                    break;
                case 'E':
                    editar();
                    break;
                case 'L':
                    listar();
                    break;
                case 'P':
                    procurar();
                    break;
                case 'D':
                    deletar();
                    break;
                case 'X':
                    System.out.println("...");
                    break;
                default:
                    System.out.println("... opção inválida ...");
            }
        }
    }

    public Usuario create() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCriação de Usuário...");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Bio: ");
        String bio = scanner.nextLine();

        System.out.print("Ano de Nascimento: ");
        int ano = scanner.nextInt();

        System.out.print("Mês de Nascimento: ");
        int mes = scanner.nextInt();

        System.out.print("Dia de Nascimento: ");
        int dia = scanner.nextInt();

        System.out.print("Latitude: ");
        Double latitude  = scanner.nextDouble();

        System.out.print("Longitude: ");
        Double longitude = scanner.nextDouble();

        Usuario usuario = new Usuario(nome, email, telefone, LocalDate.of(ano, mes, dia), bio, latitude, longitude);
        return gerenciador.salvar(usuario);

    }

    public Usuario editar() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEdição de Usuário...");
        System.out.println("Qual usuário deseja editar?");

        List<Usuario> usuarios = gerenciador.listar();
        for (Usuario usuario : usuarios) {
            System.out.println("[" + usuario.getId() + "] - " + usuario.getNome());
        }

        System.out.print("> ");
        int id = scanner.nextInt(); scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        Usuario atualizacao = new Usuario(nome);

        Usuario usuarioAtualizado = gerenciador.editar(id, atualizacao);

        if (usuarioAtualizado == null) {
            System.out.println("Usuário não encontrado.");
        } else {
            System.out.println(usuarioAtualizado);
        }

        return usuarioAtualizado;
    }

    private List<Usuario> listar() {

        System.out.println("\nListagem de Usuários...");
        List<Usuario> usuarios = gerenciador.listar();

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }

        return usuarios;

    }

    private void procurar() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPesquisa de Usuário...");
        System.out.println("Qual o código do Usuário? ");

        System.out.print("> ");
        int id = scanner.nextInt();

        Usuario usuario = gerenciador.procurar(id);

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
        } else {
            System.out.println(usuario);
        }
    }

    private void deletar() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nExclusão de Usuário...");
        System.out.println("Qual usuário deseja deletar?");

        List<Usuario> usuarios = gerenciador.listar();
        for (Usuario usuario : usuarios) {
            System.out.println("[" + usuario.getId() + "] - " + usuario.getNome());
        }

        System.out.print("> ");
        int id = scanner.nextInt();

        if (gerenciador.deletar(id)) {
            System.out.println("Usuário deletado.");
        } else {
            System.out.println("Usuário não encontrado.");
        }

    }
}
