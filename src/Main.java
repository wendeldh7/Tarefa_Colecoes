import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os nomes das pessoas e seus sexos separados por vírgula:");
        String input = scanner.nextLine();

        // Tarefa 1: Ordenar os nomes em ordem alfabética
        List<String> nomes = new ArrayList<>();
        List<String> sexos = new ArrayList<>();

        String[] pessoas = input.split(",");
        for (String pessoa : pessoas) {
            String[] partes = pessoa.trim().split("-");
            if (partes.length == 2) {
                String nome = partes[0].trim();
                String sexo = partes[1].trim();
                nomes.add(nome);
                sexos.add(sexo);
            }
        }

        System.out.println("Nomes ordenados em ordem alfabética:");
        List<String> nomesOrdenados = ordenarNomes(nomes);
        for (String nome : nomesOrdenados) {
            System.out.println(nome);
        }

        System.out.println("------------------------");

        // Tarefa 2: Separar por grupos masculino e feminino
        Map<String, List<String>> grupos = separarGrupos(nomes, sexos);

        System.out.println("Grupos masculino e feminino:");
        System.out.println("Masculino: " + grupos.get("M"));
        System.out.println("Feminino: " + grupos.get("F"));
    }

    private static List<String> ordenarNomes(List<String> nomes) {
        List<String> nomesOrdenados = new ArrayList<>(nomes);
        nomesOrdenados.sort(String::compareToIgnoreCase);
        return nomesOrdenados;
    }

    private static Map<String, List<String>> separarGrupos(List<String> nomes, List<String> sexos) {
        Map<String, List<String>> grupos = new HashMap<>();
        grupos.put("M", new ArrayList<>());
        grupos.put("F", new ArrayList<>());

        for (int i = 0; i < nomes.size(); i++) {
            String nome = nomes.get(i);
            String sexo = sexos.get(i);

            if (sexo.equalsIgnoreCase("M")) {
                grupos.get("M").add(nome);
            } else if (sexo.equalsIgnoreCase("F")) {
                grupos.get("F").add(nome);
            }
        }

        return grupos;
    }
}