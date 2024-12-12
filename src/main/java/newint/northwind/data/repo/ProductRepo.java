package newint.northwind.data.repo;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import newint.northwind.entity.Product;

@ApplicationScoped
public class ProductRepo {
  @Inject EntityManager em;
  
  private static String FIND_ALL_QUERY = "SELECT p FROM Product p";
  private static String FIND_QUERY = "SELECT p FROM Product p WHERE p.id = :id";

  public List<Product> find() {
    List<Product> list = em.createQuery(FIND_ALL_QUERY, Product.class).getResultList();
    return list;
    
  }

  public Product find(String id) {
    return em.createQuery(FIND_QUERY, Product.class)
      .setParameter("id", id)
      .getSingleResult();
  }

  @Transactional
  public void add(Product p) {
    em.persist(p);
  }

  @Transactional
  public void remove(String id) {
    Product p = em.find(Product.class, id);
    em.remove(p);
  }
  
}
