package newint.northwind.data.repo;

import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import newint.northwind.entity.Product;

@ApplicationScoped
public class ProductRepo {
  @Inject EntityManager em;
  
  private static String FIND_ALL_QUERY = "SELECT p FROM Product p";

  public List<Product> find() {
    var list = em.createQuery(FIND_ALL_QUERY, Product.class).getResultList();

    return list;
  }

  public Optional<Product> find(String id) {
    var prod = em.find(Product.class, id);

    return Optional.ofNullable(prod);
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
