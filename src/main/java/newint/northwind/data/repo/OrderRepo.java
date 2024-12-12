package newint.northwind.data.repo;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import newint.northwind.entity.Order;

@ApplicationScoped
public class OrderRepo {
  @Inject EntityManager em;

  private static String FIND_ALL_QUERY = "SELECT o FROM Order o";
  private static String FIND_QUERY = "SELECT o FROM Order o WHERE o.id = :id";

  public List<Order> find() {
    List<Order> list = em.createQuery(FIND_ALL_QUERY, Order.class).getResultList();
    return list;
    
  }

  public Order find(String id) {
    return em.createQuery(FIND_QUERY, Order.class)
      .setParameter("id", id)
      .getSingleResult();
  }

  @Transactional
  public void add(Order o) {
    em.persist(o);
  }

  @Transactional
  public void remove(String id) {
    Order o = em.find(Order.class, id);
    em.remove(o);
  }
}
