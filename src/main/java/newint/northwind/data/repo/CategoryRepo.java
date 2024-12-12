package newint.northwind.data.repo;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import newint.northwind.entity.Category;

@ApplicationScoped
public class CategoryRepo {
  @Inject EntityManager em;
  
  private static String FIND_ALL_QUERY = "SELECT c FROM Category c";
  private static String FIND_QUERY = "SELECT c FROM Category c WHERE c.id = :id";

  public List<Category> find() {
    List<Category> list = em.createQuery(FIND_ALL_QUERY, Category.class).getResultList();
    return list;
    
  }

  public Category find(Short id) {
    return em.createQuery(FIND_QUERY, Category.class)
      .setParameter("id", id)
      .getSingleResult();
  }

  @Transactional
  public void add(Category c) {
    em.persist(c);
  }

  @Transactional
  public void remove(Short id) {
    Category c = em.find(Category.class, id);
    em.remove(c);
  }
}
