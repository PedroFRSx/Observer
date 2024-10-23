import org.example.App;
import org.example.Usuario;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SistemaAtualizacaoTest {

    @Test
    public void deveNotificarUsuarioSobreAtualizacaoDeApp() {
        App app = new App("WhatsApp", "2.21.0");
        Usuario usuario = new Usuario("Carlos");
        usuario.seguirApp(app);

        app.atualizarVersao("2.21.1");
        assertEquals("Carlos, nova atualização disponível: WhatsApp (versão: 2.21.1)", usuario.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarVariosUsuariosSobreAtualizacaoDeApp() {
        App app = new App("Instagram", "185.0");
        Usuario usuario1 = new Usuario("Maria");
        Usuario usuario2 = new Usuario("João");

        usuario1.seguirApp(app);
        usuario2.seguirApp(app);

        app.atualizarVersao("186.0");
        assertEquals("Maria, nova atualização disponível: Instagram (versão: 186.0)", usuario1.getUltimaNotificacao());
        assertEquals("João, nova atualização disponível: Instagram (versão: 186.0)", usuario2.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarUsuarioApenasQuandoHaAtualizacao() {
        App app = new App("Telegram", "7.8");
        Usuario usuario = new Usuario("Ana");
        usuario.seguirApp(app);

        app.atualizarVersao("7.8"); // Mudança não ocorre
        assertEquals("Ana, nova atualização disponível: Telegram (versão: 7.8)", usuario.getUltimaNotificacao());
    }
}