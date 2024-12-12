package newint.northwind.data.repo;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import newint.northwind.entity.Customer;

@ApplicationScoped
public class CustomerRepo {
  @Inject EntityManager em;
  
  private static String FIND_ALL_QUERY = "SELECT c FROM Customer c";
  private static String FIND_QUERY = "SELECT c FROM Customer c WHERE c.id = :id";

  public List<Customer> find() {
    List<Customer> list = em.createQuery(FIND_ALL_QUERY, Customer.class).getResultList();
    return list;
    
  }

  public Customer find(String id) {
    return em.createQuery(FIND_QUERY, Customer.class)
      .setParameter("id", id)
      .getSingleResult();
  }

  @Transactional
  public void add(Customer c) {
    em.persist(c);
  }

  @Transactional
  public void remove(String id) {
    Customer c = em.find(Customer.class, id);
    em.remove(c);
  }
  
}
