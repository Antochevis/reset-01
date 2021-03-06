package TinderEvolution.Console;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        MusicaMenu musicaMenu = new MusicaMenu();
        FilmeMenu filmeMenu = new FilmeMenu();
        SerieMenu serieMenu = new SerieMenu();
        EsporteMenu esporteMenu = new EsporteMenu();
        CuriosidadeMenu curiosidadeMenu = new CuriosidadeMenu();
        TimeMenu timeMenu = new TimeMenu();
        UsuarioMenu usuarioMenu = new UsuarioMenu();

        Scanner scanner = new Scanner(System.in);
        char opcao = ' ';

        while (opcao != 'X') {

            System.out.println("\nSelecione uma opção");
            System.out.println("[ M ] Músicas");
            System.out.println("[ F ] Filmes");
            System.out.println("[ S ] Séries");
            System.out.println("[ E ] Esportes");
            System.out.println("[ C ] Curiosidades");
            System.out.println("[ U ] Usuários");
            System.out.println("[ T ] Time de futebol");
            System.out.println("[ X ] Encerrar");
            System.out.print("> ");
            opcao = scanner.next().charAt(0);

            switch (opcao) {
                case 'M':
                    musicaMenu.opcoes();
                    break;

                case 'F':
                    filmeMenu.opcoes();
                    break;

                case 'S':
                    serieMenu.opcoes();
                    break;

                case 'E':
                    esporteMenu.opcoes();
                    break;

                case 'C':
                    curiosidadeMenu.opcoes();
                    break;

                case 'T':
                    timeMenu.opcoes();
                    break;

                case 'U':
                    usuarioMenu.opcoes();
                    break;

                case 'X':
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("... opção inválida ...");
            }
        }
    }
}