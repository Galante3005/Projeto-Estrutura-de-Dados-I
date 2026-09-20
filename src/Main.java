import java.util.Locale;

 
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR")); /*Garante que, não haja erros de escrrrita com letras e assento,
                                                    comum principalmente nas saídas*/
        Menu menu = new Menu(central);
        menu.executar();
    }
}
