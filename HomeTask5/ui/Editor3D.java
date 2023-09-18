package HomeTask5.ui;

import HomeTask5.bll.*;
import HomeTask5.dac.*;
import HomeTask5.database.*;
import HomeTask5.entity.Model3D;
import HomeTask5.entity.ProjectFile;
import HomeTask5.entity.Texture;

import java.util.ArrayList;
import java.util.List;

/**
 * UI (User Interface)
 */
public class Editor3D implements UILayer {
    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;
    private DatabaseAccess databaseAccess;
    private Database database;

    private void initialize() {
        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);
    }

    @Override
    public void openProject(String fileName) {
        this.projectFile = new ProjectFile(fileName);
        initialize();
    }

    @Override
    public void showProjectSettings() {

        // Предусловие
        checkProjectFile();

        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("******************");

    }

    private void checkProjectFile() {
        if (projectFile == null)
            throw new RuntimeException("Файл проекта не определен.");
    }

    @Override
    public void saveProject() {

        // Предусловие
        checkProjectFile();

        database.save();
        System.out.println("Изменения успешно сохранены.");
    }

    @Override
    public void printAllModels() {

        // Предусловие
        checkProjectFile();

        List<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(models.get(i));
            for (Texture texture : models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }
    }

    @Override
    public void printAllTextures() {

        // Предусловие
        checkProjectFile();

       List<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        // Предусловие
        checkProjectFile();

        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);
    }

    @Override
    public void renderModel(int modelId) {

        // Предусловие
        checkProjectFile();

        List<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();

        if (modelId < 0 || modelId > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректно.");

        System.out.println("Подождите ...");

        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(modelId));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);
    }

    @Override
    public void deleteTexture(int textureNo) {

        // Предусловие
        checkProjectFile();

        List<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();

        if (textureNo < 0 || textureNo > textures.size() - 1)
            throw new RuntimeException("Номер текстуры указан некорректно.");

        businessLogicalLayer.removeTexture(textures.get(textureNo));
        System.out.println("Текстура успешно удалена");
    }

    @Override
    public void createTexture() {

        // Предусловие
        checkProjectFile();

        businessLogicalLayer.createTexture();
        System.out.println("Создана новая текстура");
    }

    @Override
    public void createModel() {

        // Предусловие
        checkProjectFile();

        businessLogicalLayer.createModel();
        System.out.println("Создана новая модель");
    }

    @Override
    public void deleteModel(int modelNo) {

        // Предусловие
        checkProjectFile();

        List<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();

        if (modelNo < 0 || modelNo > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректно.");

        businessLogicalLayer.removeModel(models.get(modelNo));
        System.out.println("Модель успешно удалена");
    }

    @Override
    public void addTextureToModel(int modelNo, int textureNo) {

        // Предусловие
        checkProjectFile();

        List<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();

        if (modelNo < 0 || modelNo > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректно.");

        List<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();

        if (textureNo < 0 || textureNo > textures.size() - 1)
            throw new RuntimeException("Номер текстуры указан некорректно.");

        businessLogicalLayer.addToModel(models.get(modelNo), textures.get(textureNo));
        System.out.println("Текстура успешно добавлена к модели");
    }

    @Override
    public void removeTextureFromModel(int modelNo, int textureNo) {
        // Предусловие
        checkProjectFile();

        List<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();

        if (modelNo < 0 || modelNo > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректно.");

        List<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();

        if (textureNo < 0 || textureNo > textures.size() - 1)
            throw new RuntimeException("Номер текстуры указан некорректно.");

        businessLogicalLayer.delFromModel(models.get(modelNo), textures.get(textureNo));
        System.out.println("Текстура успешно удалена из модели");
    }
}