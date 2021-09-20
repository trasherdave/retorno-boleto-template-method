
import com.david.retornoboleto.LeituraRetorno;
import com.david.retornoboleto.ProcessarBoletos;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;

/**
 *
 * @author David
 */
public class Main {

    public static void main(String[] args) {

        final ProcessarBoletos processador = new ProcessarBoletos(LeituraRetorno::processarLinhaBancoBadresco);

        URL url = Main.class.getClassLoader().getResource("bradesco-1.csv");
        Path scriptPath = new File(url.getPath()).toPath();
        String nomeArquivo = scriptPath.toString();
        processador.processar(nomeArquivo);

    }

}
