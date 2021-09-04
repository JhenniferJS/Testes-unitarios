package br.inatel.service.test;

import br.inatel.model.Game;
import br.inatel.service.ConsultarGames;
import br.inatel.service.LerCSV;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

public class ConsultarGamesTest {

    private static List<Game> csvGames;

    @BeforeClass
    public static void initCsv(){
        csvGames = new LerCSV().lerGames(Paths.get("src/main/resources/vendas-games.csv"));
    }

    @Test
    public void TestPlataformValida(){
        ConsultarGames games = new ConsultarGames();
        List<Game> lista = games.buscarPorPlataform(csvGames, "PS3");
        Assert.assertFalse(lista.isEmpty());
    }

    @Test
    public void TestPlataformInvalida(){
        ConsultarGames games = new ConsultarGames();
        List<Game> lista = games.buscarPorPlataform(csvGames, "ABC");
        Assert.assertTrue(lista.isEmpty());
    }

    @Test
    public void TestPublisherValido(){
        ConsultarGames games = new ConsultarGames();
        List<Game> lista = games.buscarPorPublisher(csvGames, "Electronic Arts");
        Assert.assertFalse(lista.isEmpty());
    }

    @Test
    public void TestPublisherInvalido(){
        ConsultarGames games = new ConsultarGames();
        List<Game> lista = games.buscarPorPublisher(csvGames, "ABC");
        Assert.assertTrue(lista.isEmpty());
    }
}
