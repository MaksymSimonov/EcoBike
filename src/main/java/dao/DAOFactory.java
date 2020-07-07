package dao;

import java.util.List;

public interface DAOFactory<T> {
  T get(int id);
  List<T> getAll();
  boolean insert(T item);
  boolean update(T item);
  boolean remove(T item);
  void saveData();
}
