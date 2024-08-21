package eni.demo.demo.module4.bll;

public class FactoryManager {

    // Instance/Attribut/Variable de classe
    static AlimentManager alimentManager;

    /**
     * Récupérer en static (sans instancier nous même) ArticleManager
     * @return
     */
    public static AlimentManager getAlimentManagerNoSingleton() {
        return new AlimentManager();
    }

    /**
     * Récupérer en static (sans instancier nous même) ArticleManager
     * Mais en Singleton
     * @return
     */
    public static AlimentManager getAlimentManager() {
        // Instancier qu'une fois donc quand il est null
        // La premiere fois il est null
        if (alimentManager == null) {
            alimentManager = new AlimentManager();
        }
        return alimentManager;
    }
}
