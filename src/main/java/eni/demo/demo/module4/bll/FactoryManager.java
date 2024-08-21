package eni.demo.demo.module4.bll;

public class FactoryManager {

    /**
     * Récupérer en static (sans instancier nous même) ArticleManager
     * @return
     */
    public static AlimentManager getAlimentManager() {
        return new AlimentManager();
    }
}
