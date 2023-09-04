package HomeTask1.InMemoryModel;

public interface IModelChanger {

    // Оповещает о том, что произошло изменение в хранилище моделей
    void notifyChange();

    // Подписаться на оповещение об изменениях
    void RegisterModelChanger(IModelChangedObserver o);

    // Отписаться от оповещения об ихменениях
    void RemoveModelChanger(IModelChangedObserver o);

}