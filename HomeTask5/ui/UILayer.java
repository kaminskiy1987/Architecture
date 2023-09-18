package HomeTask5.ui;

/**
 * Интерфейс UI
 */
public interface UILayer {

    void openProject(String fileName);

    void showProjectSettings();

    void saveProject();

    void printAllModels();

    void printAllTextures();

    void renderAll();

    void renderModel(int modelId);

    void createTexture();

    void deleteTexture(int textureNo);

    void createModel();

    void deleteModel(int modelNo);

    void addTextureToModel(int modelNo, int textureNo);

    void removeTextureFromModel(int modelNo, int textureNo);

}
